pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven{
            url=uri("https://www.jitpack.io")

        }
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven (url= "https://repository.liferay.com/nexus/content/repositories/public/" )

        jcenter()

    }
}

rootProject.name = "Sangeet Learner"
include(":app")
