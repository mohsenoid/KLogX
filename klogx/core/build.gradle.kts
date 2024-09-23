plugins {
    alias(libs.plugins.kotlin.jvm)
    id("publish")
}

project.ext.set("PUBLICATION_GROUP_ID", "com.mohsenoid.klogx")
project.ext.set("PUBLICATION_ARTIFACT_ID", "core")
project.ext.set("PUBLICATION_PACKAGING", "jar")
project.ext.set("PUBLICATION_VERSION", LibVersion.versionName)

dependencies {
    testImplementation(libs.bundles.test)
}
