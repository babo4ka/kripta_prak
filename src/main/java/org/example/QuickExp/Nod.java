package org.example.QuickExp;

import java.math.BigInteger;

public class Nod {

    public static BigInteger nod(BigInteger a, BigInteger b){

        while (a.longValue() != 0 && b.longValue() != 0){
            if(a.longValue() > b.longValue()){
                a = a.mod(b);
            }else{
                b = b.mod(a);
            }
        }

        return a.add(b);
    }
}
