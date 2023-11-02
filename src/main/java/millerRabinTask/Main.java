package millerRabinTask;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger p = BigInteger.valueOf(9);
        BigInteger n = BigInteger.valueOf(4);
        System.out.println(PrimeChecker.isPrime(p, null));
    }
}
