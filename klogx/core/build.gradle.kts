plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.dokka)
    id("maven-publish")
    signing
}

dependencies {
    testImplementation(libs.bundles.test)
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource.toList())
}

val dokkaJar by tasks.registering(Jar::class) {
    dependsOn("dokkaHtml")
    archiveClassifier.set("javadoc")
    from(tasks.getByName("dokkaHtml"))
}

afterEvaluate {
    publishing {
        publications {
            val publication =
                create<MavenPublication>("release") {
                    this.groupId = "com.mohsenoid.klogx"
                    this.artifactId = "core"
                    this.version = LibVersion.versionName

                    from(components["java"])

                    artifact(sourcesJar)
                    artifact(dokkaJar)

                    configurePom(projectName = project.name, packaging = "jar")
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
}
