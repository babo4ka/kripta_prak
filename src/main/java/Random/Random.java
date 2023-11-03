package Random;

import quickExpTask.QuickExp.QuickBigMath;

import java.math.BigInteger;

public class Random {

    private final BigInteger m = new BigInteger(String.valueOf(4294967296L));
    private final BigInteger a = new BigInteger(String.valueOf(1664525));
    private final BigInteger c = new BigInteger(String.valueOf(1013904223));

    private BigInteger seed = new BigInteger(String.valueOf(1));


    public BigInteger rand(BigInteger length){
        BigInteger min = (QuickBigMath.quickExp(new BigInteger(String.valueOf(2)), length)).divide(BigInteger.valueOf(2));
        BigInteger max = QuickBigMath.quickExp(new BigInteger(String.valueOf(2)), length).subtract(BigInteger.valueOf(1));
        return rand(min, max);
    }

    public BigInteger rand(BigInteger min, BigInteger max){
        max = max.subtract(min);
        seed = ((((seed.multiply(a)).add(c)).mod(m)).mod(max)).add(min);
        return seed;
    }

}
