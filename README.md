# Thymeleaf & IntelliJ Bug
## Issue
Recent versions of Intellj appear to have a bug in regard to Thymeleaf recognizing model attributes.
### References
https://youtrack.jetbrains.com/issue/IDEA-294863/Thymeleaf-plugin-cant-resolve-any-reference  
https://youtrack.jetbrains.com/issue/IDEA-205382/Spring-MVC-Thymeleaf-model-attributes-are-not-resolved-in-the-included-templates  
https://stackoverflow.com/q/38710585/18972352
## Solution(s)
One solution is to declare external variables in comment annotation by specifying type. This workaround is unhelpful and possibly even detrimental for debugging purposes, however.
Another/Other solution(s) may be downgrading from IntelliJ Ultimate 2022.2/2022.1 to Intellij Ultimate < 2022.1, or/and downgrading/upgrading from Spring Boot 2.7.0.  
  
This bug is fixed when using Java 18, Spring 2.6.8, and IntelliJ Ultimate 2022.1. It appears to be an issue with Spring Boot 2.7.0 but more testing is needed to confirm this. I will share the correct solution on StackOverflow and JetBrains bug tracking message board, YouTrack, when I narrow this down.

This bug is present when using > Spring 2.6.8 and > IntelliJ Ultimate 2022.1, including the early access version: 2022.2. The issue appears to be independent of both the Java release and the IntelliJ release. It appears to be an issue with > Spring 2.6.8. Spring Initializr is used to create the project.  

Eclipse for Enterprise and Web Developers with the Spring Tools 4 and Thymeleaf plugins installed does not support the same level of detail with both the syntax highlighting and documentation of Thymeleaf that IntelliJ Ultimate does. This specific bug therefore is not relevant for Eclipse.  

The best way to proceed is to develop any Spring applications using the Thymeleaf templating engine with Spring version 2.6.8 on IntelliJ Ultimate, and later update the version to 2.70 or the latest milestone version (currently 3.0.0 M3) in your pom.xml or build.gradle file for security purposes due to the possible presence of CVEs (Common Vulnerabilities and Exposures) in Spring < 2.7.0 / 3.0.0 M3 itself and/or any dependencies of Spring < 2.7.0 / 3.0.0 M3. 

### References
https://stackoverflow.com/a/44804086/18972352  
https://youtrack.jetbrains.com/issue/IDEA-294863/Thymeleaf-plugin-cant-resolve-any-reference#focus=Comments-27-6113490.0-0

# Input Validation
## Issue
I ran into complications with input validation via Hibernate Validator and feeding the resulting errors to BindingResult which needs to be looked at further.

## Solution(s)
Using the Spring default Validator with the Java Common Annotation Module works if you also exclude Hibernate Validator. This is not an ideal solution though as the Java Common Annotation Module was deprecated in Java 11, and the Spring default Validator is missing annotations included in Hibernate Validator. 

### References
https://stackoverflow.com/a/47454789/18972352  
https://stackoverflow.com/a/27824439/18972352
