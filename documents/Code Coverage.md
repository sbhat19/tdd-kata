# Code Coverage 

For all test cases, it is important that coverage always analyses the whole code. This is a definitive and statistical proof that all testable code is indeed tested.

## Types of code coverage 

#### Line or Statement Coverage

 - A statement is the smallest unit in an imperative programming language that represents some action
	- Statement coverage = Number of executed statements / Total number of statements * 100
#### Branch Coverage
 - Branch coverage ensures if each decision in a decision-making tree is executed at least once. By branches we mean: conditional statements, loops, switch statements. We can calculate branch coverage using the below formula:
	 - Branch coverage = Number of executed branches / Total number of branches * 100
#### Method Coverage
 - Function coverage verifies if each function of a program is being called at least once. It is also important to test functions with different input parameters. That way, test suites will also check if functions behave properly in different scenarios.
	 - _Function coverage = Number of executed functions / Total number of functions * 100_


 **Tools For Code Coverage :**  
Below are the few important code coverage tools
-    JaCoCo
-   Cobertura
-   Clover
-   Gretel
-   Kalistick
-   JTest
-   OpenCover
-   Emma
-   GCT  
### Pros of Using Code Coverage :

-   It helps in determining the performance and quality aspects of any software.
-   It helps in evaluating quantitative measure of code coverage.
-   It helps in easy maintenance of code base.
-   It helps in accessing quality of test suite and analyzing how comprehensively a software is verified.
-   It helps in exposure of bad, dead, and unused code.
-   It helps in creating extra test cases to increase coverage.
-   It helps in developing the software product faster by increasing its productivity and efficiency.
-   It helps in measuring the efficiency of test implementation.
-   It helps in finding new test cases which are uncovered.

### Cons of Using Code Coverage

-   Some times it fails to cover code completely and correctly.
-   It can not guarantee that all possible values of a feature is tested with the help of code coverage.
-   It fails in ensuring how perfectly the code has been covered.

Verifying code coverage using IDE : 
There are many IDEs which support the feature of checking code coverage. Here example of Eclipse is shown. 

- Open the test class in editor 
- Right click either on the class or test case and select Coverage As -> Junit test
- Open the implementation class to see the number of lines covered. 
- All covered code will be shown in green and not covered lines in red.
- Based on this we can add the coverage accordingly 
- If there are conditional statements we have to write test cases for all the conditions. If its partially covered it will shown in yellow colour.

### Code coverage reporting
We have features to get the entire coverage of all the test cases in the code base. It will run the entire test suite and prepare the HTML reports similar to shown below 
![enter image description here](https://tech.asimio.net/images/maven-jacoco-coverage-report.png)

**Element** : All package details are diaplyed here. We can click and check the coverage of individual classes. 
**Missed Instructions** : Instruction coverage provides information about the amount of code that has been executed or missed.
Cov : Coverage of the entire package
**Missed Branches Cov**. : This metric counts the total number of such branches in a method and determines the number of executed or missed branches.
**Line** : Number of lines missed will be shown here. 

### Jacoco Configuration : 

Add the below plugin in pom.xml. Once the configurations are done, run mvn test to see the results under site folder. 

    <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.8</version>
             <configuration>
              <excludes>
                <excludes>**/model/**/*</excludes>
                <excludes>**/enums/**/*</excludes>
    	        <excludes>**/dto/**/*</excludes>
              </excludes>
            </configuration>
            <executions>
              <execution>
                <id>default-prepare-agent</id>
                <goals>
                  <goal>prepare-agent</goal>
                </goals>
              </execution>
              <execution>
                <id>default-report</id>
                <phase>prepare-package</phase>
                <goals>
                  <goal>report</goal>
                </goals>
              </execution>
              <execution>
                <id>default-check</id>
                <goals>
                  <goal>check</goal>
                </goals>
                <configuration>
                  <rules>
                    <rule>
                      <element>BUNDLE</element>
                      <limits>
                        <limit>
                          <counter>LINE</counter>
                          <value>COVEREDRATIO</value>
                          <minimum>0.90</minimum>
                        </limit>
                        <limit>
                          <counter>BRANCH</counter>
                          <value>COVEREDRATIO</value>
                          <minimum>0.90</minimum>
                        </limit>
                      </limits>
                    </rule>
                  </rules>
                </configuration>
              </execution>
            </executions>
          </plugin>

