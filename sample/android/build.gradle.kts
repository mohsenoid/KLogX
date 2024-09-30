plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.mohsenoid.klogx.android.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mohsenoid.klogx.android.sample"

        minSdk = 24
        targetSdk = 34

        versionCode = LibVersion.versionCode
        versionName = LibVersion.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        buildConfig = true
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.timber)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.timber)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics.ktx)

    // Libs
    implementation(project(":klogx:core"))
    implementation(project(":klogx:logcat"))
    implementation(project(":klogx:timber"))
    implementation(project(":klogx:firebase"))
    implementation(project(":klogx:instabug"))

    // Released Libs
//    implementation(platform("com.mohsenoid.klogx:klogx-bom:${LibVersion.bomVersion}"))
//    implementation("com.mohsenoid.klogx:core")
//    implementation("com.mohsenoid.klogx.android:logcat")
//    implementation("com.mohsenoid.klogx.android:timber")
//    implementation("com.mohsenoid.klogx.android:firebase")
//    implementation("com.mohsenoid.klogx.android:instabug")

    // Test
    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.test.kotlin)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}
