fun main(args: Array<String>) {

    printValue(divide(1,2, {num:Number->if(num == 0){println("divide with zero error")}}))
    printValue(divide(1,0){num:Number->if(num == 0){println("divide with zero error")}})
    
    calculateAndPrint(1, 2, ::sum)
    iterateExecute(5, {index:Int->println(index.toString())})
    
    val operatorObject = generalOperator("Float")
    printValue(operatorObject.sum(1,2))
    
    operatorObject.returnType = "Int"
    printValue(operatorObject.sum(1,2))
    println(generalOperator.memberFuncList)
    
    val responseObject = ResponseClass()
    responseObject.printResponse(1, "")
}

fun iterateExecute(a:Int, func:(Int)->Unit):Unit{
    for (i in 1..a){
        func(i)
    }
}

fun calculateAndPrint(a:Number, b:Number, func:(Number, Number)->Float):Unit{
    val result:String = func(a, b).toString()
    println(result)
}

fun printValue(a:Any):Unit{
    if(a is String){
        println(a)
    }else if(a is Number){
        val str_num:String = a.toString()
        println("${str_num}  (${str_num.javaClass})")
    }
}

fun sum(a:Number, b:Number):Float{
    return a.toFloat()+b.toFloat()
}

fun multiply(a:Number, b:Number):Float{
    return a.toFloat()*b.toFloat()
}

inline fun divide(a:Number, b:Number, option:(num:Number)->Unit):Float{
    option(b)
    if(b==0){
        var b_2:Number = b.toFloat()+0.00001
        return a.toFloat()/b_2.toFloat()
    }else{
        return a.toFloat()/b.toFloat()
    }
}