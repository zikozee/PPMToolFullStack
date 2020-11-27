package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.CreateProjectDTO;
import com.zikozee.ppmtool.project.dto.QueryProjectDTO;
import com.zikozee.ppmtool.project.dto.UpdateProjectDTO;
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
@CrossOrigin({"http://localhost:3000"})
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody CreateProjectDTO createProjectDTO, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        QueryProjectDTO response = projectService.createProject(createProjectDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@Valid @RequestBody UpdateProjectDTO updateProjectDTO, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        QueryProjectDTO response = projectService.updateProject(updateProjectDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<QueryProjectDTO> getProjectById(@Valid @PathVariable("projectId") String projectId){

        QueryProjectDTO queryProjectDTO = projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<>(queryProjectDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<QueryProjectDTO>> getAllProjects(){
        return new ResponseEntity<>(projectService.findAllProject(), HttpStatus.OK);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable("projectId") String projectId){
        return new ResponseEntity<>(projectService.deleteProjectByIdentifier(projectId), HttpStatus.OK);
    }

}
