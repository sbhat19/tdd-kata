# Test Pyramid

Testing Pyramid is a framework that can facilitate both developers and QA to build high-quality software. It minimises the amount of time required for developers to determine if an update they made affects the code. It also aids in developing a more robust test suite.

## Test automation pyramid functions at three levels:

-   Unit tests
-   Integration tests
-   End-to-end tests

![enter image description here](https://global-uploads.webflow.com/619e15d781b21202de206fb5/628b0dca3e6eda9219d40a6a_The-Testing-Pyramid-Simplified-for-One-and-All-1280X720%20%281%29.jpg)


### Test Pyramid for React : 

![React - Test Pyramid](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*ctALG7P-0SpQzAb8kbZNRg.png)


### Unit Test 
Unit testing serves as the foundation of the test pyramid. Unit tests have a limited scope and ensure that isolated code units function as expected. Following approaches like TDD, developers can write the unit tests to make sure the newly added code is not breaking any old functionalities.

### Integration Test
The integration test is the second step of the software testing pyramid. Unit tests check small portions of a code base. The Dev team should perform integration tests to verify the interaction of this code with other codes in the application, which generally comprise the overall software. These tests check how a code interacts with external components.These components may include external services(APIs), databases, web services, and similar elements. Integration tests ensure that the software communicates efficiently and retrieves accurate data to perform as expected.

### End-to-end Testing

End to end testing or E2E testing, as the name itself suggests, is the testing methodology that validates a software workflow from starting to end. The primary goal of E2E testing is to simulate an end user's application journey and ensure that all integrated components, dependencies, and other integrated pieces work as per expectations.
End to end testing is time consuming, requires more infrastructure than unit and integration testing, and it is relatively difficult to pinpoint exact breakage with this methodology. Yet as it covers the most accurate end user scenarios, it is also the most significant testing process as well.

## What are the benefits of the test automation pyramid?

The key advantages of the test automation pyramid are:

-   Time and cost savings
-   Elimination of human error for accuracy
-   Ability to reuse, repeat, and scale application tests to meet your software requirements

### Test Automation Tools

There are several tools available in all mainstream programming languages for writing different types of tests. We'll cover some of the popular choices in the Java world.

### 4.1. Unit Tests

-   **Test Framework**: The most popular choice here in Java is  JUnit, which has a next-generation release known as  JUnit5. Other popular choices in this area include TestNG, which offers some differentiated features compared to JUnit5. However, for most applications, both of these are suitable choices.
-   **Mocking**: As we saw earlier, we definitely want to deduct most of the dependencies, if not all, while executing a unit test. For this, we need a mechanism to replace dependencies with a test double like a mock or stub.  Mockito is an excellent framework to provision mocks for real objects in Java.
Sample Junit Tests can be found in this document : 
[JUnit using mockito ](https://www.lambdatest.com/blog/junit5-mockito-tutorial/)

- **Reporting** : There are multiple reporting tools for Junit. Few are Jacaco, etc
Below is the sample jacaco report. More details on how to configure is documented in Code coverage document in this repository. 

![enter image description here](https://tech.asimio.net/images/maven-jacoco-coverage-report.png)

### 4.2. Integration Tests

-   **Test Framework**: The scope of an integration test is wider than a unit test, but the entry point is often the same code at a higher abstraction. For this reason, the same test frameworks that work for unit testing are suitable for integration testing as well. Few of the examples are Selenium and JUnit.
-   **Mocking**: The objective of an integration test is to test an application behavior with real integrations. However, we may not want to hit an actual database or message broker for tests. Many databases and similar services offer an  embeddable version  to write integration tests with. In such cases we can setup the sample result using Mocking.

### 4.3. E2E Tests

-   **Test Framework**: End to end tests are the most expansive form of automated testing and can be the most time-consuming part of a testing cycle. They often have unreliable external dependencies like integration tests and can take a long time to set up and run. Few examples are Selenium WebDriver, Cypress, Cucumber etc

Sample Feature file used as part of Cucumber tests: 

    Feature: Login 
    Scenario: Login Functionality
    Given user navigates to the website sample.com
    And there user logs in through Login Window by using Username as "USER" and Password as "PASSWORD"
    Then login must be successful. 
The above Feature file can be executed by writing step definitions for each of the lines. Sample step definition method looks like below 

```java
@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		}
```
- **Reporting** :
Sample cucumber report is as shown below. We will get to see all the detailed result based on each feature that is covered
![enter image description here](https://qatechtools.com/wp-content/uploads/2020/05/image-4.png)


