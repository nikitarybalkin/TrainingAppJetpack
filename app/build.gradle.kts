plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt") version "1.9.23"
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.trainingappjetpack"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trainingappjetpack"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
                "proguard-rules.pro"
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    val roomVersion = "2.6.1"
    val daggerVersion = "2.48"

    implementation(project(":core"))
    implementation(project(":database"))
    implementation(project(":feature:entry"))
    implementation(project(":feature:creation"))
    implementation(project(":feature:trainings"))
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    kapt("androidx.room:room-compiler:$roomVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    ksp("com.google.dagger:dagger-compiler:$daggerVersion")
    annotationProcessor("com.google.dagger:dagger-compiler:$daggerVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("com.google.android.material:material:1.12.0")
    implementation ("com.google.dagger:dagger:$daggerVersion")
    implementation ("com.google.dagger:dagger-android-support:$daggerVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation("androidx.room:room-rxjava2:$roomVersion")
    implementation("androidx.room:room-rxjava3:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.fragment:fragment-ktx:1.8.4")
    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.8.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.8.3")
    implementation("androidx.navigation:navigation-compose:2.8.3")
    implementation("com.squareup:javapoet:1.13.0")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
}