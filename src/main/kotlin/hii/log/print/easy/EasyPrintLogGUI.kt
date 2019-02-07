package hii.log.print.easy

import java.awt.Font

class EasyPrintLogGUI(
    title: String,
    font: Font = Font("", 1, 24),
    width: Int = 800,
    height: Int = 600,
    lineLimit: Int = 10
) {

    private lateinit var myFrame: MyFrame

    var withCommand = false

    var text: String
        get() =
            if (!withCommand)
                myFrame.text
            else
                ""
        set(value) {
            if (withCommand)
                println(this)
            else
                myFrame.text = value
        }

    fun clean() {
        if (!withCommand)
            myFrame.clean()
    }

    init {
        try {
            myFrame = MyFrame(title, font, width, height, lineLimit)
        } catch (ex: java.awt.HeadlessException) {
            withCommand = true
        }
    }
}
