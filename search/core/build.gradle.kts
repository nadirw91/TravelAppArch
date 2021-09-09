plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.coroutines)
    implementation(project(":networking"))
}
