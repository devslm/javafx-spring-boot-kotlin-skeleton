import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.openjfx.javafxplugin") version "0.0.9"
    kotlin("jvm") version "1.4.21"
    kotlin("kapt") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
    kotlin("plugin.jpa") version "1.4.21"
}

group = "com"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
    jcenter()
    mavenCentral()
}

extra["kotlinCoroutinesVersion"] = "1.4.2"
extra["javaxVersion"] = "2.3.0"
extra["javaFxVersion"] = "14.0.2.1"
extra["controlsFxVersion"] = "11.0.3"
extra["sqliteVersion"] = "3.34.0"
extra["sqliteDialectVersion"] = "0.1.1"
extra["jacksonVersion"] = "2.11.3"
extra["mapstructVersion"] = "1.4.1.Final"
extra["junitVersion"] = "5.6.0"
extra["testContainersVersion"] = "1.15.1"

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junitVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junitVersion")}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${property("kotlinCoroutinesVersion")}")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.flywaydb:flyway-core")
    implementation("javax.xml.bind:jaxb-api:${property("javaxVersion")}")
    implementation("com.sun.xml.bind:jaxb-core:${property("javaxVersion")}")
    implementation("com.sun.xml.bind:jaxb-impl:${property("javaxVersion")}")
    implementation("org.openjfx:javafx-controls:${property("javaFxVersion")}")
    implementation("org.openjfx:javafx-fxml:${property("javaFxVersion")}")
    implementation("org.controlsfx:controlsfx:${property("controlsFxVersion")}")
    implementation("org.xerial:sqlite-jdbc:${property("sqliteVersion")}")
    implementation("com.github.gwenn:sqlite-dialect:${property("sqliteDialectVersion")}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${property("jacksonVersion")}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${property("jacksonVersion")}")
    implementation("org.mapstruct:mapstruct:${property("mapstructVersion")}")

    kapt("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testContainersVersion")}")
    }
}

buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.openjfx:javafx-plugin:0.0.9")
    }
}
apply(plugin = "org.openjfx.javafxplugin")

javafx {
    version = "15"
    modules("javafx.controls", "javafx.fxml")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "15"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
