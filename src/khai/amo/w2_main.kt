package khai.amo

fun main(args: Array<String>) {

    val football1 = Football(
            "Бавария", "Мюнхен",FootballLeague.Bundesliga,"1900","Альянц Арена")
            .setTechInfo("",Country.Germany,FormManufacturer.Puma, 10.4)
    println(football1.getInfo())

    val list = initDataClasses()

    val manager = SportManager

    manager.add(football1)
    list.forEach { println("Добавление: "+manager.add(it)) }
    println(manager.getAll())

    println("----Операция удаления-------")


    println("Удалить один из клубов: " + manager.remove(football1))

    println(manager.getAll())

    println("---------Проверка на наличие-----------")

    println("В наличии: " + manager.contains(football1))
    println(manager.getAll())
}
