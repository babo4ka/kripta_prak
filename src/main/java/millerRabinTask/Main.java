package millerRabinTask;

import quickExpTask.QuickExp.QuickBigMath;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger p = BigInteger.valueOf(9975);
        BigInteger n = BigInteger.valueOf(8);
        System.out.println(PrimeChecker.isPrime(p, null));

    }
}
