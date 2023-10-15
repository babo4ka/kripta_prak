package org.example;

import org.example.QuickExp.Graphics;
import org.example.QuickExp.QuickEx;
import org.example.QuickExp.Random;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите битовую длину числа a: ");
        BigInteger aLength = sc.nextBigInteger();
        System.out.println("Введите битовую длину числа b: ");
        BigInteger bLength = sc.nextBigInteger();

        Random rand = new Random();
        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        List<BigInteger> aList = new ArrayList<>();
        List<BigInteger> bList = new ArrayList<>();

        List<BigInteger> aTimes = new ArrayList<>();
        List<BigInteger> bTimes = new ArrayList<>();

        for(int i=0; i<n;i++){
            BigInteger a = rand.rand(aLength);
            BigInteger b = rand.rand(bLength);
            BigInteger m = rand.rand(aLength);

            BigInteger startTime = new BigInteger(String.valueOf(System.nanoTime()));

            BigInteger answer = QuickEx.quickExpMod(a, b, m);

            BigInteger endTime = new BigInteger(String.valueOf(System.nanoTime()));

            aList.add(a);
            bList.add(b);

            BigInteger time = (endTime.subtract(startTime));
//            System.out.println("start time = " + startTime);
//            System.out.println("end time = " + endTime);
//            System.out.println("time = " + time);

            aTimes.add(time);
            bTimes.add(time);

            System.out.println("============\n" +
                    a + " ^ " + b + " % " + m + " = " + answer);

            aLength = aLength.add(BigInteger.TEN);
            bLength = bLength.add(BigInteger.valueOf(15));
        }

        Graphics graphics = new Graphics.GraphicsBuilder(aList, bList, aTimes, bTimes).build();
        graphics.showGraphics();
    }

}