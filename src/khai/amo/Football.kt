package khai.amo

data class Football(
        override var club: String = "",
        override var city: String = "",
        override var league: League = FootballLeague.NONE,
        override var yearofFoundation: String = "",
        override var stadium: String =""
): SportClass() {

    override fun getShortInfo(): String {
        return "$club - $city [$stadium, " +
                "$yearofFoundation, ${(league as FootballLeague).getName()}]"
    }
}

/*
data class handball(val football: Football = Football()): Sport by football{

    override fun getInfo(): String {
        return "${football.club} - $city [${football.stadium}, ${football.yearofFoundation}, " +
                "${(film.league as footballLeague).getName()}]; "+ super.getInfo()
    }
}
        */