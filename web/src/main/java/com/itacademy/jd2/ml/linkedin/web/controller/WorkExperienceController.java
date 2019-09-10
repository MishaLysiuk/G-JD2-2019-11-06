package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.IWorkExperienceService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.WorkExperienceFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.WorkExperienceToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.WorkExperienceDTO;
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
@RequestMapping(value = "/work-experience")
public class WorkExperienceController extends AbstractController {

    private IWorkExperienceService workExperienceService;
    private WorkExperienceToDTOConverter toDTOConverter;
    private WorkExperienceFromDTOConverter fromDTOConverter;

    private IUserAccountService userAccountService;

    @Autowired
    public WorkExperienceController(IWorkExperienceService workExperienceService, WorkExperienceToDTOConverter toDTOConverter, WorkExperienceFromDTOConverter fromDTOConverter, IUserAccountService userAccountService) {
        this.workExperienceService = workExperienceService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.userAccountService = userAccountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final WorkExperienceFilter filter = new WorkExperienceFilter();
        prepareFilter(gridState, filter);

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<IWorkExperience> workExperience = loggedUser.getWorkExperiences();

        List<WorkExperienceDTO> workExperienceDTO = workExperience.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(workExperienceDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("workExperienceList", workExperienceDTO);
        return new ModelAndView("profile.work-experience.list", hashMap);

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final IWorkExperience newEntity = workExperienceService.createEntity();
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("workExperience", toDTOConverter.apply(newEntity));

        return new ModelAndView("profile.work-experience.form", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("education") final WorkExperienceDTO workExperienceDTO,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.work-experience.form";
        } else {
            final IWorkExperience entity = fromDTOConverter.apply(workExperienceDTO);
            workExperienceService.save(entity);
            return "redirect:/work-experience";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        workExperienceService.delete(id);
        return "redirect:/work-experience";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IWorkExperience workExperience = workExperienceService.getFullInfo(id);
        final WorkExperienceDTO dto = toDTOConverter.apply(workExperience);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("workExperience", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.education.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IWorkExperience workExperience = workExperienceService.getFullInfo(id);
        final WorkExperienceDTO dto = toDTOConverter.apply(workExperience);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("workExperience", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("profile.work-experience.form", hashMap);
    }

}
