class Cat(val name: String, weight_param: Int, breed_param: String) {

    var activities = arrayOf("Play")

    var breed = breed_param.uppercase().requiredBreed()
        set(value) {
            field = value.requiredBreed()
        }
        //get() = breed

    var weight = weight_param
        set(value) {
            field = 0
            this.weightInGramm = 0
            if (value > 0) {
                field = value
                this.weightInGramm = value
            }
        }
    var weightInGramm :Int = weight * 1000
        private set(value){
            println("value weightInGramm:${value}")
            field = 0
            if (value>0) field = value * 1000

        }

    //var weightInGramm :Int = weight_param * 1000

        //get() = weight
    private fun String.requiredBreed() = this.also {
        require(it.trim().isNotEmpty()) {
            "The Breed cannot be blank"
        }
    }

    fun sleep() {
        println(if (weight < 3) "сопит!" else "храпит!")
    }
    fun toMyString(){
        println("Cat:${this.name} ${this.weight}  ${this.breed} ${this.weightInGramm}")
    }
}



interface Base {
    fun print(){
        println("--Base--")
    }
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print("--BaseImpl -- $x") }
}

class Derived(b: Base) : Base by b

 object  Utils {
    var XX = 10
    const val XY = "sssssssssss"
    fun printUtils(param:Any = 100){
        println("Utils: XX:$XX XY:$XY param:$param")
    }
}

class Something(_age:Int){
    val age = _age
    var bage = 0
    constructor(_a:Int, _b:Int=100):this(_a){
        println("Call Something constractor")
        this.bage =_b
    }
    companion object MyObject {
        var XX :Int? = null
        @JvmField
        var smth = Something(5,10)
        fun bar(_val:Int=777) {
            //smth.bage= -5555
            setBar(_val)
            println("Companion object called XX:$XX ---${smth.age} ${smth.bage}")
        }
        fun setBar(_val:Int){
            this.XX = _val
        }
    }
}

class Sword(_name: String) {
    var name :String = ""
        get() = "The Legendary $field"
        set(value) {
            field = value.lowercase().reversed().capitalize()
        }
    init {
        println("init _name:$_name")
        this.name = _name
    }
}

fun test_blessing(any:Any) {
    val isSourceOfBlessings: Boolean = if (any is Sword) {
        println("----Sword--- ${any.name}")
        any.name == "The Legendary Tevirp"

    } else {
        println("----Something---")
        (any as Something).bage == 10
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}


class SpellBook private constructor(_spells: List<String>?) {
    var spells: MutableList<String>? = null
    init {
        this.spells = _spells?.toMutableList()
        spells?.add("Test_3_in_init")
        println("----Init run----")
    }
    override fun toString():String
    {
        return this.spells.toString()
    }

    companion object {
        private var DefaultBook = SpellBook(
            listOf(
                "Test_0",
                "Test_1",
                "Test_2"
            ))
        fun createDefault(): SpellBook {
            return DefaultBook
        }
    }
}
