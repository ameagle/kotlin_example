interface Animal{
    var name:String
    fun makeVoice():String
}

class Farmer(val fio:String){
    companion object {
        fun run(){
            val farmer = Farmer("Anton")
            val listAnimal = listOf(Cow("Агата"),Dog("Норд"),Chiken("Петух"))
            listAnimal.forEach({farmer.sayHello(it)})
        }
    }
    fun sayHello(animal:Animal){
        println("(${fio})-Hello ${animal.name}. (Animal response):${animal.makeVoice()}")
    }
}

class Cow(override var name: String) : Animal{
    override fun makeVoice():String {
        return "My-y-y-y"
    }
}

class Dog(override var name: String) : Animal{
    override fun makeVoice():String {
        return "Gav-gav-gav"
    }
}

class Chiken(override var name: String) : Animal{
    override fun makeVoice():String {
        return "Ku-ka-re-ku"
    }
}