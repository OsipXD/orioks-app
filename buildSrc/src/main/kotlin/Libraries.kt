class Libraries(vararg pairs: Pair<String, String>) {

    private val libs =  pairs.toMap()

    operator fun get(name: String): String = libs.get(name) ?: error("Unknown lib: $name")

    fun applyAll(block: (String) -> Unit) {
        libs.values.forEach(block)
    }
}
