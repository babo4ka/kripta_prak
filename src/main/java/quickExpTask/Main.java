package quickExpTask;

import quickExpTask.QuickExp.Graphics;
import quickExpTask.QuickExp.QuickEx;
import Random.Random;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите битовую длину числа");
        BigInteger length = sc.nextBigInteger();


        Random rand = new Random();
        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        List<BigInteger> lengthList = new ArrayList<>();
        List<BigInteger> fastAlgDurs = new ArrayList<>();


        for(int i=0; i<n;i++){
            BigInteger a = rand.rand(length);
            BigInteger b = rand.rand(length);
            BigInteger m = rand.rand(length);

            BigInteger startTime = new BigInteger(String.valueOf(System.nanoTime()));

            BigInteger answer = QuickEx.quickExpMod(a, b, m);

            BigInteger endTime = new BigInteger(String.valueOf(System.nanoTime()));

            lengthList.add(BigInteger.valueOf(a.toString(2).length()));

            BigInteger time = (endTime.subtract(startTime));

            fastAlgDurs.add(time);

            System.out.println("============\n" +
                    a + " ^ " + b + " % " + m + " = " + answer);

            length = length.add(BigInteger.TEN);
        }

        Graphics graphics = new Graphics(lengthList, fastAlgDurs, null);
        graphics.showGraphics();
    }

}