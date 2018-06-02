
plugins {
    id("kotlin")
}

val commonLibs: Libraries by rootProject.extra

dependencies {
    implementation(kotlin("stdlib-jdk7"))

    commonLibs.applyAll { implementation(it) }
}
