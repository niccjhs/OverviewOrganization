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
    // ( json 관련 )
    //implementation ("com.google.code.gson:gson:2.10.1")
    //implementation ("org.jsoup:jsoup:1.17.2")
    implementation (libs.google.gson)
    implementation (libs.jsoup)

    // ( 영상 표출 )
    //implementation ("com.google.android.exoplayer:exoplayer-core:2.19.1")
    //implementation ("com.google.android.exoplayer:exoplayer-dash:2.19.1")
    //implementation ("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    implementation (libs.exoplayer.core)
    implementation (libs.exoplayer.dash)
    implementation (libs.exoplayer.ui)

    // ( Retrofit )
    //implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.converter.scalars)

    // ( 보드 API )
    //implementation(files("libs/XHApi.jar"))//old
    //implementation(files("libs/toolkit.jar"))//new

    // ( 롬복 )
    //implementation("org.projectlombox:lombox")
    //annotationProcessor("org.projectlombox:lombox")
    //implementation(libs.org.projectlombox.lombox)
    //annotationProcessor(libs.projectlombox.lombox)

    // ( 애니메이션 )
    //implementation("com.daimajia.easing:library:2.0@aar")
    //implementation("com.daimajia.androidanimations:library:2.3@aar")
    //implementation(libs.library)
    //implementation(libs.androidanimations.library)

    // ( 이미지 표출 )
    //implementation ("com.github.bumptech.glide:glide:4.12.0")
    //implementation (libs.glide)

    // ( 의존성주입 )
    //implementation("com.google.dagger:dagger:2.51.1")
    //annotationProcessor("com.google.dagger:dagger-compiler:2.51.1")
    implementation(libs.dagger)
    annotationProcessor(libs.dagger.compiler)

    // Note: Navigation 사용하기 위해 추가
    //implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation(libs.androidx.navigation.compose)

    // NOTE: viewModel() 사용하기 위해 추가
    //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    //implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    //implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // NOTE: observeAsState 사용하기 위해 추가
    //implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
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