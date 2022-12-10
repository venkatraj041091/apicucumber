package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass{

public static void generateJVMReport(String jsonfile) throws FileNotFoundException, IOException {
		
		File file=new File(getprojectpath()+getpropertyFileValue("jsonfile"));
		Configuration configuration=new Configuration(file,"API OMRBranch Automation");
		configuration.addClassifications("jsonfile","chrome");
		configuration.addClassifications("rowser version","107");
		configuration.addClassifications("OS","WIN11");
		configuration.addClassifications("Spirit","01");
		List<String>jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonfile);
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		builder.generateReports();
	}
	
	
}
