package millerRabinTask;

import random.Random;

import java.math.BigInteger;

public class Main2 {
    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
        Random r = new Random();


        for (int i =0; i<15; i++){
            System.out.println(pn.generatePrime(25));
        }

        for(int i =0; i<15; i++){
            System.out.println(pn.generatePrime(9));
        }
    }
}
