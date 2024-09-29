plugins {
    alias(libs.plugins.gradle.bom)
    id("maven-publish")
    signing
}

bomGenerator {
    includeDependency("com.mohsenoid.klogx", "core", LibVersion.versionName)

    includeDependency("com.mohsenoid.klogx.android", "firebase", LibVersion.versionName)
    includeDependency("com.mohsenoid.klogx.android", "instabug", LibVersion.versionName)
    includeDependency("com.mohsenoid.klogx.android", "logcat", LibVersion.versionName)
    includeDependency("com.mohsenoid.klogx.android", "timber", LibVersion.versionName)
}

publishing {
    publications {
        val publication =
            create<MavenPublication>("release") {
                this.groupId = "com.mohsenoid.klogx"
                this.artifactId = "klogx-bom"
                this.version = LibVersion.bomVersion

                configurePom(projectName = project.name)
            }
        signing.sign(publication)
    }

    repositories {
        maven {
            configureUrl(isSnapshot = LibVersion.isSnapshot)
            configureCredentials()
        }
    }
}

setProperty("signing.keyId", System.getenv("MOHSENOID_SIGNING_KEY_ID"))
setProperty("signing.password", System.getenv("MOHSENOID_SIGNING_PASSWORD"))
