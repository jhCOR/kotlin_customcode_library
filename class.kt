open class basicOperator constructor(){

    open fun sum(a:Number, b:Number):Number{
        return a.toDouble()+b.toDouble()
    }
}

class generalOperator constructor(val returnType:String = "FLoat"): basicOperator(){
    
    override fun sum(a:Number, b:Number):Number{
        println("overridden sum function")
        var summation = super.sum(a, b)
        val type:Number = when(returnType.toLowerCase()){
            "float"-> return summation.toFloat()
            "double"-> return summation.toDouble()
            "int"->return summation.toInt()
            else -> return summation.toDouble()
        }
        return type
    }
}
