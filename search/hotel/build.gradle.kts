plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply(from = "$rootDir/gradle/dagger.gradle")

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 28
        targetSdk = 30
    }
}

dependencies {
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.daggerAndroid)

    implementation("search:core")

    kapt(Dependencies.daggerAndroidCompiler)
    kapt(Dependencies.daggerCompiler)
}
