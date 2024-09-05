package pl.svgames.blog.RustOnAndroid

class RpnCalculator {
    // Used to load the 'native-lib' library on application startup.
    companion object {
        init {
            System.loadLibrary("rpn")
        }

        @JvmStatic
        external fun rpn(expression: String): Result
    }
}