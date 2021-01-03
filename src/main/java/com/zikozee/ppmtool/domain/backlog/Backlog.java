package com.zikozee.ppmtool.domain.backlog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zikozee.ppmtool.base.BaseEntity;
import com.zikozee.ppmtool.domain.project.Project;
import com.zikozee.ppmtool.domain.project_task.ProjectTask;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "backlog")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Backlog extends BaseEntity {

    private Integer ptSequence = 0;
    private String projectIdentifier;

    //OneToOne with project
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prooject_id", nullable = false)
//    @JsonManagedReference // => this guy will also reference the parent
    @JsonIgnore
    private Project project;

    //OneToMany projectTasks
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "backlog")
    private List<ProjectTask> projectTasks = new ArrayList<>();
}
