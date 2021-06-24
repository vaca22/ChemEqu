package com.vaca.chemicalequation


import java.nio.charset.StandardCharsets.US_ASCII

class ChemString(chem: String) {
    val chemMine=chem.trim()
    var chemByte: ByteArray = chemMine.toByteArray(US_ASCII)
    var chemInt: IntArray = IntArray(chemByte.size) { k ->
        chemByte[k].toUByte().toInt()
    }


    fun convertNumber(k: Int): Int {
        val st = chemByte
        val size = st.size
        var num = arrayOf<Byte>()
        var k = k;
        val ord = k
        while (k < size) {
            val a = chemInt[k]
            if (a in 48..57) {
                num += st[k]
                k++;
            } else {
                break;
            }
        }
        if (k == ord) {
            return 1
        } else {
            return String(num.toByteArray()).toInt()
        }
    }


    fun midString(k:Int,num:Int):String{
        return chemMine.substring(k,k+num)
    }


    fun toList(): ArrayList<ChemItem> {

        var result = ArrayList<ChemItem>()
        var bracketFlag=false
        var bracketItem= arrayOf<Int>()
        val chemIntSize=chemInt.size
        var elementList=arrayOf<String>()
        var elementType=1;

        for(k in chemInt.indices){
            when(chemInt[k]){
                43->{
                    result.add(ChemItem(0,0))
                }
                61->{
                    result.add(ChemItem(-1,0))
                }
                40->{
                    bracketFlag=true
                    bracketItem= arrayOf<Int>()
                }
                41->{
                    bracketFlag=false
                    val hol=convertNumber(k+1)
                    for(j in bracketItem){
                        result[j]= ChemItem(result[j].type,hol*result[j].num)
                    }
                }
                in 65..90->{
                    var ele=""
                    var num=0
                    if(k<chemIntSize-1){
                        if(chemInt[k+1] in 97..122){
                            num=convertNumber(k+2)
                            ele=midString(k,2)
                        }else{
                            num=convertNumber(k+1)
                            ele=midString(k,1)
                        }

                    }else{
                        num=convertNumber(k+1)
                        ele=midString(k,1)
                    }
                    if(ele in elementList){
                        result+=ChemItem(elementList.indexOf(ele)+1,num)
                    }else{
                        result+=ChemItem(elementType,num)
                        elementType++
                        elementList+=ele
                    }
                    if(bracketFlag){
                        bracketItem+=(result.size-1)
                    }
                }
            }
        }
        return result
    }



    fun toMatrixBaby():Array<Array<Int>>{
        val chemList=toList()
        val chemListIndex= ArrayList <Int> ()
        var baby = arrayOf<Array<Int>>()

        var m=0;
        var e=0;

        for(k in chemList.indices){
            if(chemList[k].type>m){
                m=chemList[k].type
            }

            if(chemList[k]==ChemItem(0,0)||chemList[k]==ChemItem(-1,0)){
                chemListIndex.add(k)
            }
            if(chemList[k]==ChemItem(-1,0)){
                e=k;
            }
        }
        var n=chemListIndex.size+1;

        for (i in 0 until m) {
            var array = arrayOf<Int>()
            for (j in 0 until n) {
                array += 0
            }
            baby += array
        }

        chemListIndex.add(0,-1)
        chemListIndex.add(chemList.size)

        for(i in 0 until  n){
            for(j in (chemListIndex[i]+1) until chemListIndex[i+1]){
                baby[chemList[j].type-1][i]+=sign(e-j)*chemList[j].num
            }
        }


        return baby
    }


    private fun sign(i:Int):Int{
        if(i>0){
            return 1;
        }else if(i<0){
            return -1;
        }else{
            return 0;
        }
    }


}