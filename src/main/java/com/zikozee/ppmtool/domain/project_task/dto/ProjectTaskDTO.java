package com.zikozee.ppmtool.domain.project_task.dto;

import com.zikozee.ppmtool.base.BaseDTO;
import com.zikozee.ppmtool.domain.backlog.Backlog;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProjectTaskDTO extends BaseDTO {

    private String projectSequence;
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private Integer priority;
    private Date dueDate;
    private Backlog backlog;
    private String projectIdentifier;
}
