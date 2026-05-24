plugins {
    id("net.neoforged.gradle.userdev") version "7.1.36"
}

project.version = "4.0.0"
project.group = "net.ctrlaltmilk"

java.toolchain.languageVersion = JavaLanguageVersion.of(25)

runs {
    configureEach {
        systemProperty("terminal.jline", "true")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:26.1.0.19-beta")
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
