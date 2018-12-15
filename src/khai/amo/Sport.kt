package khai.amo

interface Sport{

    var club: String
    var city: String
    var yearofFoundation: String
    var league: League
    var stadium: String


    var country: Country
    var formManufacturer: FormManufacturer
    var price: Double

    fun getShortInfo():String
    fun getInfo():String = "Данные (Клуб: $club , страна: $country, Спонсор: $formManufacturer, Стоимость: $ $price млрд)"
    fun setTechInfo(club: String, country: Country, formManufacturer: FormManufacturer, price: Double): Sport
    fun setContentInfo(club: String, city: String, yearofFoundation: String,
                       league: League, stadium: String): Sport


    enum class SportFields{
        club, city, yearofFoundation, league,
        stadium, country, formManufacturer, price;

    }
    fun getFieldName() = SportFields.values().toList().map{ it.name }
}

    fun Sport.mapToFields(data: Map <String, String>){
        this.setContentInfo(
            data["club"]?:"",
            data["city"]?:"",
            data["yearofFoundation"]?:"",
            when(this) {
                is Basketball -> BasketballLeague.valueOf(data["league"]?:"NONE")
                else -> FootballLeague.valueOf(data["league"]?:"NONE")},
            data["stadium"]?:""
        )
        this.setTechInfo(
                data["club"]?:"",
            Country.valueOf(data["country"]?:"NONE"),
            FormManufacturer.valueOf(data["formManufacturer"]?:"NONE"),
            data["price"]?.toDouble()?:0.0

        )

    }

    fun Sport.fieldsToMap() : Map<String,String> {
        val map = mutableMapOf<String,String>()

        map["class"] = this::class.simpleName ?: this::class.toString()
        map["club"] = this.club
        map["city"] = this.city
        map["yearofFoundation"] = this.yearofFoundation
        map["league"] = (this.league as EnumClasses).getName()
        map["stadium"] = this.stadium
        map["country"] = this.country.getName()
        map["formManufacturer"] = this.formManufacturer.getName()
        map["price"] = this.price.toString()
        return map.toMap()
    }
