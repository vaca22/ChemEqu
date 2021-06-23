package com.vaca.chemicalequation

import android.util.Log

class RationalMatrix(chem: Array<Array<Int>>) {
    var chemMatrix = arrayOf<Array<RationalNumber>>()
    var row:Int
    var column:Int

    init {
        row=chem.size
        column=chem[0].size
        for(k in 0 until row){
            var array = arrayOf<RationalNumber>()
            for(j in 0 until column){
                array+=RationalNumber(chem[k][j])
            }
            chemMatrix+=array
        }
    }






    fun swapRow(i:Int,j:Int):RationalMatrix{
        if(i==j){
            return this
        }
        var temp:RationalNumber
        for(k in 0 until column){
            temp=chemMatrix[i][k]
            chemMatrix[i][k]=chemMatrix[j][k]
            chemMatrix[j][k]=temp
        }
        return this
    }

    fun reduceRow(baseRow: Int):RationalMatrix{
        val temp=chemMatrix[baseRow][baseRow].invInstance()
        for(k in 0 until column){
            chemMatrix[baseRow][k]=chemMatrix[baseRow][k].multiply(temp)
        }
        return this
    }


    fun reduceRow(baseRow:Int, secondRow:Int):RationalMatrix{
        for(k in 0 until  column){
            chemMatrix[secondRow][k]=chemMatrix[secondRow][k]
                .add(
                    chemMatrix[baseRow][k]
                    .multiplyInstance(
                        chemMatrix[secondRow][baseRow]
                    )
                    .strains()
                )
        }
        return this
    }





    fun rref( ):RationalMatrix{

        for(i in 0 until row){
            for(j in i until row){
                if(!chemMatrix[j][i].isZero()){
                    swapRow(j,i)
                    reduceRow(i)
                    break;
                }
            }
            for(j in i+1 until row){
                reduceRow(i,j)
            }
        }

        for(i in row-1 downTo 1){
            for(j in i-1 downTo  0){
                reduceRow(i,j)
            }
        }

        return this

    }

    private fun abs(a:Int):Int{
        if(a<0){
            return -a;
        }else{
            return a;
        }
    }
    fun gcd(np :Int,dp: Int):Int{
        var np=abs(np)
        var dp=abs(dp)
        var remainder=dp % np
        var temp=0;
        while(remainder!=0){
            temp=np % remainder
            np=remainder
            remainder=temp
        }
        return np
    }


    fun lcm(np :Int,dp: Int):Int{
        return np*dp/gcd(np,dp)
    }


    fun coefficientArray():Array<Int>{
        rref()
        var num= arrayOf <Int> ()
        var deu= arrayOf <Int> ()

        var dlcm=1;

        for(k in 0 until row){
            dlcm=lcm(abs(chemMatrix[k][column-1].denominator),dlcm)
            num+=abs(chemMatrix[k][column-1].numerator)
            deu+=abs(chemMatrix[k][column-1].denominator)
        }

        num+=1;
        deu+=1;

        for(k in 0 until column){
            num[k]*=(dlcm/deu[k])
        }

        var ngcd=1;
        for(k in 0 until column){
            ngcd=gcd(1,num[k])
        }

        for(k in 0 until column){
            num[k]/=ngcd
        }
        return num;
    }


    fun log(){
        for(k in 0 until row){
            var info=""
            for(j in 0 until column){
                var temp=chemMatrix[k][j]
                temp.run {
                    info+="${numerator}/${denominator}  "
                }
            }
            Log.i("fuck",info)
        }
    }




}