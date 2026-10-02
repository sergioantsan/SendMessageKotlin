// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.dokka) apply false
}

tasks.register("dokkaHtml") {
    group = "documentation"
    description = "Generates the app HTML documentation with Dokka."
    dependsOn(":app:dokkaGeneratePublicationHtml")
}
