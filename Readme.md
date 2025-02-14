# **Project Overview**

This project is a multi-module Maven project that publishes artifacts to a local storage.

# **Modules**

The project consists of the following modules:

**app**: Android app module

**core**: Shared code and dependencies

**tasks**: Task-related code and dependencies

**search**: Search-related code and dependencies

# **Maven Publish**
Each module is published to a local storage as an AAR file. The publish configuration is as follows:

core: mvn deploy publishes the core.aar file to ../local-repo/core.aar 

tasks: mvn deploy publishes the tasks.aar file to ../local-repo/tasks.aar 

search: mvn deploy publishes the search.aar file to ../local-repo/search.aar

# **Note:**

For now, we are publishing the AAR files to a local storage outside of this project directory, so
that another consumer app can consume these libraries. 

To upload artifacts to a remote storage, you can use the following code in respective build.gradle files:

    repositories {
         maven {
              url = uri("remote url")
         }
    }


# **Usage:**



    repositories {
        maven {
            url = uri("${rootProject.buildDir}/local-repo")
        }
    }


    dependencies {
        implementation("com.local.pscore:core:1.0.0")
        
        implementation("com.local.pscore:search:1.0.0")
        
        implementation("com.local.pscore:tasks:1.0.0")
    }
