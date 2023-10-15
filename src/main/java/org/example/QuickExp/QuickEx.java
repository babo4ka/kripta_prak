package org.example.QuickExp;

import java.math.BigInteger;

public class QuickEx {

    public static BigInteger quickExp(BigInteger a, BigInteger b){

        BigInteger result = BigInteger.ONE;
        BigInteger mul = a;

        String binaryB = b.toString(2);

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = result.multiply(mul);
            mul = mul.multiply(mul);
        }

        return result;
    }

    public static BigInteger quickExpMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger mul = a.mod(m);

        String binaryB = b.toString(2);

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = (result.multiply(mul)).mod(m);
            mul = (mul.multiply(mul)).mod(m);
        }


        return result;
    }
}
