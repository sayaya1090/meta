plugins {
    kotlin("jvm")
    kotlin("kapt")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
kapt {
    keepJavacAnnotationProcessors = true
    includeCompileClasspath = false
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
tasks.getByName<Jar>("jar") {
    enabled = false
}
tasks.test {
    useJUnitPlatform()
}