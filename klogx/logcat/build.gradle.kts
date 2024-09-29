plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dokka)
    id("maven-publish")
    signing
}

android {
    namespace = "com.mohsenoid.klogx.android.logcat"
    compileSdk = 34

    defaultConfig {
        minSdk = 16

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    publishing {
        singleVariant("release") {
            // if you don't want sources/javadoc, remove these lines
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(project(":klogx:core"))

    // Test
    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.test.kotlin)
}

afterEvaluate {
    publishing {
        publications {
            val publication =
                create<MavenPublication>("release") {
                    this.groupId = "com.mohsenoid.klogx.android"
                    this.artifactId = "logcat"
                    this.version = LibVersion.versionName

                    from(components["release"])

                    configurePom(projectName = project.name, packaging = "aar")
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
