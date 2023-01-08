fun main(args: Array<String>) {
    printValue("Hello World")
	printValue(10)
    
    printValue(sum(1f,2f))
    printValue(multiply(1,2))
    printValue(divide(1,2, {num:Number->if(num == 0){println("divide with zero error")}}))
    printValue(divide(1,0, {num:Number->if(num == 0){println("divide with zero error")}}))
}

fun printValue(a:Any):Unit{
    if(a is String){
        println(a)
    }else if(a is Number){
        val str_num:String = a.toString()
        println("${str_num}  (${str_num.javaClass})")
    }
}

fun sum(a:Float, b:Float):Float{
    return a+b
}

fun multiply(a:Number, b:Number):Number{
    return a.toFloat()*b.toFloat()
}

inline fun divide(a:Number, b:Number, option:(num:Number)->Unit):Number{
    option(b)
    if(b==0){
        var b_2:Number = b.toFloat()+0.00001
        return a.toFloat()/b_2.toFloat()
    }else{
        return a.toFloat()/b.toFloat()
    }
    
}