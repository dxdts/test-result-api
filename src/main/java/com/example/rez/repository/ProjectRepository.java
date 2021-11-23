package com.example.rez.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rez.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByName(String name);

    @Override
    List<Project> findAll();


}
