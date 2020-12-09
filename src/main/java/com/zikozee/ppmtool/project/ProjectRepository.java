package com.zikozee.ppmtool.project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findByProjectIdentifier(String projectIdentifier);

    boolean existsByProjectIdentifier(String projectIdentifier);
}
