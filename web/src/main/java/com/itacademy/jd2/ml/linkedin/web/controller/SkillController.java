package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ISkillService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.SkillFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.SkillToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.SkillDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/skill")
public class SkillController extends AbstractController {

    private ISkillService skillService;
    private SkillToDTOConverter toDTOConverter;
    private SkillFromDTOConverter fromDTOConverter;

    private IUserAccountService userAccountService;

    @Autowired
    public SkillController(ISkillService skillService, SkillToDTOConverter toDTOConverter, SkillFromDTOConverter fromDTOConverter, IUserAccountService userAccountService) {
        this.skillService = skillService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.userAccountService = userAccountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final SkillFilter filter = new SkillFilter();
        prepareFilter(gridState, filter);

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<ISkill> skills = loggedUser.getSkills();

        List<SkillDTO> skillsDTO = skills.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(skillsDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("skills", skillsDTO);
        return new ModelAndView("profile.skill.list", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final ISkill newEntity = skillService.createEntity();
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("skill", toDTOConverter.apply(newEntity));

        return new ModelAndView("profile.skill.form", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("skill") final SkillDTO skillDTO,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.skill.form";
        } else {
            final ISkill entity = fromDTOConverter.apply(skillDTO);
            skillService.save(entity);
            return "redirect:/skill";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        skillService.delete(id);
        return "redirect:/skill";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final ISkill skill = skillService.getFullInfo(id);
        final SkillDTO dto = toDTOConverter.apply(skill);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("skill", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.language.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final ISkill skill = skillService.getFullInfo(id);
        final SkillDTO dto = toDTOConverter.apply(skill);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("skill", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("profile.skill.form", hashMap);
    }


}
