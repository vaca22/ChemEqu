package com.vaca.chemicalequation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var water= ArrayList <ChemItem> ()
        var waterIndex= ArrayList <Int> ()

        water.add(ChemItem(1,2))
        water.add(ChemItem(0,0))
        water.add(ChemItem(2,2))
        water.add(ChemItem(-1,0))
        water.add(ChemItem(1,2))
        water.add(ChemItem(2,1))



        var m=0;
        var e=0;

        for(k in water.indices){
            if(water[k].type>m){
                m=water[k].type
            }

            if(water[k]==ChemItem(0,0)||water[k]==ChemItem(-1,0)){
                waterIndex.add(k)
            }
            if(water[k]==ChemItem(-1,0)){
                e=k;
            }
        }

        var n=waterIndex.size+1;



        var cinema = arrayOf<Array<Int>>()

        for (i in 0..m) {
            var array = arrayOf<Int>()
            for (j in 0..n) {
                array += 0
            }
            cinema += array
        }




        waterIndex.add(0,-1)
        waterIndex.add(water.size)
        Log.e("fuck",waterIndex.size.toString())


        for(i in 0 until  n){
            for(j in (waterIndex[i]+1) until waterIndex[i+1]){
                cinema[water[j].type-1][i]+=sign(e-j)*water[j].num
            }
        }



//        for(i in 0 until  m){
//            for(j in 0 until n){
//              println("($i,$j,${cinema[i][j]})")
//            }
//        }



        val xx=RationalNumber(25,15).add(RationalNumber(46,78))




        Log.e("fuck","撒旦立刻就福建烤老鼠的 ${xx.numerator}/${xx.denominator}   ")
    }



    fun sign(i:Int):Int{
        if(i>0){
            return 1;
        }else if(i<0){
            return -1;
        }else{
            return 0;
        }
    }



    fun rrefx1(chem: Array<Array<Int>> ){


    }
}








/*


LOCAL Tou;
LOCAL a:="",ab:="",ac:="",x:=50;
LOCAL Al_state:=0,Sh_state:=0,Ru_state:=0,Rd_state:=0;
LOCAL k1:=50,k2:=50;
Gr()
BEGIN
RECT_P(G1,(x-50,0),(x+270,30),#FFFFFFh);
TEXTOUT_P(a,G1,10,0,U,0,511,#FFFFFFh);

BLIT_P(G0,(0,100),(320,130),G1,(x-50,0),(x+270,30));
END;
Gr2()
BEGIN
RECT_P(G1,(x-50,0),(x+270,30),#FFFFFFh);
TEXTOUT_P(a,G1,10,0,U,0,511,#FF00h);

BLIT_P(G0,(0,100),(320,130),G1,(x-50,0),(x+270,30));
END;
Gr3(n,t)
BEGIN
RECT_P(G2,(t-50,0),(t+270,30),#FFFFFFh);
TEXTOUT_P(n,G2,10,0,V,#FFh,511,#FFFFFFh);
BLIT_P(G0,(0,150),(320,180),G2,(t-50,0),(t+270,30));
END;

Gr4(n,t)
BEGIN
RECT_P(G3,(t-50,0),(t+270,30),#FFFFFFh);
TEXTOUT_P(n,G3,10,0,V,#FF0000h,511,#FFFFFFh);
BLIT_P(G0,(0,190),(320,220),G3,(t-50,0),(t+270,30));
END;


Render_state()
BEGIN
RECT_P((0,0),(100,30),#FFFFFFh);
IF Al_state THEN
IF Sh_state THEN
TEXTOUT_P("a⋯z",(5,0),5,#FF00FFh,320);
ELSE
TEXTOUT_P("A⋯Z",(5,0),5,#FF00FFh,320);
END;
ELSE
TEXTOUT_P("0⋯9",(5,0),5,#FF00FFh,320);
END;
END;


UpA:={186,185,178,179,8308,8309,8310,8311,8312,8313};
DnA:={8320,8321,8322,8323,8324,8325,8326,8327,8328,8329};
Ghost:={47,42,43,44,37,38,39,32,33,34};
Alp:={14,15,16,17,18,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,37,38,39,40,42,43};


Cui()
BEGIN

x:=50;

Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;

Render_state();

a:="";
REPEAT

REPEAT
A:=GETKEY;
Tou:=MOUSE();
IF SIZE(Tou(1)) THEN
IF Tou(1,1)>270 AND Tou(1,2)<30 THEN
BLIT_P(G4,G0);
INPUT({{U,{1,2,3,4,5,6,7},{50,20,1}},{V,{1,2,3,4,5},{50,20,3}}},"设置",{"输入字体大小  ","记录字体大小  "});
BLIT_P(G4);
END;
IF Tou(1,5)==2 THEN
IF Tou(1,2)<140 THEN
x:=x-(Tou(1,1)-Tou(1,3))/220;
IF x>150 THEN
x:=150;
END;

ELSE
IF Tou(1,2)<180 THEN
k1:=k1-(Tou(1,1)-Tou(1,3))/220;
ELSE
k2:=k2-(Tou(1,1)-Tou(1,3))/220;
END;

END;



Gr();
Gr3(ab,k1);
Gr4(ac,k2);

END;
END;

UNTIL A≠−1;

IF A==19 THEN
RECT_P(G0,110,20,260,50,#FFFFFFh);
IF DIM(a) THEN
a:=MID(a,1,DIM(a)-1);
END;


Gr();
END;


IF A==30 THEN
RETURN a;
END;

IF A==8 THEN
Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;
Render_state();
CONTINUE;
END;


IF A==31 THEN
a:=a+"→";
Gr();
Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;
Render_state();
CONTINUE;
END;

IF A==2 THEN
a:=a+"(";
Gr();
CONTINUE;
END;

IF A==12 THEN
a:=a+")";
Gr();
CONTINUE;
END;



IF A==48 THEN
Ru_state:=1;
Rd_state:=0;
Al_state:=0;Sh_state:=0;
Render_state();
CONTINUE;
END;


IF A==49 THEN
Rd_state:=1;
Ru_state:=0;
Al_state:=0;Sh_state:=0;
Render_state();

CONTINUE;
END;




IF (Al_state==0)  AND (Ru_state==0) THEN
IF K:=POS(Ghost,A) THEN
a:=a+CHAR(DnA(K));
Gr();
CONTINUE;
END;
Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;
Render_state();
END;

IF Ru_state THEN
IF K:=POS(Ghost,A) THEN
a:=a+CHAR(UpA(K));
Gr();
CONTINUE;
END;


IF A==50 THEN
a:=a+"⁺";
Gr();
Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;
Render_state();
CONTINUE;
END;

IF A==45 THEN
a:=a+"⁻";
Gr();
Al_state:=1;Sh_state:=0;
Ru_state:=0;Rd_state:=0;
Render_state();
CONTINUE;
END;

END;

IF A==50 THEN
a:=a+"+";
Gr();
CONTINUE;
END;

IF A==45 THEN
a:=a+"-";
Gr();
CONTINUE;
END;


IF A==36 THEN
Al_state:=1-Al_state;
Render_state();
CONTINUE;
END;


IF A==41 THEN
Sh_state:=1;
Al_state:=1;
Render_state();
CONTINUE;
END;





IF Al_state THEN
IF K:=POS(Alp,A) THEN
IF Sh_state THEN
a:=a+CHAR(96+K);
Sh_state:=0;
Render_state();
ELSE
a:=a+CHAR(64+K);
END;
Gr();
CONTINUE;
END;
END;

UNTIL A==4;
RETURN "ᴇ";
END;




ConV(ST,K)
BEGIN
LOCAL Num:="",Size,A,Ord:=K;
Size:=DIM(ST);
WHILE K≤Size DO
A:=ASC(MID(ST,K,1));
IF A(1)≥48 AND A(1)≤57  OR A(1)=8722 THEN
Num:=Num+MID(ST,K,1);
K:=K+1;
ELSE
BREAK;
END;
END;
IF K==Ord THEN
RETURN 1;
ELSE
RETURN EXPR(Num);
END;
END;

Kind_Num(Ele)
BEGIN
LOCAL L,EleList:={},K,AS,NumList={},Kind:=1;
LOCAL Lower,Hol,Lon;
LOCAL t:=0,x:={};
L1:={};
L:=DIM(Ele);
AS:=ASC(Ele);
FOR K FROM 1 TO L DO
IF AS(K)==43 THEN
L1:=CONCAT(L1,{0});
END;
IF AS(K)==61 THEN
L1:=CONCAT(L1,{−1});
END;
IF AS(K)==40 THEN
Lower:=K;
t:=1;
x:={};
END;
IF AS(K)==41 THEN
t:=0;
ConV(Ele,K+1)▶Hol;
Lon:=SIZE(L1);
FOR J FROM 1 TO SIZE(x) DO
L1(x(J)):=(RE(L1(x(J))),Hol*IM(L1(x(J))));
END;
END;
IF AS(K)≥65 AND AS(K)≤90 THEN
IF K<L THEN
IF AS(K+1)≥97 AND AS(K+1)≤122 THEN
CONCAT(NumList,{ConV(Ele,K+2)})▶NumList;
IF POS(EleList,MID(Ele,K,2))==0 THEN
CONCAT(L1,{Kind+*ConV(Ele,K+2)})▶L1;
Kind:=Kind+1;
CONCAT(EleList,{MID(Ele,K,2)})▶EleList;
ELSE
CONCAT(L1,{(POS(EleList,MID(Ele,K,2)),ConV(Ele,K+2))})▶L1;
END;
IF t==1 THEN
x(0):=SIZE(L1);
END;

ELSE
CONCAT(NumList,{ConV(Ele,K+1)})▶NumList;
IF POS(EleList,MID(Ele,K,1))==0 THEN
L1:=CONCAT(L1,{(Kind,ConV(Ele,K+1))});
Kind:=Kind+1;
EleList:=CONCAT(EleList,{MID(Ele,K,1)});
ELSE
L1:=CONCAT(L1,{(POS(EleList,MID(Ele,K,1)),ConV(Ele,K+1))});
END;
IF t==1 THEN
x(0):=SIZE(L1);
END;
END;
ELSE
CONCAT(NumList,{1})▶NumList;
IF POS(EleList,MID(Ele,K,1))==0 THEN
L1:=CONCAT(L1,{(Kind,ConV(Ele,K+1))});
Kind:=Kind+1;
EleList:=CONCAT(EleList,{MID(Ele,K,1)});
ELSE
L1:=CONCAT(L1,{(POS(EleList,MID(Ele,K,1)),1)});
END;
END;
END;
END;
RETURN EleList;
END;



Local D2F(L2)
BEGIN
LOCAL K,A,L3;
L3:=ASC(L2);
FOR K FROM 1 TO SIZE(L3) DO
A:=POS(L3(K),47);
IF A≠0 THEN
L4(K):=EXPR(LEFT(L2(K),A-1));
L5(K):=EXPR(RIGHT(L2(K),SIZE(L3(K))-A));
ELSE
L4(K):=EXPR(L2(K));
L5(K):=1;
END;
END;
END;

EXPORT ChemEqu3()
BEGIN
U:=5;
V:=3;
a:="";ab:="";ac:="";
RECT_P(#FFFFFFh);
DIMGROB_P(G1,512,30);
DIMGROB_P(G2,512,30);
DIMGROB_P(G3,512,30);
DIMGROB_P(G4,320,240);
TEXTOUT_P("设置",G0,275,0,7,#FFFF00h,320,#FFh);
WHILE 1 DO


LOCAL Equation:=Cui;
IF DIM(Equation)==0 THEN
CONTINUE;
END;
IF Equation=="ᴇ" THEN
RETURN;
END;

Equation:=ASC(Equation);
LOCAL Equa:=Equation;
L:=SIZE(Equation);
FOR K FROM 1 TO L DO
IF (Equation(K)≥8320) AND (Equation(K)≤8329) THEN
Equation(K):=Equation(K)-8320+48;
END;
END;







REPEAT
K:=POS(Equation,8314);
IF K≠0 THEN
IF POS(UpA,Equation(K-1))==0 THEN
Equation:=INSERT(Equation,K,UpA(2));
K:=K+1;
END;
J:=K;
REPEAT
J:=J-1;
UNTIL POS(UpA,Equation(J))==0;
REPEAT
Equation(K):=Equation(K-1);
K:=K-1;
UNTIL (J+1)==K;
Equation(K):=69;
K:=1;
END;
UNTIL K==0;



REPEAT
K:=POS(Equation,8315);
IF K≠0 THEN
IF POS(UpA,Equation(K-1))==0 THEN
Equation:=INSERT(Equation,K,UpA(2));
K:=K+1;
END;
Equation:=INSERT(Equation,K+1,UpA(2));
J:=K;
REPEAT
J:=J-1;
UNTIL POS(UpA,Equation(J))==0;

REPEAT
Equation(K+1):=Equation(K-1);
K:=K-1;
UNTIL (J+1)==K;
Equation(K):=69;
Equation(K+1):=8722;
K:=1;
END;
UNTIL K==0;



L:=SIZE(Equation);
FOR K FROM 1 TO L DO
IF J:=POS(UpA,Equation(K)) THEN
Equation(K):=J+47;
END;
END;




Equation:=CHAR(Equation);
Equation:=REPLACE(Equation,"→","=");
Equation:=REPLACE(Equation,"-","−");
Kind_Num(Equation);
L2:={};
L3:={};
L4:={};
L5:={};
M:=0;
FOR K FROM 1 TO SIZE(L1) DO
IF RE(L1(K))>M THEN
M:=RE(L1(K));
END;
IF L1(K)==0 OR L1(K)==−1 THEN
L2:=CONCAT(L2,{K});
END;
IF L1(K)==−1
THEN
E:=K;
END;
END;
N:=1+SIZE(L2);
M1:=MAKEMAT(0,M,N);
L2:=CONCAT({0},L2);
L2:=CONCAT(L2,{SIZE(L1)+1});
FOR I FROM 1 TO N DO
FOR J FROM L2(I)+1 TO L2(I+1)-1 DO
M1(RE(L1(J)),I):=SIGN(E-J)*IM(L1(J))+M1(RE(L1(J)),I);
END;
END;
M1:=RREF(M1);
L2:=MAKELIST(M1(A,N),A,1,N-1,1);
L2:=CONCAT(L2,{1});
L2:=ABS(L2);
L3:={};
FOR K FROM 1 TO SIZE(L2) DO
L2(K):=STRING(L2(K),7,7);
END;
D2F(L2);
C:=CAS.lcm(L5);
L2:=(C/L5)*L4;
L:=SIZE(L2);

FOR K FROM 1 TO L DO
L2(K):=ASC(STRING(L2(K)));
END;

K:=2;

IF EQ(L2(1),{49}) THEN
L1:={};
ELSE
L1:=L2(1);
END;





I:=2;
L:=SIZE(Equa);
FOR J FROM 1 TO L DO
IF (Equa(J)==43) OR (Equa(J)==8594) THEN
L1(0):=Equa(J);
IF EQ(L2(I),{49})==0 THEN
L1:=CONCAT(L1,L2(I));
END;

I:=I+1;
ELSE
L1(0):=Equa(J);
END;
END;
IF (H:=POS(L1,48))≠0 THEN
IF H==1 THEN
TEXTOUT_P("输入错误",G0,120,30,5,#FF0000h,320,#FFFFFFh);
CONTINUE;
END;
IF L1(H-1)<48 OR L1(H-1)>57 THEN
TEXTOUT_P("输入错误",G0,120,30,5,#FF0000h,320,#FFFFFFh);
CONTINUE;
END;


END;

a:=CHAR(L1);
x:=50;Gr2();
WHILE  NOT ISKEYDOWN(19) DO
IF ISKEYDOWN(4) THEN
RETURN;
END;

Tou:=MOUSE();
IF SIZE(Tou(1)) THEN
IF Tou(1,5)==2 THEN
IF Tou(1,2)<140 THEN
x:=x-(Tou(1,1)-Tou(1,3))/220;
IF x>150 THEN
x:=150;
END;

ELSE
IF Tou(1,2)<180 THEN
k1:=k1-(Tou(1,1)-Tou(1,3))/220;
ELSE
k2:=k2-(Tou(1,1)-Tou(1,3))/220;
END;

END;



Gr2();
Gr3(ab,k1);
Gr4(ac,k2);
END;
END;
END;

ac:=ab;
ab:=a;
k1:=50;
k2:=50;
IF DIM(ab)>0 THEN
Gr3(ab,k1);
END;
IF DIM(ac)>0 THEN
Gr4(ac,k2);
END;
END;



END;*/
