plugins {
    alias(libs.plugins.kotlin.jvm)
}

project.ext.set("PUBLICATION_GROUP_ID", "com.mohsenoid")
project.ext.set("PUBLICATION_ARTIFACT_ID", "KLogX")

dependencies {
    testImplementation(libs.bundles.test)
}
