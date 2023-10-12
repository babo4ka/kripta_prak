package org.example.QuickExp;

import java.math.BigInteger;

public class QuickExpMod {

    public static BigInteger quickExpMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger prev = a.mod(m);

        String binaryB = Long.toBinaryString(b.longValue());

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = (result.multiply(prev)).mod(m);
            prev = (prev.multiply(prev)).mod(m);
        }

        return result;
    }
}
