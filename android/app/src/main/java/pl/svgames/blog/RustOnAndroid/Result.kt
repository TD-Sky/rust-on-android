package pl.svgames.blog.RustOnAndroid

class Result(private val ok: Boolean, private val value: String?) {
    fun isOk(): Boolean = ok

    fun isError(): Boolean = !ok

    fun getValue(): String? = if (ok) value else null

    fun getError(): String? = if (!ok) value else null
}