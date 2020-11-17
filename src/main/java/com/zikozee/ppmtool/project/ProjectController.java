package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectDTO projectDTO, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("Invalid Object", HttpStatus.BAD_REQUEST);
        }
        ProjectDTO response = projectService.saveOrUpdateProject(projectDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
