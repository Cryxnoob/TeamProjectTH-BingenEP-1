
import com.sun.deploy.trace.Trace.flush
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.OutputStreamWriter
import java.io.UnsupportedEncodingException
import java.io.PrintStream
import java.io.PrintWriter
import java.util.*

//collection of all colors I want
//input is a string with one of the colors
enum class PrintColor private constructor(val ansiColor: String) {

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m")
}


//class for wirte colorful of the outptstream
class PrintColorWriter @Throws(UnsupportedEncodingException::class) //catch of the Exception
constructor(out: PrintStream) : PrintWriter(OutputStreamWriter(out, "UTF-8"), true) { //printstream and codeierung

    //use the given color and print in this (without new line)
    fun printColor(color: PrintColor, string: String) {
        print(color.ansiColor) //use the given color
        print(string) //print the string
        flush() //write out all
    }

    //print a word in random color and print in this (without new line)
    fun printRandColor( string: String) {

        val stringArray:CharArray=string.toCharArray() //[H][E][L].... do the string into a char array
        val colors = PrintColor.values() //all colors in the enum
        val countColors:Int=colors.size //how many colors in the enum?
        var i:Int=0 //first initiliziere

        //loop for the chars of stringArray
        while(i<stringArray.size) { //for loop does not work, so I use a while loop
            val whichColor:Int= (Math.random() * countColors).toInt() //random color
            val color: PrintColor = colors[whichColor] //print in random color
            var outputC:Char=stringArray[i] //select the actual char
            var output=outputC.toString() //actual string (only lenght 1) (the letter)
            print(color.ansiColor) //print in the random color
            print(output) //print the letter
            flush() //write out all
            i++ //i=i+1 //next char of the given string, also need for the end of the loop
        }

    }
}



object HelloWorldKt {

    private val CHECK_MARK = "\u2713" //code of the hook

    @JvmStatic fun main(args: Array<String>) { //main method

        try {
            PrintColorWriter(System.out).use { out -> //print to the consol, which use of the self written methods
                out.printRandColor("Hello, World!") //which word?
                out.printColor(PrintColor.GREEN, " "+ CHECK_MARK) //always space and  a green hook
            }
        } catch (e: UnsupportedEncodingException) { //catch of the exception, if there is a error in the printstream
            e.printStackTrace() //"write the exception"
        }

    }
}