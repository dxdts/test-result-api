package com.example.rez.service;

import com.example.rez.model.Feature;
import com.example.rez.model.TestInfo;

public interface TestInfoService {

    Feature addNewTestInfo(String projectName, String featureName, TestInfo testInfo);

    TestInfo getTestInfo(String projectName, String featureName);


}
