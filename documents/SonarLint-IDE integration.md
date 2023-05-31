# SonarLint 

SonarLint is a free IDE extension that integrates with SonarCloud. It enables you to code better with on-the-fly analysis and support for hundreds of deep static analysis rules to detect common mistakes, tricky bugs, and security issues.

SonarLint integrates with most IDE's such as Visual Studio, VS Code, Eclipse, PyCharm, WebStorm, PHPStorm and  Android Studio. Supported languages include C, C++, Java, JavaScript, TypeScript, Python, C#, Kotlin, Ruby, HTML & PHP.

SonarLint isn't just about your code, it's also an opportunity to bring your passion for quality code to the whole team. When paired with  [SonarQube](https://www.sonarsource.com/products/sonarqube/)  or  [SonarCloud](https://www.sonarsource.com/products/sonarcloud/), your team can share common language rulesets, project analysis settings and  [more](https://www.sonarlint.org/bring-your-team-on-board/). The combination forms a continuous analysis solution that keeps code quality and security issues out of your branches.

SonarLint requires your IDE to be run with a JVM 11+ (this is the case for all recent JetBrains IDE); the analysis of JavaScript and TypeScript requires Node.js >= 14.20 to be installed on your computer (Node.js >= 16 is recommended).

## Integrating SonarLint with IDE

### Eclipse
Below are the steps to integrate it with Eclipse.

 - Open eclipse and click on Help menu
 - Click on Eclipse Marketplace and search for sonarLint
 - Click on install and make sure that's the latest version
 - Restart eclipse when prompted

Now all the projects that is imported into eclipse will be analysed by sonarLint. Based on the suggestions which are given we can make modifications in the code. 

### Enabling and disabling SonarLint rules in Eclipse

 - Click on Windows --> Preference
 - Click SonarLint from the options listed
	 - Analyzer Properties : These properties can be used to configure analyzers. There are currently very few properties that you may pass. For example the JavaScript analyzer accept a property sonar.javascript.jQueryObjectAliases
	 - File Exclusions : We can exclude any file from being analysed. Need to give the path of the file in this section.
	 - Rules Configuration : We can enable or disable rules specific to language. If we need to change any rule for Java, navigate to Java section and modify the rule.

## VS Code Integration 
### Perquisites 

 - Launch VS Code --> Go to extensions --> Search "Install C# for Visual Studio Code (powered by OmniSharp) " --> Install the extension
 -  SonarLint needs Java Run Time(JRE) 8 or 11
 - Search "Language Support for Java(TM) By Red Hat" --> Install the extension
 -  Search "SonarLint" extension --> Install the extension

 
### Binding SonarLint with SonarCloud in Eclipse

 - Navigate to https://sonarcloud.io/ and login with github login credentials
 - Select My Account --> Security 
 - Give a name and generate a token. Save this for using while binding SonarLint with SonarCloud. 
 - Once the SonarLint is configured as per the above steps we will get SonarLint option when we right click on our project.
 - Below are the options we get when we click on SonarLint
	 - Analyze Changed files : This will analyse only the recently changed files and display the results in a separate window
	 - Analyse : This will analyze the entire codebase and give the results.
	 - Bind Project with SonarCloud or SonarLint : This we can confirgure using the token that was generated in the SonarCloud. We have to select the Organization and the codebase when asked for.
Once the binding is done all the features and rules that are available in the SonarCloud will be applied to SonarLint in eclipse.
	 

References : 
[SonarLint Documentation](https://docs.sonarcloud.io/improving/sonarlint/)