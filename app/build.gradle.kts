import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.tvseries"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_KEY", getApiKey() ?: "\"40b550b0d1a1336d1b32b6a6e7887c7e\"")

        testInstrumentationRunner = "com.example.tvseries.HiltTestRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
        release {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    kotlin {
        jvmToolchain(17)
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    namespace = "com.example.tvseries"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.rxjava)
    implementation(libs.rxjava.rxandroid)

    //Restfull
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.adapter)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.retrofit2.moshi.converter)

    //Glide
    implementation(libs.glide)

    //Navigation component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Hilt DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Paging3
    implementation(libs.androidx.paging.runtime.ktx)

    // Timber
    implementation(libs.timber)

    // Local Unit Tests
    implementation(libs.androidx.test.core)
    testImplementation(libs.mockito.core)
    testImplementation(libs.junit4)
    testImplementation(libs.truth)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hamcrest.all)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.okhttp3.mockwebserver)

    // Instrumented Unit Tests
    androidTestImplementation(libs.mockito.core)
    androidTestImplementation(libs.junit4)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.mockito.android)

    //androidTestImplementation(libs.robolectric)
    androidTestImplementation(libs.androidx.test.espresso.contrib)
    androidTestImplementation(libs.google.ar.core)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    debugImplementation(libs.androidx.fragment.testing)
}

kapt {
    correctErrorTypes = true
}

fun getApiKey(): String? {
    return gradleLocalProperties(rootDir).get("API_KEY") as String?
}