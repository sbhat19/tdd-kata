# GitHub and CODEOWNERS

This document gives an introduction to GitHub, GitHub Teams, and explains how to setup code owners.

## GitHub

GitHub is a code hosting platform for collaboration and [version control](https://www.geeksforgeeks.org/version-control-systems/). GitHub lets you (and others) work together on projects.

Basic terminologies used in GitHub are:

- [Git](https://git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F#what_is_git_section)
- [Repositories](https://docs.github.com/en/repositories/creating-and-managing-repositories/about-repositories)
- [Branches](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-branches)
- [Commits](https://docs.github.com/en/pull-requests/committing-changes-to-your-project/creating-and-editing-commits/about-commits)
- [Pull Requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)

In GitHub organizations can be used to collaborate with many people accross multiple projects, while managing access to your data and customizing settings.

## Organizing members into teams

Teams are group of organization members that reflect your company or group's sturcutre with cascading access permissions and mentions. Organization owneres and team maintainers can give teams admin, read or write access to organization repositories.

More documentation about GitHub teams can be found [here](https://docs.github.com/en/organizations/organizing-members-into-teams/about-teams).

### Advantages of teams

- Organization owners and team maintainers can give teams admin, read, or write access to organization repositories. 
_ Organization members can send a notification to an entire team by mentioning the team's name.
- Organization members can request reviews from specific teams with read access to the repository where the pull request is opened.
- Teams can be designated as owners of certain types or areas of code in a CODEOWNERS file.

## Repository roles for an organization

You can give organization members, outside collaborators, and teams of people different levels of access to repositories owned by an organization by assigning them to roles. Choose the role that best fits each person or team's function in your project without giving people more access to the project than they need.

From least access to most access, the roles for an organization repository are:

- **Read**: Recommended for non-code contributors who want to view or discuss your project
- **Triage**: Recommended for contributors who need to proactively manage issues and pull requests without write access
- **Write**: Recommended for contributors who actively push to your project
- **Maintain**: Recommended for project managers who need to manage the repository without access to sensitive or destructive actions
- **Admin**: Recommended for people who need full access to the project, including sensitive and destructive actions like managing security or deleting a repository

### Advantages of repository roles

- Organization owners can set base permissions that apply to all members of an organization when accessing any of the organization's repositories.
- Organization owners can also choose to further limit access to certain settings and actions across the organization. 

## GitHub CODEOWNERS

You can use CODEOWNERS file to define individuals or teams that are responsible for code in a repository.

People with admin or owner permissions can set up a CODEOWNERS file in a repository. The people you choose as code owners must have write permissions for the repository. When the code owner is a team, the team must be visible and it must have write permissions.

### Advantages of using CODEOWNERS file

- Code owners are automatically requested for review when someone opens a pull request.
- Furthermore, [branch protection rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/about-protected-branches) can be added to ensure the code change is reviewed by the owners before it is merged.

## Setting up CODEOWNERS file location

CODEOWNERS file must be created in one of the following locations in the repository:

- root directory
- under `docs/` directory
- under `.github/` directory

CODEOWNERS file size must be under 3 MB.

## CODEOWNERS syntax and example

A CODEOWNERS file uses a pattern that follows most of the same rules used in gitignore files. The pattern is followed by one or more GitHub usernames or team names using the standard `@username` or `@org/team-name` format. Users and teams must have explicit write access to the repository, even if the team's members already have access.

Example of CODEOWNERS file

```text
# Each line is a file pattern followed by one or more owners.

# These owners will be the default owners for everything in the repo. Unless a later match takes precedence, @global-owner1 and @global-owner2 will be 
# requested for review when someone opens a pull request.
*  @global-owner1 @global-owner2**

# Order is important; the last matching pattern takes the most precedence. When someone opens a pull request that only modifies JS files, only @js-owner
# and not the global owner(s) will be requested for a review.
*.js  @js-owner #This is an inline comment.

# You can also use email addresses if you prefer. They'll be used to look up users just like we do for commit author emails.
*.go  docs@example.com

# Teams can be specified as code owners as well. Teams should be identified in the format @org/team-name. Teams must have explicit write access to the
# repository. In this example, the octocats team in the octo-org organization owns all .txt files.
*.txt  @octo-org/octocats

# In this example, @doctocat owns any files in the build/logs directory at the root of the repository and any of its subdirectories.
/build/logs/ @doctocat

# The `docs/*` pattern will match files like `docs/getting-started.md` but not further nested files like `docs/build-app/troubleshooting.md`.
docs/*  docs@example.com

# In this example, @octocat owns any file in an apps directory anywhere in your repository.
apps/  @octocat

# In this example, @doctocat owns any file in the `/docs` directory in the root of your repository and any of its subdirectories.
/docs/  @doctocat

# In this example, any change inside the `/scripts` directory will require approval from @doctocat or @octocat.
/scripts/ @doctocat @octocat

# In this example, @octocat owns any file in the `/apps` directory in the root of your repository except for the `/apps/github`
# subdirectory, as its owners are left empty.
/apps/ @octocat
/apps/github
```
