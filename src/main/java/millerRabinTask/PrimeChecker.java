package millerRabinTask;

import Random.Random;
import quickExpTask.QuickExp.QuickBigMath;

import java.math.BigInteger;

public class PrimeChecker {

    public static boolean isPrime(BigInteger p, BigInteger n){
        if(n == null){
            n = QuickBigMath.bigLog2(p);
        }


        if(p.compareTo(BigInteger.TWO) < 0)return false;
        if(p.compareTo(BigInteger.TWO) == 0 || p.compareTo(BigInteger.valueOf(3)) == 0)return true;

        if(p.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)return false;

        BigInteger t = p.subtract(BigInteger.ONE);
        int s = 0;

        while(t.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0){
            t = t.divide(BigInteger.TWO);
            s++;
        }

        Random r = new Random();
        for(BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)){
            BigInteger a = r.rand(BigInteger.TWO, p.subtract(BigInteger.TWO));

            BigInteger x = QuickBigMath.quickExpMod(a, t, p);
            if(x.compareTo(BigInteger.ONE) == 0 || x.compareTo(p.subtract(BigInteger.ONE)) == 0)continue;

            for(int j=0; j<s-1;j++){
                x = QuickBigMath.quickExpMod(x, BigInteger.TWO, p);
                if(x.compareTo(BigInteger.ONE) == 0)return false;
                if(x.compareTo(p.subtract(BigInteger.ONE)) == 0)break;
            }

            if(!x.equals(p.subtract(BigInteger.ONE))) return false;
        }

        return true;
    }
}
