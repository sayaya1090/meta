plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}
allprojects {
    repositories {
        mavenCentral()
    }
}
subprojects {
    apply {
        plugin("kotlin")
        plugin("kotlin-kapt")
        plugin("kotlin-spring")
        plugin("io.spring.dependency-management")
    }
    group = "net.sayaya"
    version = "1.0"
    repositories {
        mavenCentral()
    }
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.1")
        }
    }
    kapt {
        keepJavacAnnotationProcessors = true
        includeCompileClasspath = false
    }
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
        getByName<Jar>("jar") {
            enabled = false
        }
        test {
            useJUnitPlatform()
        }
    }
}
