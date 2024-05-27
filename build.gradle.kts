allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    dependencies {
        "testImplementation"("org.junit.jupiter:junit-jupiter:5.10.2")
        "testRuntimeOnly"("org.junit.platform:junit-platform-launcher")

        "testImplementation"("org.assertj:assertj-core:3.26.0")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}