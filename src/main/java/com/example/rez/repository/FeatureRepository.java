package com.example.rez.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rez.model.Feature;

@Repository
public interface FeatureRepository extends CrudRepository<Feature, Long> {

    @Override
    List<Feature> findAll();

    Feature findByName(String name);
}
