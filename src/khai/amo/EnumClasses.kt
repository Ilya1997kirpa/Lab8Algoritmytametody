package khai.amo

interface EnumClasses

interface League

enum class FormManufacturer: EnumClasses{
    Adidas, Nike, Puma, Reebok, Bosco, NONE;

}

enum class Country : EnumClasses{
    England, Brazil, Spain, Italy, Russia,USA,Germany, NONE

}

enum class FootballLeague : EnumClasses,League{
    Major_League,
    Liga_1, MLS, La_Liga, Bundesliga, Eredivisie, First_Division, Series_A, OTHER, NONE
}

enum class BasketballLeague(): EnumClasses,League{
    CBA, LSB, NBB, TBL, ACB, USL, NBA, NONE
}

enum class Typesports : EnumClasses{
    Football, handball, Basketball, Hockey
}

fun EnumClasses.getName(): String  = when(this){
    is FormManufacturer -> name
    is Country -> name
    is FootballLeague -> name
    is BasketballLeague -> name
    else -> ""}
