package millerRabinTask;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String action;
        while(true){
            System.out.println("Выберите действие: 1 - ввод с консоли, 2 - ввод из файла, 3 - выход");
            action = sc.next();

            switch (action){
                case "1" -> {
                    System.out.println("Введите число и если хотите количество раундов");
                    String input = sc.next();
                    String[] argums = input.split(" ");
                    PrimeNumbers checker = argums.length<2?new PrimeNumbers():new PrimeNumbers(new BigInteger(argums[1]));
                    boolean isPrime = checker.isPrime(new BigInteger(argums[0]));
                    System.out.println(input + " " + (isPrime?"возможно простое":"составное"));
                }

                case "2" -> {
                    System.out.println("Введите имя файла");
                    String fileName = sc.next();

                    Map<String, Boolean> res = primesInFile(fileName + ".txt");

                    if(res == null){
                        System.out.println("файл " + fileName + " не найден или пустой");
                        break;
                    }
                    Set<String> keys = res.keySet();
                    for(String s:keys){
                        System.out.println(s + " " + (res.get(s)?"возможно простое":"составное"));
                    }
                }

                case "3" -> {
                    System.exit(0);
                }
            }
        }


    }

    public static Map<String, Boolean> primesInFile(String filePath) throws IOException {
        String path = "./src/main/resources/" + filePath;
        File file = new File(path);

        if(!file.exists())return null;

        Map<String, Boolean> result = new HashMap<>();

        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        String line;
        boolean isPrime;

        while((line = bReader.readLine()) != null){
            String[] args = line.split(" ");
            PrimeNumbers checker = args.length<2?new PrimeNumbers():new PrimeNumbers(new BigInteger(args[1]));
            isPrime = checker.isPrime(new BigInteger(args[0]));
            result.put(line, isPrime);
        }

        reader.close();
        bReader.close();

        return result.keySet().isEmpty()?null:result;
    }

}
