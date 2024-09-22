plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

project.ext.set("PUBLICATION_GROUP_ID", "com.mohsenoid.klogx.android")
project.ext.set("PUBLICATION_ARTIFACT_ID", "instabug")

android {
    namespace = "com.mohsenoid.klogx.android.instabug"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Instabug
    implementation(libs.instabug)

    implementation(project(":klogx:core"))

    // Test
    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.test.kotlin)
}
