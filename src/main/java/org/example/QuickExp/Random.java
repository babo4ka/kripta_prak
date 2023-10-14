package org.example.QuickExp;

import java.math.BigInteger;

public class Random {

    private final BigInteger m = new BigInteger(String.valueOf(4294967296L));
    private final BigInteger a = new BigInteger(String.valueOf(1664525));
    private final BigInteger c = new BigInteger(String.valueOf(1013904223));

    private BigInteger seed = new BigInteger(String.valueOf(1));



//    public BigInteger rand(BigInteger length){
//        BigInteger m = QuickEx.quickExp(new BigInteger(String.valueOf(2)), length);
//
//        seed = (((seed.multiply(a))).mod(m));
//        return seed;
//    }

//    public static void main(String[] args) {
//        BigInteger l = new BigInteger(String.valueOf(50));
//        for(int i=0; i<10; i++){
//            BigInteger a = rand(new BigInteger(String.valueOf(l)));
//            System.out.println(Long.toBinaryString(a.longValue()));
//            System.out.println(Long.toBinaryString(a.longValue()).length());
//            l.add(BigInteger.valueOf(50));
//        }
//
//    }


    public BigInteger rand(BigInteger length){
        BigInteger min = (QuickEx.quickExp(new BigInteger(String.valueOf(2)), length)).divide(new BigInteger(String.valueOf(2)));
        BigInteger max = QuickEx.quickExp(new BigInteger(String.valueOf(2)), length);
        max = max.subtract(min);
        seed = ((((seed.multiply(a)).add(c)).mod(m)).mod(max)).add(min);
        return seed;
    }
//
//    public static BigInteger rand(){
//        seed = ((((seed.multiply(a)).add(c)).mod(m)));
//        return seed;
//    }
}
