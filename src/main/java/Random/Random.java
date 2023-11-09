package Random;

import quickExpTask.QuickExp.QuickBigMath;

import java.math.BigInteger;

public class Random {

    private final BigInteger m = new BigInteger(String.valueOf(4294967296L)); //2^32
    private final BigInteger a = new BigInteger(String.valueOf(1664525));
    private final BigInteger c = new BigInteger(String.valueOf(1013904223));

    private BigInteger seed = new BigInteger(String.valueOf(1));


    public BigInteger rand(int length){
        BigInteger min = (QuickBigMath.quickExp(BigInteger.TWO, BigInteger.valueOf(length-1)));
        BigInteger max = QuickBigMath.quickExp(BigInteger.TWO, BigInteger.valueOf(length)).subtract(BigInteger.ONE);
        return rand(min, max);
    }

    public BigInteger rand(BigInteger min, BigInteger max){
        max = max.subtract(min);
        seed = seed.multiply(a).add(c).mod(m);
        return seed.mod(max).add(min);
    }

}
