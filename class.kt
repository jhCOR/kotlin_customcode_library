import kotlin.properties.Delegates
open class basicOperator constructor(){

    open fun sum(a:Number, b:Number):Number{
        return a.toDouble()+b.toDouble()
    }
}

class generalOperator constructor(): basicOperator(){
    var returnType:String by Delegates.observable("Float"){
        _, old, new ->println("return type is setted to ${new} from ${old}")
    }
    
    constructor(_returnType:String = "Float"): this(){
        returnType = _returnType 
    }
    
    override fun sum(a:Number, b:Number):Number{
        //println("overridden sum function")
        var summation = super.sum(a, b)
        val type:Number = when(returnType.toLowerCase()){
            "float"-> summation.toFloat()
            "double"-> summation.toDouble()
            "int"-> summation.toInt()
            else -> summation.toDouble()
        }
        return type
    }
    
    companion object {
        var memberFuncList:String = "sum"
    }
}
