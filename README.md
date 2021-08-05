# Credify Automation Testcases 

## This project covers below test cases: 
* Selenium web automation for Credify website loan offer flow and validation       
  - Testcase Class: com.upgrade.automation.ui.test.CredifyLoanOfferUITest
* Backend Credify API automation and verification
  - Testcase Class: com.upgrade.automation.api.test.CredifyLoanOfferApiTest 

*For more info refer to: Coding Challenge PDF*
  
Project Structure
-----------------------------------

The project follows the standard Maven structure and all corresponding tests and common framework related code is present in `src/test/java` and  `src/main/java` folders. Configuration files (i.e .properties), Data files (i.e. .xlsx) and Web Driver capabilities files (*.capabilities) are present under `src/test/resources` folder.

Project Configuration and Execution
------------------------------------
The project uses Maven profiles to set configuration parameters. 
Two profile groups are supported: 
1) Specify choice of browser (currently chrome and firefox profiles are supported with chrome being default and firefox works with some exceptions)  
2) Target environment (localhost being default, others can be added for dev, qa, prod etc.)

You can run both UI and backend tests together using the below mvn command by passing chrome and localhost settings as profiles:

```
mvn -P chrome,localhost test
```
Or use the below command with profile defaults assumed to chrome and localhost:
```
mvn test
```

You can also run either UI or backend tests individually, to run just the UI test: 

```
mvn -Dtest=CredifyLoanOfferUITest test
```

And to run just the backend test: 

```
mvn -Dtest=CredifyLoanOfferApiTest test
```

Logging
-------

Project uses log4j for logging and you can adjust the log level in log4j.properties file by changing it to DEBUG / INFO / WARN depending on your needs.
