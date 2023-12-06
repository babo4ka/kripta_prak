package millerRabinTask;

import random.Random;
import quickExpTask.QuickExp.QuickBigMath;

import java.math.BigInteger;

public class PrimeNumbers {

    private BigInteger rounds;

    public PrimeNumbers(BigInteger rounds){this.rounds = rounds;}
    public PrimeNumbers(){this.rounds = null;}

    public void setRounds(BigInteger rounds){this.rounds = rounds;}



    public boolean isPrime(BigInteger p){
        if(this.rounds == null){
            this.rounds = QuickBigMath.bigLog2(p);
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
        for(BigInteger i = BigInteger.ZERO; i.compareTo(this.rounds) < 0; i = i.add(BigInteger.ONE)){
            BigInteger a = r.rand(BigInteger.ONE, p.subtract(BigInteger.ONE));

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


    private final Random random = new Random();
    public BigInteger generatePrime(int length){
        BigInteger result = this.random.rand(length);

        while(!this.isPrime(result)){
            result = this.random.rand(length);
        }
        return result;
    }
}
