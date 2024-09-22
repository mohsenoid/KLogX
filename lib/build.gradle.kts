plugins {
    alias(libs.plugins.kotlin.jvm)
}

project.ext.set("PUBLICATION_GROUP_ID", "com.mohsenoid")
project.ext.set("PUBLICATION_ARTIFACT_ID", "KLogX")

dependencies {
    implementation(libs.kotlin.stdlib)

    testImplementation(libs.bundles.test)
}
