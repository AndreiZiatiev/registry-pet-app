import io.gitlab.arturbosch.detekt.detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.5.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion apply false
	kotlin("plugin.jpa") version kotlinVersion apply false

	id("org.springframework.boot") version "2.5.1" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion apply false
	id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion apply false

	id("io.gitlab.arturbosch.detekt") version "1.17.1"
	id("jacoco")
	id("com.google.cloud.tools.jib") version "2.8.0" apply false
}

allprojects {
	group = "org.regisrty"
	version = "0.0.1"

	repositories {
		mavenCentral()
		mavenLocal()
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
	apply(plugin = "org.jetbrains.kotlin.plugin.noarg")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "jacoco")

	jacoco {
		toolVersion = "0.8.7"
	}

	tasks.jacocoTestReport {
		reports {
			xml.isEnabled = true
		}
	}

	tasks.test {
		useJUnitPlatform()
		finalizedBy(tasks.jacocoTestReport)
	}

	tasks.jacocoTestReport {
		dependsOn(tasks.test)
	}

}

detekt {
	ignoreFailures = true
}
