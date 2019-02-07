package hii.log.print.easy

import java.awt.BorderLayout
import java.awt.Font
import java.awt.TextArea
import javax.swing.JFrame
import javax.swing.JPanel

internal class MyFrame(
    title: String,
    font: Font,
    width: Int,
    height: Int,
    lineLimit: Int
) : JFrame() {

    private var textArea: TextArea? = null
    var withCommand = false

    var text: String
        get() =
            if (!withCommand)
                textArea!!.text
            else
                ""
        set(value) {
            if (withCommand)
                println(this)
            else
                textArea?.append("$value\n")
        }

    fun clean() {
        if (!withCommand)
            textArea?.text = ""
    }

    init {
        try {
            setSize(width, height)
            setLocationRelativeTo(null)

            this.title = title
            textArea = object : TextArea() {
                override fun append(str: String?) {
                    var line = text.split("\n").size

                    while (line > lineLimit - 1) {
                        val fle = text.indexOf("\n")
                        super.replaceRange("", 0, fle + 1)
                        line = text.split("\n").size
                    }

                    super.append(str)
                }
            }
            textArea!!.isEditable = false

            textArea!!.font = font

            val panel = JPanel()
            panel.layout = BorderLayout()
            panel.add(textArea)
            contentPane.add(panel)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            isVisible = true
        } catch (ex: java.awt.HeadlessException) {
            ex.printStackTrace()
            withCommand = true
        }
    }
}
