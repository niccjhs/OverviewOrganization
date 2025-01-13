plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.overvieworganization"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.overvieworganization"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
//    // ( json 관련 )
    //implementation ("com.google.code.gson:gson:2.10.1")
    //implementation ("org.jsoup:jsoup:1.17.2")
    implementation (libs.google.gson)
    implementation (libs.jsoup)


    // Note: Navigation 사용하기 위해 추가
//    implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation(libs.androidx.navigation.compose)

    // NOTE: viewModel() 사용하기 위해 추가
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation(libs.androidx.lifecycle.viewmodel.compose)


////    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
//    implementation(libs.androidx.lifecycle.runtime.compose)

    // NOTE: observeAsState 사용하기 위해 추가
//    implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
    implementation(libs.androidx.runtime.livedata)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}