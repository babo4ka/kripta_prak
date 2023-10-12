package org.example.QuickExp;

import java.math.BigInteger;

public class Random {

    private static final BigInteger m = new BigInteger(String.valueOf(4294967296L));
    private static final BigInteger a = new BigInteger(String.valueOf(1664525));
    private static final BigInteger c = new BigInteger(String.valueOf(1013904223));

    private static BigInteger seed = new BigInteger(String.valueOf(1));

    public static BigInteger rand(BigInteger d){
        seed = ((((seed.multiply(a)).add(c)).mod(m)).mod(d));
        return seed;
    }

    public static BigInteger rand(){
        seed = (((seed.multiply(a)).add(c)).mod(m));
        return seed;
    }
}
