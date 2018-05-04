
class AppConfiguration(
    val android: AndroidConfiguration,
    val lib: Libraries,
    val kapt: Libraries,
    val testLib: Libraries
)

class AndroidConfiguration(
    val buildTools: String,
    val minApi: Int,
    val targetApi: Int,
    val compileApi: Int = targetApi,
    val gradlePlugin: String
)
