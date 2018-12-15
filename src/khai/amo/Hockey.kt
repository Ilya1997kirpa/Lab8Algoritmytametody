package khai.amo

data class Hockey(
        override var club: String = "",
        override var city: String = "",
        override var league: League = FootballLeague.NONE,
        override var yearofFoundation: String = "",
        override var stadium: String = ""
): SportClass(){

    override fun getShortInfo(): String {
        return "$club: $city ($stadium, $yearofFoundation)"
    }
}

