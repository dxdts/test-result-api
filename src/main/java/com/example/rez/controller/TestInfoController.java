package com.example.rez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rez.model.Feature;
import com.example.rez.model.TestInfo;
import com.example.rez.service.TestInfoService;

import static com.example.rez.controller.BaseController.FEATURE_NAME;
import static com.example.rez.controller.BaseController.FEATURE_NAME_PATH;
import static com.example.rez.controller.BaseController.FEATURE_URL;
import static com.example.rez.controller.BaseController.PROJECT_NAME;
import static com.example.rez.controller.BaseController.PROJECT_NAME_PATH;
import static com.example.rez.controller.BaseController.PROJECT_URL;

@RestController
public class TestInfoController {
    private TestInfoService testInfoService;

    @PostMapping(PROJECT_URL + PROJECT_NAME_PATH + FEATURE_URL + FEATURE_NAME_PATH)
    public ResponseEntity<Feature> createNewTestInfo(@PathVariable(PROJECT_NAME) String projectName, @PathVariable(FEATURE_NAME) String featureName, @RequestBody TestInfo testInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testInfoService.addNewTestInfo(projectName, featureName, testInfo));
    }

    @GetMapping(PROJECT_URL + PROJECT_NAME_PATH + FEATURE_URL + FEATURE_NAME_PATH)
    public ResponseEntity<TestInfo> getTestInfoByFeature(@PathVariable(PROJECT_NAME) String projectName, @PathVariable(FEATURE_NAME) String featureName) {
        return ResponseEntity.status(HttpStatus.OK).body(testInfoService.getTestInfo(projectName, featureName));
    }

    @Autowired
    public void setTestInfoService(final TestInfoService testInfoService) {
        this.testInfoService = testInfoService;
    }
}
