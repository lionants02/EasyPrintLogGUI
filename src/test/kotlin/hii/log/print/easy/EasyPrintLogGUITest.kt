package hii.log.print.easy

import org.junit.Test

class EasyPrintLogGUITest {
    @Test
    fun new() {
        val printLog = EasyPrintLogGUI("TT")
        printLog.text = "aa"
    }
}
