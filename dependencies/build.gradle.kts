plugins {
    kotlin("jvm")
}

dependencies {
    val koinVersion = "3.2.0"
    api("io.insert-koin:koin-android:$koinVersion")
    api("io.insert-koin:koin-androidx-compose:$koinVersion")
}
