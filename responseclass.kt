interface returnResponse{
    fun printResponse(code:Int, content:String){
        println("state: ${code} / message: ${content}")
    }
}

interface responseForm{
    val state: Int
    val message: String
}

class ResponseClass : returnResponse, responseForm {
    override var state: Int = 0
    override var message: String = ""
    override fun printResponse(code:Int, result:String){
        state = code
        message = result
        super<returnResponse>.printResponse(state, message)
    }
}