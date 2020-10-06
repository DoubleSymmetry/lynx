import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compile_sdk)
    buildToolsVersion = Versions.buildToolsVersion
    defaultConfig {
        applicationId = "co.touchlab.kampkit"
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            val url = "https://dog.ceo"
            buildConfigField("String", "HOST_URL", "\"$url\"")
        }
        getByName("debug") {
            val url = "https://dog.ceo"
            buildConfigField("String", "HOST_URL", "\"$url\"")

            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation(project(":shared"))
    implementation(Deps.recyclerView)
    implementation(Deps.material_x)
    implementation(Deps.app_compat_x)
    implementation(Deps.core_ktx)
    implementation(Deps.Ktor.androidCore)
    implementation(Deps.constraintlayout)
    implementation(Deps.SqlDelight.runtimeJdk)
    implementation(Deps.SqlDelight.driverAndroid)
    implementation(Deps.Coroutines.common)
    implementation(Deps.Coroutines.android)
    implementation(Deps.multiplatformSettings)
    implementation(Deps.koinCore)
    testImplementation(Deps.junit)
}
