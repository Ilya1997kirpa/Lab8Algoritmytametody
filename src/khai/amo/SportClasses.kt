package khai.amo


abstract class SportClass: Sport {

    override var price = 0.0
    override var formManufacturer = FormManufacturer.NONE
    override var country = Country.NONE


    override fun setTechInfo(club: String,country: Country, formManufacturer: FormManufacturer, price: Double): Sport {
       this.club=club
        this.country = country
        this.formManufacturer = formManufacturer
        this.price = price
        return this
    }

    override fun setContentInfo(club: String, city: String,
                                yearofFoundation: String, league: League, stadium: String): Sport {

        this.club = club
        this.city = city
        this.yearofFoundation = yearofFoundation
        this.league = league
        this.stadium = stadium
        return this
    }

    override fun getInfo(): String {
        return "${getShortInfo()}, " + super.getInfo()
    }
}
