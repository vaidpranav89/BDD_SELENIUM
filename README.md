Cucumber BDD framework

Approach

Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. Framework
has been built using Page Object Model and Page Factory. Page Object Model is a design pattern which has become popular
in test automation for enhancing test maintenance and reducing code duplication. 

### Tools And Environment


1. Eclipse
2. Java-8
3. Maven
4. Enable cucumber-java plugin in IntelliJ
5. Git

 
If using Windows OS, Configure JAVA_HOME and MAVEN_HOM in the Environmental Variables : Follow the setup instructions
specified in here https://www.mkyong.com/maven/how-to-install-maven-in-windows/



### **Executing the tests**

Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

Step-1: Clone the repository from  https://github.com/vaidpranav89/BDD_SELENIUM.git

Step-2: Use the following maven commands to run the tests.

Run all tests - Browser configration can be updated in data.properties

~~~~
mvn test verify
~~~~
 

### Cucumber Test Reports

 
Cucumber HTML reports are gerenated at path- \target\cucumber-html-reports\overview-features.html
~~~~
overview-features.html - The graphs show passing and failing statistics for features in web format
overview-steps.html    - The graph shows step statistics for this build
~~~~
Extent Reports are gernerated at path - \reports\index.html

Extent reports captures the screenshot of failed test but is not suitable for cucumber BDD. This need to be upgraaded
 

#### Logging

Log4j logging is configured in the log4j.properties to output at INFO level to the console.

Screenshots of the demo test are

![image](https://user-images.githubusercontent.com/28826960/128158785-3c69da05-3551-4029-abb3-052c56b46664.png)
![image](https://user-images.githubusercontent.com/28826960/128158802-db80d958-e250-423b-a230-54b9effbac8c.png)
![image](https://user-images.githubusercontent.com/28826960/128158812-ca4f219a-7593-42ab-8f0f-78eb04f0dbdc.png)
![image](https://user-images.githubusercontent.com/28826960/128158829-50fa2c92-6ffb-4d39-9998-01463ebe97fc.png)




