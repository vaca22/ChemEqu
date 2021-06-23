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