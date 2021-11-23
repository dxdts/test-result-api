package com.example.rez.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {

    @Id
    @Column(name = "projectName", nullable = false, unique = true)
    private String name;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.EAGER)
    private List<Feature> features = new ArrayList<>(10);
}
