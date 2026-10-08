// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.dokka) apply false
    alias(libs.plugins.dokka.javadoc) apply false
}

tasks.register("dokka") {
    group = "documentation"
    description = "Generates all configured project documentation formats with Dokka."
    dependsOn(":app:dokkaGenerate")
}

tasks.register("dokkaHtml") {
    group = "documentation"
    description = "Generates the app HTML documentation with Dokka."
    dependsOn(":app:dokkaGeneratePublicationHtml")
}

tasks.register("dokkaJavadoc") {
    group = "documentation"
    description = "Generates the app Javadoc documentation with Dokka."
    dependsOn(":app:dokkaGeneratePublicationJavadoc")
}

// Compatibility with the command previously used for both formats.
tasks.register("Javadoc") {
    group = "documentation"
    description = "Generates the app Javadoc documentation with Dokka."
    dependsOn(":app:dokkaGeneratePublicationJavadoc")
}
