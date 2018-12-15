package khai.amo


data class Basketball(
        override var club: String = "",
        override var city: String = "",
        override var league: League = BasketballLeague.NONE,
        override var yearofFoundation: String = "",
        override var stadium: String =""
): SportClass(){

    override fun getShortInfo(): String {
        return "$club \"$city\" ($yearofFoundation, $stadium, ${(league as EnumClasses).getName()})"
    }
}
