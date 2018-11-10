# Current Status

[![Build Status](https://travis-ci.com/tapanagkumar/LocalSearchdotcom.svg?branch=master)](https://travis-ci.com/tapanagkumar/LocalSearchdotcom)
# CucumberFramework for LocalSearch Using Java

This project demonstrates Searching using Local Search Search Engine.
## Pre-requisites

- <a href="https://java.com/en/download/manual.jsp" target="_blank">Java</a>
- <a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a>
- <a href="https://eclipse.org/downloads/" target="_blank">Eclipse</a>
- Eclipse Plugins
  - <a href="http://download.eclipse.org/technology/m2e/releases/1.4" target="_blank">Maven</a> 
  - <a href="http://cucumber.github.io/cucumber-eclipse/update-site/" target="_blank">Cucumber</a>
  
  
 ### Setting up CucumberFramework using Java
- Install Java(Recommended: Java 8 ) and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
	- maven : https://github.com/tapanagkumar/LocalSearchdotcom.git


 ### Directory layout
```
├───.settings
├───src
│   ├───main
│   │   └───java
│   │       ├───pages
│   │       │   ├───actions        	#Action Files which perform the main action based on Locators
│   │       │   └───locators		#Object Repository
│   │       └───utils			#Utility Files
│   └───test
│       ├───java
│       │   ├───runners			#Cucumber TestNg Runner class
│       │   └───steps			#Step Definations
│       └───resources
│           ├───FeatureFiles		#Cucumber Feature Files 
│           └───runner			#Testng.xml
└───target
    ├───classes
    │   ├───pages
    │   │   ├───actions
    │   │   └───locators
    │   └───utils
    ├───Extent_Reports			# Location of the Reports
```
    
 ### Writing a test

- The cucumber features goes in the `features` library and should have the ".feature" extension.
- You can start out by looking at `\src\test\resources\FeatureFiles`.

### Running the tests

- From Command line goto project directory.
- Run the below command to run the tests in firefox

`$ mvn test -Dbrowser=firefox`

- Run the below command to run the tests in Chrome

`$ mvn test -Dbrowser=chrome`

- By default the tests are run in Headless mode. To change, set chromeOptions.setHeadless(false) in SeleniumDriver.java file available in utils folder.

### HTML Reports

- HTML reports can be viewed from `\target\Extent_Reports` location


### Tests Covered

- Feature 1: Test to Search for an Item from Search field.

- Feature 2: Test to Search for an Item from Popular Searchers.
