package com.zikozee.ppmtool.domain.backlog;

import com.zikozee.ppmtool.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "backlog")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Backlog extends BaseEntity {

    private Integer ptSequence = 0;
    private String projectIdentifier;

    //OneToOne with project

    //OneToMany projectTasks

}
