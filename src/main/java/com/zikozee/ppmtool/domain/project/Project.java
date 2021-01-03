package com.zikozee.ppmtool.domain.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zikozee.ppmtool.base.BaseEntity;
import com.zikozee.ppmtool.domain.backlog.Backlog;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "project")
@Table(name = "project")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity {

    private String projectName;

    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    private String description;

    private Date startDate;

    private Date endDate;

    @Column(updatable = false)
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "project")
//    @JsonBackReference //=> check child class
    private Backlog backlog;

//    /**
//     *Every time we create or update a project the date is stored
//     */
//
//    @PrePersist
//    protected void onCreate(){
//        this.createdAt = new Date();
//    }
//
//    @PreUpdate
//    protected  void onUpdate(){
//        this.updatedAt = new Date();
//    }
}
