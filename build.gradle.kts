plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven { url = uri("https://jitpack.io") }
}

android {
    namespace = "dev.Adevium.ApkSignerCompat"
    compileSdk = 35
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.apksig)
    implementation(libs.bcpkix.jdk18on)
    implementation(libs.core.ktx)
}

publishing {
    publications.all {
        if (this !is MavenPublication) return@all

        groupId = "dev.Adevium"
        artifactId = "ApkSignerCompat"
        version = "1.0.1"

        pom {
            name = "ApkSignerCompat"
            description = "Apk Signer with Android compatibility"
            url = "https://github.com/Adevium/ApkSignerCompat"
        }
    }
}