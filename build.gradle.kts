plugins {
    kotlin("jvm") version "1.6.21" apply false
    kotlin("kapt") version "1.6.21" apply false
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }
    group = "com.gcgenome"
    version = "1.0"
}
