package khai.amo

fun main(args: Array<String>) {

    val manager = SportManager
    println("Загрузка: " + manager.load())
    val list = manager.getAll()
    println("Все загруженные после загрузки: " + list)

    println("Сортировка (по клубам): " + list.sortedBy { sport -> sport.club })

    val formManufacturerlist = listOf<FormManufacturer>(FormManufacturer.Puma, FormManufacturer.Reebok)


        val sfilter = Filters.stringFilter()
        println("Город: " + list.filter { sfilter(it, Pair(Sport.SportFields.city, "Мюнхен ")) })

        println("Клуб: " + list.filter {
            Filters.stringFilter().invoke(it, Pair(Sport.SportFields.club, "Рома"))
        })

        println("League: " + list.filter {
            Filters.leagueFilter().invoke(it, listOf(FootballLeague.Series_A,FootballLeague.Major_League, FootballLeague.La_Liga))
        })


        println("Стоимость: " + list.filter { Filters.numberFilter().invoke(it, Triple(Sport.SportFields.price, 11, 30)) })

        println("Страна: " + list.filter { Filters.countryFilter().invoke(it, listOf(Country.USA)) })

        println("Производитель формы: " + list.filter { Filters.formManufacturerFilter().invoke(it, listOf(FormManufacturer.Nike)) })

}

