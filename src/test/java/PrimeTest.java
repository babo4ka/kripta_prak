import random.Random;
import millerRabinTask.PrimeNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeTest {

    @Test
    void sipmleTest(){
        PrimeNumbers pn = new PrimeNumbers();

        Assertions.assertFalse(pn.isPrime(BigInteger.ONE));
        Assertions.assertEquals(false, pn.isPrime(BigInteger.valueOf(156)));
        Assertions.assertEquals(true, pn.isPrime(BigInteger.valueOf(9929)));


        pn.setRounds(BigInteger.valueOf(15));
        Assertions.assertFalse(pn.isPrime(BigInteger.ONE));


        pn.setRounds(BigInteger.valueOf(5));
        Assertions.assertEquals(false, pn.isPrime(BigInteger.valueOf(177)));
    }


    @Test
    void fromFileTest() throws IOException {
        boolean[] expResults = {true, true, false, false, false, false, false, true};
        List<String> lines = new ArrayList<>();

        File file = new File("./src/test/resources/test.txt");

        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        String line;

        while((line = bReader.readLine()) != null){
            lines.add(line);
        }

        int i=0;

        for(String s : lines){
            String[] args = s.split(" ");
            PrimeNumbers checker = args.length<2?new PrimeNumbers():new PrimeNumbers(new BigInteger(args[1]));
            Assertions.assertEquals(expResults[i],
                    checker.isPrime(new BigInteger(args[0])));
            i++;
        }

    }

    @Test
    void testDifferentRounds(){
        Random r = new Random();
        PrimeNumbers checker1 = new PrimeNumbers();
        PrimeNumbers checker2 = new PrimeNumbers();
        for(int i=0;i<25;i++){
            BigInteger a = r.rand(25);
            checker1.setRounds(r.rand(BigInteger.TEN, BigInteger.valueOf(45)));
            checker2.setRounds(r.rand(BigInteger.valueOf(50), BigInteger.valueOf(100)));

            Assertions.assertEquals(checker1.isPrime(a), checker2.isPrime(a));
        }
    }
}
