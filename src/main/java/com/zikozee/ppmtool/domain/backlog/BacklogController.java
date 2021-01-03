package com.zikozee.ppmtool.domain.backlog;

import com.zikozee.ppmtool.domain.project_task.ProjectTask;
import com.zikozee.ppmtool.domain.project_task.ProjectTaskService;
import com.zikozee.ppmtool.domain.project_task.dto.CreateProjectTaskDTO;
import com.zikozee.ppmtool.domain.project_task.dto.ProjectTaskDTO;
import com.zikozee.ppmtool.services.MapValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/backlog")
@RequiredArgsConstructor
public class BacklogController {
    private final ProjectTaskService projectTaskService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping("/{backlogId}")
    public ResponseEntity<?> addProjectTaskToBacklog(@Valid @RequestBody CreateProjectTaskDTO createProjectTaskDTO, BindingResult result,
                                                     @PathVariable("backlogId") String backlogId){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        ProjectTaskDTO projectTaskDTO = projectTaskService.addProjectTask(backlogId, createProjectTaskDTO);

        return new ResponseEntity<>(projectTaskDTO, HttpStatus.CREATED);
    }
}
