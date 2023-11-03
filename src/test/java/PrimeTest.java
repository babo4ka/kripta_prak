import Random.Random;
import millerRabinTask.PrimeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeTest {

    @Test
    void sipmleTest(){
        Assertions.assertFalse(PrimeChecker.isPrime(BigInteger.ONE, null));
        Assertions.assertFalse(PrimeChecker.isPrime(BigInteger.ONE, BigInteger.valueOf(15)));

        Assertions.assertEquals(false, PrimeChecker.isPrime(BigInteger.valueOf(156), null));

        Assertions.assertEquals(false, PrimeChecker.isPrime(BigInteger.valueOf(177), BigInteger.valueOf(5)));

        Assertions.assertEquals(true, PrimeChecker.isPrime(BigInteger.valueOf(9929), null));
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
            Assertions.assertEquals(expResults[i],
                    PrimeChecker.isPrime(new BigInteger(args[0]), args.length>1?new BigInteger(args[1]):null));
            i++;
        }

    }

    @Test
    void testDifferentRounds(){
        Random r = new Random();
        for(int i=0;i<25;i++){
            BigInteger a = r.rand(BigInteger.valueOf(25));
            Assertions.assertEquals(PrimeChecker.isPrime(a, r.rand(BigInteger.TEN, BigInteger.valueOf(45))),
                    PrimeChecker.isPrime(a, r.rand(BigInteger.valueOf(50), BigInteger.valueOf(100))));
        }
    }
}
