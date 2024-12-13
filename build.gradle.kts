plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

group = "dev.Adevium"

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven { url = uri("https://jitpack.io") }
}

android {
    namespace = "dev.Adevium.ApkSignerCompat"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        aidl = true
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

        pom {
            name = "ApkSignerCompat"
            description = "Apk Signer with Android compatibility"
            url = "https://github.com/Adevium/ApkSignerCompat"
        }
    }
}