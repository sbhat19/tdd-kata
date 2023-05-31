# SonarCloud

SonarCloud is a cloud-based code analysis service designed to detect coding issues in [26 different programming languages](https://docs.sonarcloud.io/advanced-setup/languages/overview/). By integrating directly with your CI pipeline or one of our [supported DevOps platforms](https://docs.sonarcloud.io/getting-started/overview/), your code is checked against an extensive set of rules that cover many attributes of code, such as maintainability, reliability, and security issues on each merge/pull request.

The Sonar solution helps developers perform checks at every stage of the development process:
 
-   SonarLint provides immediate feedback in your IDE as you write code so you can find and fix issues before a commit.
-   SonarCloud’s PR analysis fits into your cloud-based CI/CD workflows so that you merge clean code every time.
-   Quality Gates keep code with issues from being released to production, a key tool in helping you incorporate the Clean as You Code methodology.
-   The  [Clean as You Code](https://docs.sonarcloud.io/improving/clean-as-you-code/)  approach helps you focus on submitting new, Clean Code for production, knowing that your existing code will be improved over time.


<img src="https://assets-eu-01.kc-usercontent.com/45554007-c9f6-0134-9bf0-9aec95d195dd/72530efa-070a-485c-8f6b-e1a71fdcce19/sonar-development-workflow%20%281%29.png?w=2912&h=1658&auto=format&fit=crop"/>

# Setting Your Standards

In SonarCloud, code quality and code security standards are enforced through two mechanisms: _quality profiles_ and _quality gates_.

Every project has a _quality profile_ set for each supported language. The profile defines which rules will be applied during analysis.

After analysis, the _quality gate_ takes the resulting metrics and compares them to its defined thresholds to determine if the code meets the requirements for release or merge.

The quality profile and quality gate of every new project are set to built-in defaults, (called _Sonar way_). The Sonar way quality profile and quality gate represent the optimum combination of rules and thresholds for most projects, guiding developers in using  [Clean as You Code](https://docs.sonarcloud.io/improving/clean-as-you-code/)  principles to improve code quality and code security.

# Improving Your Code

SonarCloud is designed to be integrated into your daily development workflow so that analysis results are surfaced as early as possible each time you make changes to your code. The focus is on catching issues early in the cycle before they become embedded in the codebase.

SonarCloud provides multiple layers of defense to keep your code clean:

1.  Catch issues before they even exist: In-IDE analysis with SonarLint.
2.  Catch issues before they are committed to your main branch: Pull request analysis.
3.  Catch issues every time you push to the main branch: Main branch analysis.

https://docs.sonarcloud.io/improving/overview/

 
# Metric Definitions

SonarCloud analysis produces many types of code analysis metrics.

**Quality Gate Status** (`alert_status`) State of the quality gate associated to your project. Possible values are : `ERROR`, `OK` WARN value has been removed since 7.6.

**Lines of code** (`ncloc`) Number of physical lines that contain at least one character which is neither a whitespace nor a tabulation nor part of a comment.

**Coverage** (`coverage`) It is a mix of line coverage and condition coverage. Its goal is to provide an even more accurate answer to the following question: How much of the source code has been covered by the unit tests? 

**Security Rating** (`security_rating`) A = 0 Vulnerabilities B = at least 1 Minor Vulnerability C = at least 1 Major Vulnerability D = at least 1 Critical Vulnerability E = at least 1 Blocker Vulnerability

https://docs.sonarcloud.io/digging-deeper/metric-definitions/


# Integration Steps

 - Navigate to your sonar cloud account
 - Navigate to the specific project which needs to be configured
 - Click on Configure
 - From the "Choose Analysis Method" , select the "With Github action"
 - Createa Github secret, in your GitHub repository, go to  [Settings > Secrets > Actions](https://github.com/Thoughtfocus-arb/.net-reference-implementation/settings/secrets)  and create a new secret with the following details:
	In the Name field, enter SONAR_TOKEN
	In the Value field, enter copy the value from the "With Github action page."
	
 - Update the POM file with the following properties
		 `<properties>  
<sonar.organization>thoughtf0cus-arb102938</sonar.organization>  <sonar.host.url>https://sonarcloud.io</sonar.host.url>  </properties>`
 - Create the file under the main repo in the following location,  .github/workflows/build.yml and copy the action and paste under the build.yml file
 - merge this changes to the main branch
	 - You’ll get a first analysis of your default branch.
	 - Each new push you make on a branch or Pull Request will automatically trigger a new analysis.
	 -  Each new Pull Request you create will automatically be analyzed

