package khai.amo

interface ImpoExporter {
    var filename: String

    fun load(): Boolean
    fun write(): Boolean
}

