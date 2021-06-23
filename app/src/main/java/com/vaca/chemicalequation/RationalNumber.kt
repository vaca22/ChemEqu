package com.vaca.chemicalequation

class RationalNumber(var numerator:Int,var denominator:Int) {

    init {
        this.simplify()
    }

    private fun abs(a:Int):Int{
        if(a<0){
            return -a;
        }else{
            return a;
        }
    }

    fun simplify():RationalNumber{
        var np=abs(numerator)
        var dp=abs(denominator)

        var remainder=dp % np
        var temp=0;
        while(remainder!=0){
            temp=np % remainder
            np=remainder
            remainder=temp
        }
        numerator/=np;
        denominator/=np
        return this
    }

    fun add(b:RationalNumber):RationalNumber{
        return RationalNumber(numerator*b.denominator+b.numerator*denominator,denominator*b.denominator)
    }


    fun multiply(b:RationalNumber):RationalNumber{
       return RationalNumber(numerator*b.numerator,denominator*b.denominator)
    }

    fun divide(b:RationalNumber):RationalNumber{
        return RationalNumber(numerator*b.denominator,denominator*b.numerator)
    }

    fun inv():RationalNumber{
        val temp=numerator
        numerator=denominator
        denominator=temp
        return this
    }

}