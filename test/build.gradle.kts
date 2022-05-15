dependencies {
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation(libs.bundles.testDependencies)
}