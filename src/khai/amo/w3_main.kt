package khai.amo

fun main(args: Array<String>) {


    val list = initDataClasses()
    val manager = SportManager
    list.forEach { println("Добавление: "+manager.add(it)) }
    println(manager.getAll())

    println( "Запись: " + manager.write() )
    println( "Стирание: " + manager.clear() )
    println( "Все записанные после стирания: " + manager.getAll())

    println( "Загрузка: " + manager.load() )
    println( "Все загруженные после загрузки: " + manager.getAll())

    SportFactory.create("Football")
        ?.let{
            it.setContentInfo(
                    club = "",
                    city = "Москва",
                    yearofFoundation = "1911",
                    league = FootballLeague.Major_League,
                    stadium = "ВЭБ АРЕНА"
            ).setTechInfo(club = "ЦСКА",country = Country.Russia,price = 12.2,formManufacturer = FormManufacturer.Bosco)
            println("Добавление созданных: " + manager.add(it) )
        }
    println(manager.getAll())
    println( "Запись: " + manager.write() )

}