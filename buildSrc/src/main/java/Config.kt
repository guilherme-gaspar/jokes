import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 21
    const val compileSdk = 32
    const val targetSdk = 32
    val javaVersion = JavaVersion.VERSION_1_8
    const val JvmTargetVersion = "1.8"
}