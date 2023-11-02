package millerRabinTask;

import Random.Random;
import quickExpTask.QuickExp.QuickEx;

import java.math.BigInteger;

public class PrimeChecker {

    public static boolean isPrime(BigInteger p, BigInteger n){
        if(n == null){
            n = BigLog.bigLog2(p);
        }

        if(p.compareTo(BigInteger.ZERO) == 0 || p.compareTo(BigInteger.ONE) == 0)return false;
        if(p.compareTo(BigInteger.TWO) == 0)return true;

        if(p.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)return false;

        BigInteger t = p.subtract(BigInteger.ONE);
        BigInteger s = BigInteger.ZERO;

        while(t.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0){
            t = t.divide(BigInteger.TWO);
            s = s.add(BigInteger.ONE);
        }

        Random r = new Random();
        for(BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)){
            BigInteger a = r.rand(BigInteger.TWO, p.subtract(BigInteger.TWO));

            BigInteger x = QuickEx.quickExpMod(a, t, p);
            if(x.compareTo(BigInteger.ONE) == 0 || x.compareTo(p.subtract(BigInteger.ONE)) == 0)continue;

            for(BigInteger j = BigInteger.ZERO; j.compareTo(s.subtract(BigInteger.ONE)) < 0; j = j.add(BigInteger.ONE)){
                x = QuickEx.quickExpMod(x, BigInteger.TWO, p);
                if(x.compareTo(BigInteger.ONE) == 0)return false;
                if(x.compareTo(n.subtract(BigInteger.ONE)) == 0)break;
            }
        }

        return true;
    }
}
