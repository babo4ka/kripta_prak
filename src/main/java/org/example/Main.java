package org.example;

import org.example.QuickExp.Graphics;
import org.example.QuickExp.QuickExpMod;
import org.example.QuickExp.Random;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину числа: ");
        BigInteger length = sc.nextBigInteger();
//        Random rand = setRandom(length);
        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        List<BigInteger> aList = new ArrayList<>();
        List<BigInteger> bList = new ArrayList<>();

        List<BigInteger> aTimes = new ArrayList<>();
        List<BigInteger> bTimes = new ArrayList<>();

        for(int i=0; i<n;i++){

            System.out.println(length);
//            BigInteger a = rand.rand(length);
//            BigInteger b = rand.rand(length);
//            BigInteger m = rand.rand(length);

            BigInteger startTime = new BigInteger(String.valueOf(System.currentTimeMillis()));

//            BigInteger answer = QuickExpMod.quickExpMod(a, b, m);

            BigInteger endTime = new BigInteger(String.valueOf(System.currentTimeMillis()));

//            aList.add(a);
//            bList.add(b);

            BigInteger time = (endTime.subtract(startTime));

            aTimes.add(time);
            bTimes.add(time);

//            System.out.println(a + "^" + b + "%" + m + " = " + answer);

            length = length.add(BigInteger.valueOf(50));
        }

        Graphics graphics = new Graphics(aList, bList, aTimes, bTimes);
        graphics.showGraphics();
    }


//    public static Random setRandom(BigInteger length){
//
//
//        Random rand;
//        try {
//             rand = new Random(length);
//        } catch (Exception e) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Введите длину числа: ");
//            length = sc.nextBigInteger();
//            return setRandom(length);
//        }
//
//        return rand;
//    }
}