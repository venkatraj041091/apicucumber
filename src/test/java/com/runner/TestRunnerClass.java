package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		tags=(""),
		publish=true,
		stepNotifications = true,
		monochrome=true,
		dryRun = false,
		snippets = io.cucumber.junit.CucumberOptions.SnippetType.UNDERSCORE,
		plugin= {"pretty","json:target\\output.json"},
		features="src\\test\\resources\\Features",
		glue="com.StepDefination"
		)
public class TestRunnerClass extends BaseClass{
	
	@AfterClass
	public static void afterclass() throws FileNotFoundException, IOException  {

		Reporting.generateJVMReport(getprojectpath()+getpropertyFileValue("JVMReport"));

	}

}


