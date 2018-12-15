package khai.amo

class Filters{

    companion object {

        fun formManufacturerFilter () : (sport: Sport, list : List<FormManufacturer>) -> Boolean
                = { sport, list -> sport.formManufacturer in list }

        fun leagueFilter() = {
            sport: Sport, list : List<League> -> sport.league in list}

        fun countryFilter() = {
            sport: Sport, list : List<Country> -> sport.country in list}

        fun numberFilter ()
                = {sport: Sport, minToMax : Triple<Sport.SportFields, Number, Number> ->
            when(minToMax.first) {
                Sport.SportFields.price ->
                    sport.price in minToMax.second.toDouble().. minToMax.third.toDouble()
                else -> false
            }
        }

        fun stringFilter()
                = {sport: Sport, param : Pair<Sport.SportFields, String> ->
            when(param.first) {
                Sport.SportFields.club -> param.second in sport.club
                Sport.SportFields.city -> param.second in sport.city
                Sport.SportFields.yearofFoundation -> param.second in sport.yearofFoundation
                Sport.SportFields.stadium -> param.second in sport.stadium
                else -> false
            }
        }
    }
}

