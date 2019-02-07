package hii.log.print.easy

import java.awt.BorderLayout
import java.awt.Font
import java.awt.TextArea
import javax.swing.JFrame
import javax.swing.JPanel

class EasyPrintLogGUI(
    title: String,
    font: Font = Font("", 1, 24),
    width: Int = 800,
    height: Int = 600,
    lineLimit: Int = 10
) : JFrame() {

    private val textArea: TextArea

    var text
        get() = textArea.text
        set(value) {
            textArea.append("\n $value")
        }

    fun clean() {
        textArea.text = ""
    }

    init {
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
        textArea.isEditable = false

        textArea.font = font

        val panel = JPanel()
        panel.layout = BorderLayout()
        panel.add(textArea)
        contentPane.add(panel)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        isVisible = true
    }
}
