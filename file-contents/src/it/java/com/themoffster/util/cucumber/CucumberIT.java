package com.themoffster.util.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/it/resources/com/themoffster/util/cucumber")
public class CucumberIT {
}
