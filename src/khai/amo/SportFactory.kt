package khai.amo

class SportFactory(){
    companion object {
        fun create(name: String): Sport? = when(name){
            Typesports.Football.name -> Football()
            //Typesports.handball.name -> handball(Football())
            Typesports.Basketball.name -> Basketball()
            //Typesports.Hockey.name -> Hockey()
            else -> null
        }
    }
}

