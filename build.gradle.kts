plugins {
    id("net.neoforged.gradle") version "6.0+"
    id("org.spongepowered.mixin") version "0.7+"
}

val modId = "asr"

project.version = "1.0.0"
project.group = "net.ctrlaltmilk"

java.toolchain.languageVersion = JavaLanguageVersion.of(17)

minecraft {
    mappings("official", "1.20.1")

    runs {
        all {
            property("terminal.jline", "true")

            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "$projectDir/build/createSrgToMcp/output.srg")

            mods.create(modId).sources(sourceSets.main.get())
        }

        register("client") {}
    }
}

mixin {
    config("${modId}.mixins.json")
    add(sourceSets.main.get(), "${modId}.refmap.json")
}

dependencies {
    minecraft("net.neoforged:forge:1.20.1-47.1.106")

    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
}

tasks {
    processResources {
        val props = mapOf(
                "version" to project.version
        )

        inputs.properties(props)

        filesMatching("META-INF/mods.toml") {
            expand(props)
        }

        exclude("*.kra") // Original Krita textures
    }

    jar {
        archiveClassifier = "forge"
    }
}
