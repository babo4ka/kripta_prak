package quickExpTask;

import quickExpTask.QuickExp.Graphics;
import quickExpTask.QuickExp.QuickBigMath;
import random.Random;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите битовую длину числа: ");
        int length = sc.nextInt();

        Random rand = new Random();
        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        List<BigInteger> lengthList = new ArrayList<>();
        List<BigInteger> fastAlgDurs = new ArrayList<>();

        List<BigInteger> longAlgDurs = new ArrayList<>();

        for(int i=0; i<n;i++){
            BigInteger a = rand.rand(length);
            BigInteger b = rand.rand(length);
            BigInteger m = rand.rand(length);

            BigInteger startTime = new BigInteger(String.valueOf(System.nanoTime()));

            BigInteger answer = QuickBigMath.quickExpMod(a, b, m);

            BigInteger endTime = new BigInteger(String.valueOf(System.nanoTime()));

            lengthList.add(BigInteger.valueOf(a.toString(2).length()));

            BigInteger time = (endTime.subtract(startTime));

            fastAlgDurs.add(time);

            startTime = new BigInteger(String.valueOf(System.nanoTime()));

            answer = QuickBigMath.quickExp(a, b).mod(m);

            endTime = new BigInteger(String.valueOf(System.nanoTime()));


            time = (endTime.subtract(startTime));

            longAlgDurs.add(time);


            System.out.println("============\n" +
                    a + " ^ " + b + " % " + m + " = " + answer);

            length++;
        }

        Graphics graphics = new Graphics(lengthList, fastAlgDurs, longAlgDurs);
        graphics.showGraphics();
    }
}
