package khai.amo

fun main(args: Array<String>) {

    val football1 = Football("Дэвид Финчер", "Бойцовский клуб")

    println(football1.getShortInfo())
    println(football1.getInfo())

    football1.yearofFoundation = "1899"
    football1.league = FootballLeague.La_Liga
    football1.stadium = "Камп Ноу"

    football1.setTechInfo("Барселона",Country.Brazil,FormManufacturer.Nike, 5.6)
    println(football1.getInfo())

    val list = initDataClasses()
    for (index in 1 until list.size){
        println(list[index].getInfo())
    }

}

fun initDataClasses() : List<Sport>{
    val football1 = Football(
            "Рома",
            "Рим",
            FootballLeague.Series_A,
            "1927",
            "Олимпийский стадион")
            .setTechInfo("Рома",Country.Italy,FormManufacturer.Nike, 10.4)


    val basketball = Basketball(
            club = "",
            city = "Хьюстон, Техас",
            yearofFoundation = "1967",
            league = BasketballLeague.NBA,
            stadium = "Тойота-центр").setTechInfo("Хьюстон",Country.USA,FormManufacturer.Adidas,42.5)



    return listOf(football1,basketball)
}