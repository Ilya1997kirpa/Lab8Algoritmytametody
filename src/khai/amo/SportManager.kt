package khai.amo

object SportManager : Controller, ImpoExporter{
    override var filename: String = "data.tsv"
    private val sports: MutableList<Sport> = mutableListOf()
    private val controller : Controller = ListController(sports)

    override fun add(sport: Sport): Boolean  = controller.add(sport)
    override fun remove(sport: Sport): Boolean = controller.remove(sport)
    override fun contains(sport: Sport): Boolean = controller.contains(sport)
    override fun getAll(): Collection<Sport> = controller.getAll()

    private val impoExporter : ImpoExporter = ListImpoExporter(filename, sports)
    override fun write(): Boolean = impoExporter.write()
    override fun load(): Boolean = impoExporter.load()

    fun clear(): Boolean{
        sports.clear()
        return sports.isEmpty()
    }
}