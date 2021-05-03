object App {
    const val applicationId = "com.rodionov.osport"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1"
}

object DefaultConfig {
    const val minSdk = 21
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.2"
}

object Versions {
    const val gradle = "4.1.3"
    const val lifecycle_extensions = "2.0.0"
    const val room = "2.2.6"
    const val kotlin = "1.4.32"
    const val koin = "2.1.6"
    const val navigation = "2.3.4"
    const val preference_ktx = "1.1.1"
    const val constraint_layout = "2.1.0-alpha2"
    const val lifecycle_viewmodel_ktx = "2.3.0"
    const val retrofit = "2.6.1"
    const val converter_gson = "2.6.1"
    const val stetho = "1.5.1"
    const val gson = "2.8.6"
    const val lifecycle_livedata_ktx = "2.2.0"
    const val multidex = "2.0.1"
    const val material = "1.2.0-alpha02"
    const val appcompat = "1.2.0"
    const val navigation_fragment = "1.0.0"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_livedata_ktx}"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_extensions}"
    const val room_rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val preference_ktx = "androidx.preference:preference-ktx:${Versions.preference_ktx}"
    const val koin_androidx_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val navigation_fragment = "android.arch.navigation:navigation-fragment:${Versions.navigation_fragment}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converter_gson}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_viewmodel_ktx}"
}