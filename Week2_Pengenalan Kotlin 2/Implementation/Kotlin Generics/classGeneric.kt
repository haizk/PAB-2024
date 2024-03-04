interface MyList<T>{
    operator fun get(idx: Int): T
}

class MyLongList : MyList<Long>{
    override fun get(idx: Int): Long {
        return this[idx]
    }
}

class MyArrayList<P> : MyList<P>{
    override fun get(idx: Int): P {
        return this[idx]
    }
}

fun main{
    
    val arrayList = MyArrayList<Double>()
    val firstDouble = arrayList.get(0)
    
}