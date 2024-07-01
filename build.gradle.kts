allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    dependencies {
        "testImplementation"("org.junit.jupiter:junit-jupiter:5.10.3")
        "testRuntimeOnly"("org.junit.platform:junit-platform-launcher")

        "testImplementation"("org.assertj:assertj-core:3.25.3")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}