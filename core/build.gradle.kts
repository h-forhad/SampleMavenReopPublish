plugins {
  id("com.android.library")
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  id("maven-publish")
}

android {
  namespace = "com.mdc.android.poc.core"
  compileSdk = 35

  defaultConfig {
    minSdk = 34
    targetSdk = 35

    val tasksVersionMajor = 0
    val tasksVersionMinor = 0
    val tasksVersionPatch = 1

    version = "${tasksVersionMajor}.${tasksVersionMinor}.${tasksVersionPatch}"

    buildConfigField( type = "String", name="VERSION_NAME", value ="\"${version}\"")

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildFeatures {
    compose = true
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }
  kotlinOptions {
    jvmTarget = "21"
  }
}

publishing {
  publications {
    create<MavenPublication>("aarPublication") {
      groupId = "com.local.pscore"
      artifactId = "core"
      version = android.defaultConfig.versionName
      afterEvaluate {
        from(components["release"])
      }
    }
  }

  repositories {
    maven {
      url = uri("${rootProject.buildDir}/local-repo")
    }
  }
}


android.buildFeatures.buildConfig = true

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.runtime.android)

  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.foundation)

  implementation(libs.androidx.material3)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
}