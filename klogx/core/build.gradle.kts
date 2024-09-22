plugins {
    alias(libs.plugins.kotlin.jvm)
}

project.ext.set("PUBLICATION_GROUP_ID", "com.mohsenoid.klogx")
project.ext.set("PUBLICATION_ARTIFACT_ID", "core")

dependencies {
    testImplementation(libs.bundles.test)
}
