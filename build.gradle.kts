plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

allprojects {
    apply(plugin = rootProject.libs.plugins.ktlint.get().pluginId)
    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)

    detekt {
        allRules = true
        config = files("$rootDir/config/detekt/detekt-config.yml")
        baseline = file("detekt-baseline.xml")
        buildUponDefaultConfig = true
    }
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}
