object LibVersion {
    const val versionCode = 1

    const val major = 1
    const val minor = 0
    const val patch = 0

    const val isSnapshot = false

    val versionName = "$major.$minor.$patch${if (isSnapshot) "-SNAPSHOT" else ""}"
}
