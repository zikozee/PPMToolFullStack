package com.zikozee.ppmtool.domain.project_task;

import com.zikozee.ppmtool.domain.backlog.Backlog;
import com.zikozee.ppmtool.domain.backlog.BacklogRepository;
import com.zikozee.ppmtool.domain.project_task.dto.CreateProjectTaskDTO;
import com.zikozee.ppmtool.domain.project_task.dto.ProjectTaskDTO;
import com.zikozee.ppmtool.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService {
    private final BacklogRepository backlogRepository;
    private final ProjectTaskRepository projectTaskRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectTaskDTO addProjectTask(String projectIdentifier, CreateProjectTaskDTO createProjectTaskDTO) {
        //Exceptions: Project not found

        //PTs to be added to a specific project, project != null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier)
                .orElseThrow(() -> new EntityNotFoundException("backlog with project id: " + projectIdentifier + " not found"));
        //set the bl to pt
        createProjectTaskDTO.setBacklog(backlog);
        // sample project sequence: IDPRO-1 IDPRO-2 ...100 101
        Integer backlogSequence = backlog.getPtSequence();
        //update the BL sequence
        backlogSequence++;
        backlog.setPtSequence(backlogSequence);

        //Add sequence to project task
        createProjectTaskDTO.setProjectSequence(projectIdentifier+ "-" + backlogSequence);
        createProjectTaskDTO.setProjectIdentifier(projectIdentifier);

        //INITIAL priority when priority null
        if(createProjectTaskDTO.getPriority() == null || createProjectTaskDTO.getPriority() ==0)
            createProjectTaskDTO.setPriority(3);
        //INITIAL status when status id null
        if(ObjectUtils.isEmpty(createProjectTaskDTO.getStatus()))
            createProjectTaskDTO.setStatus("TO_DO");

        ProjectTask projectTask = modelMapper.map(createProjectTaskDTO, ProjectTask.class);

        return modelMapper.map(projectTaskRepository.save(projectTask), ProjectTaskDTO.class);
    }
}
