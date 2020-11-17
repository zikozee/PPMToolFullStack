package com.zikozee.ppmtool.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "project")
@Table(name = "project")
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    private String description;

    private Date startDate;

    private Date endDate;

    private Date createdAt;

    private Date updatedAt;

    /**
     *Every time we create or update a project the date is stored
     */

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt = new Date();
    }
}
