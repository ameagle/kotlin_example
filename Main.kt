import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory.Zephyr
import java.io.File
import kotlin.math.round

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var name = "Kotlin"
    name = "Kotlin1"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, ${name + '_' + " "}" + "!")

    for (i in (1..5)) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        //println("i = $i")
    }

    val gratuityPercent = 10
    val feePercentages: List<Int> = listOf(1, gratuityPercent,2,3)

    /// 1
    var first_missed: Boolean = false
    val orderTotal: Double =  feePercentages.fold(feePercentages.getOrElse(0,{ 0 }))
    { sum, value ->
        if (!first_missed)
        {
            first_missed = true
            return@fold sum
        }
        println("acc:$sum perc:$value" )
        sum + value
    }.toDouble()
    /// 2
    var orderTotal2:Double = 0.0
    feePercentages.forEach({el ->
                        orderTotal2 += el })

    /// 3
    var orderTotal3 = feePercentages.sumOf {  it }
    println("Order total: $orderTotal")
    println("Order total2: $orderTotal2")
    println("Order total3: $orderTotal3")

    var feePercentages2:List<Int> = feePercentages.filter { el -> el >= 10 }

    println("feePercentages2:$feePercentages2")

    printDayType(DayOfWeek.SATURDAY)


    val cats = listOf("Barsik", "Murzik", "Vaska")
    for( (index, element) in cats.withIndex()){
        println("$index: $element")
    }
    for( el in cats){
        println("$el")
    }

    var mapCats = mapOf(Pair("e1",1), Pair("e2",10))
    for ((k,v) in mapCats.entries){
        println("key:$k value:$v")
    }

    var ks = "String,Ks,Ls"
    println("str:${ks[0]}")
    var ks_list = ks.split(',', limit = 2)
    println("ks_list:$ks_list")
    ks_list.forEach({println("it: $it")})
    println("---------Dragon--------")
    println(toDragonSpeak("Kiutten")) // K1tt3n

    val myArray = arrayOf(1, 1, 2, 3, 4, 5, 5, 4, 3, 2)

    myArray[1] = 10000
    println("myArray:${myArray.contentToString()}")

    var cat1  = Cat("Вася",10,"Бездомная")
    //cat1.weight = -10
    cat1.toMyString()
    cat1.weight = 1
    //cat1.weightInGramm = 1
    cat1.toMyString()
    println("cat1:${cat1.toString()}")

    println("----------1----------")
    val b = BaseImpl(10)
    b.print()
    Derived(b).print()
    println("----------2----------")

    val feePercentages3: List<Any?> = listOf(1, gratuityPercent,2,"_1_",cat1,null)
    feePercentages3.forEach({println("feePercentages3_it:$it")})


    var point = object {
        var x = 0
        var y = 0
    }

    point.x = 10
    println("point:${point.x}, ${point.y}")
    Utils.printUtils()
    //Something.MyObject.XX = 1000
    Something.MyObject.bar()

    var smth2 = Something(10)

    var listF: List<String> = mutableListOf("One","Two")
    listF
        .also { println(it.toString()) }
        .takeIf { it.count() >3 }
        ?.also { println("it.count()):${it.count()}")}

        val sword = Sword("privet")
        println(sword.name)
        sword.name = "privet"
        println(sword.name)

        test_blessing(smth2)
        test_blessing(sword)

    val testAny = object : Any() {
        var q =sword.toString() + "___"
        override fun toString(): String {
            return "GGG:"+ q + super.toString()
        }
    }
    println("testAny:${testAny.toString()}")

    //SpellBook.createDefault().spells.add("ZZZZZZZZZZ")
    //SpellBook.createDefault().spells.add("XXXXXXXXXXXXX")

    println("${SpellBook.createDefault()}")
    println("${SpellBook.createDefault()}")
    println("${SpellBook.createDefault()}")

    println("---------Farmer start-------------")
    Farmer.run()
    println("---------Farmer end-------------")

//    File("file.txt")
//        .also { print(it.name) }
//        .readLines()
//        .also { fileContents = it }


}



