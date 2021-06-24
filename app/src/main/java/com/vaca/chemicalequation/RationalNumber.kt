package com.vaca.chemicalequation

class RationalNumber(var numerator:Int,var denominator:Int=1) {

    init {
        this.simplify()
    }



    fun set(s:RationalNumber){
        numerator=s.numerator
        denominator=s.denominator
    }

    private fun abs(a:Int):Int{
        if(a<0){
            return -a;
        }else{
            return a;
        }
    }

    fun simplify():RationalNumber{
        if(numerator==0){
            denominator=1
            return this
        }
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
        numerator=numerator*b.denominator+b.numerator*denominator
        denominator *= b.denominator
        simplify()
        return this
    }


    fun copy():RationalNumber{
        return RationalNumber(numerator,denominator)
    }

    fun multiply(b:RationalNumber):RationalNumber{
        numerator*=b.numerator
        denominator*=b.denominator
        simplify()
       return this
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



    fun strains():RationalNumber{

        return RationalNumber(-numerator,denominator)
    }

    fun isZero():Boolean{
        if(numerator==0){
            return true
        }else{
            return false
        }
    }

}