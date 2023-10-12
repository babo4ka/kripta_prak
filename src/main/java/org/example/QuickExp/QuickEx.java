package org.example.QuickExp;

import java.math.BigInteger;

public class QuickEx {

    public static BigInteger quickExp(BigInteger a, BigInteger b){
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger prev = a;

        String binaryB = Long.toBinaryString(b.longValue());

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = result.multiply(prev);
            prev = prev.multiply(prev);
        }

        return result;
    }
}