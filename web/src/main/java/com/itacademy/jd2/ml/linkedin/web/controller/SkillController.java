package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IGroupSkillService;
import com.itacademy.jd2.ml.linkedin.ISkillService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Skill;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.SkillFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.GroupSkillToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.SkillLoaderToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.SkillToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.SkillDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.GroupSkillDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/skill")
public class SkillController extends AbstractController {

    private ISkillService skillService;
    private SkillToDTOConverter toDTOConverter;
    private SkillFromDTOConverter fromDTOConverter;

    private IUserAccountService userAccountService;
    private IGroupSkillService groupSkillService;
    private GroupSkillToDTOConverter groupSkillToDTOConverter;
    private SkillLoaderToDTOConverter skillLoaderToDTOConverter;

    @Autowired
    public SkillController(ISkillService skillService, SkillToDTOConverter toDTOConverter, SkillFromDTOConverter fromDTOConverter, IUserAccountService userAccountService, IGroupSkillService groupSkillService, GroupSkillToDTOConverter groupSkillToDTOConverter, SkillLoaderToDTOConverter skillLoaderToDTOConverter) {
        this.skillService = skillService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.userAccountService = userAccountService;
        this.groupSkillService = groupSkillService;
        this.groupSkillToDTOConverter = groupSkillToDTOConverter;
        this.skillLoaderToDTOConverter = skillLoaderToDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final SkillFilter filter = new SkillFilter();
        prepareFilter(gridState, filter);

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<ISkill> skills = loggedUser.getSkills()
                .stream().map(iSkill -> skillService.getFullInfo(iSkill.getId())).collect(Collectors.toSet());

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("skill") final SkillDTO skillDTO, @RequestParam("id") Integer skillId,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.skill.form";
        } else {
            ISkill entity = fromDTOConverter.apply(skillDTO);
            IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
            Set<ISkill> skills = loggedUser.getSkills();
            skills.add(entity);
            loggedUser.setSkills(skills);
            userAccountService.save(loggedUser);
            return "redirect:/skill";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        /*Predicate<ISkill> isEquels = iSkill -> iSkill.getId() == id;*/
        ISkill entity = skillService.createEntity();
        entity.setId(id);
        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
        Set<ISkill> skills = loggedUser.getSkills();
        skills.removeIf(iSkill -> iSkill.getId() == id);
        loggedUser.setSkills(skills);
        userAccountService.save(loggedUser);
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

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ResponseEntity<List<GroupSkillDTO>> getRegions() {
        final List<IGroupSkill> groups = groupSkillService.getAll();
        List<GroupSkillDTO> groupsDTO = groups.stream().map(groupSkillToDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<List<GroupSkillDTO>>(groupsDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public ResponseEntity<List<SkillDTO>> getCountries(
            @RequestParam(name = "groupId", required = true) final Integer groupId) {
        final List<ISkill> skills = skillService.findByGroupId(groupId);
        List<SkillDTO> skillsDTO = skills.stream().map(skillLoaderToDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<List<SkillDTO>>(skillsDTO, HttpStatus.OK);
    }


}
