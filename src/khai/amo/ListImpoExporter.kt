package khai.amo

import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class ListImpoExporter(
    override var filename : String = "",
    private val collection: MutableList<Sport>) : ImpoExporter{
    val CSV_HEADER = mutableListOf("class")
    init {
        CSV_HEADER.addAll(Football().getFieldName())
    }

    override fun write():Boolean {
        var isWritten = false
        var fileWriter: FileWriter? = null
        try {
            fileWriter = FileWriter(filename)
            fileWriter.append( CSV_HEADER . joinToString("\t","","\n") )

            for (sport in collection) {
                fileWriter.append(
                    writeItem(sport,CSV_HEADER)
                        . joinToString("\t","","\n"))
            }

            isWritten = true
        } catch (e: Exception) {
            println("Writing CSV error!")
            e.printStackTrace()
        } finally {
            try {
                fileWriter!!.flush()
                fileWriter.close()
            } catch (e: IOException) {
                println("Flushing/closing error!")
                e.printStackTrace()
            }
        }
        return isWritten
    }

    private fun writeItem(sport: Sport,order:List<String>):List<String>{
        val map = sport.fieldsToMap()
        val list = mutableListOf<String>()

        for (s in order) {
            list.add(map[s]?:"")
        }
        return list
    }

    override fun load(): Boolean {
        var isReaded = false
        val loaded = mutableListOf<Sport>()
        var fileReader: BufferedReader? = null
        try {
            var line: String?
            fileReader = BufferedReader(FileReader(filename))
            // Read CSV header
            fileReader.readLine()
            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split("\t")
                if (tokens.size > 0) {
                    SportFactory.create(tokens[0])?.let {

                        it.mapToFields(CSV_HEADER.zip(tokens).toMap())
                        loaded.add(it)
                        isReaded =  true
                    }
                }
                line = fileReader.readLine()
            }
            collection.addAll(loaded)
        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {fileReader!!.close()
            } catch (e: IOException) {
                println("Closing fileReader Error!")
                e.printStackTrace()
            }
        }
        return isReaded
    }
}