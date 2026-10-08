plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.dokka)
    alias(libs.plugins.dokka.javadoc)
}

android {
    namespace = "com.example.sendmessage"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.sendmessage"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}



dependencies {
    implementation(libs.kotlin.parcelize.runtime)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

}
dokka {
    moduleName.set("SendMessage")
    dokkaPublications.html {
        outputDirectory.set(rootProject.layout.projectDirectory.dir("documentation"))
    }
    dokkaPublications.javadoc {
        outputDirectory.set(rootProject.layout.projectDirectory.dir("documentation-javadoc"))
    }
    dokkaSourceSets.configureEach {
        if (name == "release") {
            sourceRoots.from(file("src/main/java"))
            jdkVersion.set(11)
            enableAndroidDocumentationLink.set(false)
        }
    }
}

// El alias de compatibilidad lo proporciona la tarea raíz dokkaHtml.
tasks.named("dokkaHtml") {
    enabled = false
}

tasks.named("dokkaJavadoc") {
    enabled = false
}
