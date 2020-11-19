package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.ProjectDTO;
import com.zikozee.ppmtool.services.MapValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectDTO projectDTO, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        ProjectDTO response = projectService.saveOrUpdateProject(projectDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@Valid @PathVariable("projectId") String projectId){

        ProjectDTO projectDTO = projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjecs(){
        return new ResponseEntity<>(projectService.findAllProject(), HttpStatus.OK);
    }

}
