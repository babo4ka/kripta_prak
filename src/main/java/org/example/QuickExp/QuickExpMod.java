package org.example.QuickExp;

import java.math.BigInteger;

public class QuickExpMod {

    public static BigInteger quickExpMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger mul = a.mod(m);

        String binaryB = Long.toBinaryString(b.longValue());

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = (result.multiply(mul)).mod(m);
            mul = (mul.multiply(mul)).mod(m);
        }


        return result;
    }
}
