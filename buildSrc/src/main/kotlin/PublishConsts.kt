import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication

fun MavenPublication.configurePom(projectName: String, packaging: String) {
    pom {
        name.set(projectName)
        this.packaging = packaging
        description.set("KLogX ($projectName)")
        url.set("https://mohsenoid.com")

        configureLicense()

        configureDeveloper()

        configureScm()
    }
}

fun MavenPom.configureLicense() {
    licenses {
        license {
            name.set("The Apache License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        }
    }
}

fun MavenPom.configureDeveloper() {
    developers {
        developer {
            id.set("mohsenoid")
            name.set("Mohsen Mirhoseini")
            email.set("contact@mohsenoid.com")
        }
    }
}

fun MavenPom.configureScm() {
    scm {
        url.set("https://github.com/mohsenoid/KLogX")
        connection.set("scm:git:git@github.com:mohsenoid/KLogX.git")
        developerConnection.set("scm:git:git@github.com:mohsenoid/KLogX.git")
    }
}

fun MavenArtifactRepository.configureUrl(isSnapshot: Boolean) {
    val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
    val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

    val repoUrl = if (isSnapshot) snapshotsRepoUrl else releasesRepoUrl

    setUrl(repoUrl)
}

fun MavenArtifactRepository.configureCredentials() {
    credentials {
        username = System.getenv("MOHSENOID_S01_OSSRH_USERNAME")
        password = System.getenv("MOHSENOID_S01_OSSRH_PASSWORD")
    }
}
