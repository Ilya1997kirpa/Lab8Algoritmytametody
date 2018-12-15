package khai.amo

interface Controller {
    fun add(sport : Sport) : Boolean
    fun remove(sport : Sport) : Boolean
    fun contains(sport : Sport) : Boolean
    fun getAll(): Collection<Sport>
}

class ListController(val collection: MutableList<Sport>): Controller{

    override fun add(sport: Sport): Boolean  = when{
        !collection.contains(sport) -> collection.add(sport)
        else -> false
    }

    override fun remove(sport: Sport): Boolean = when{
        collection.contains(sport) -> collection.remove(sport)
        else -> false
    }

    override fun contains(sport: Sport): Boolean = collection.contains(sport)

    override fun getAll(): List<Sport> {
        return collection.toList()
    }
}

