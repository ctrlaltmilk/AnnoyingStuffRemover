plugins {
    id("net.neoforged.gradle.userdev") version "7.0+"
}

project.version = "2.2.0"
project.group = "net.ctrlaltmilk"

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

runs {
    configureEach {
        systemProperty("terminal.jline", "true")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:21.1.113")
}

tasks {
    processResources {
        exclude("*.kra") // Original Krita textures
    }

    jar {
        manifest {
            attributes("Implementation-Version" to project.version)
        }
    }
}
