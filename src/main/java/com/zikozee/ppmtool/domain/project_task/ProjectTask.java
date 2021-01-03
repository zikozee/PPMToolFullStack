package com.zikozee.ppmtool.domain.project_task;

import com.zikozee.ppmtool.base.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "project_task")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectTask extends BaseEntity {

    @Column(updatable = false)
    private String projectSequence;
    @NotBlank(message ="please include a project summary")
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private Integer priority;
    private Date dueDate;

    //ManyToOne with Backlog

    @Column(updatable = false)
    private String projectIdentifier;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
}
