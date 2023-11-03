import quickExpTask.QuickExp.QuickBigMath;
import Random.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class QuickExTest {


    @Test
    void testQuickExp(){
        Assertions.assertEquals(new BigInteger(String.valueOf(4)),
                QuickBigMath.quickExp(new BigInteger(String.valueOf(2)), new BigInteger(String.valueOf(2))));

        Assertions.assertEquals(new BigInteger(String.valueOf(125)),
                QuickBigMath.quickExp(new BigInteger(String.valueOf(5)), new BigInteger(String.valueOf(3))));

        Assertions.assertEquals(new BigInteger(String.valueOf(225)),
                QuickBigMath.quickExp(new BigInteger(String.valueOf(15)), new BigInteger(String.valueOf(2))));

        Assertions.assertEquals(new BigInteger(String.valueOf(1024)),
                QuickBigMath.quickExp(new BigInteger(String.valueOf(4)), new BigInteger(String.valueOf(5))));
    }

    @Test
    void testQuickExpN(){
        Assertions.assertFalse(new BigInteger(String.valueOf(4))
                .equals(QuickBigMath.quickExp(new BigInteger(String.valueOf(2)), new BigInteger(String.valueOf(6)))));

        Assertions.assertFalse(new BigInteger(String.valueOf(100))
                .equals(QuickBigMath.quickExp(new BigInteger(String.valueOf(25)), new BigInteger(String.valueOf(2)))));

        Assertions.assertFalse(new BigInteger(String.valueOf(15))
                .equals(QuickBigMath.quickExp(new BigInteger(String.valueOf(2)), new BigInteger(String.valueOf(2)))));

        Assertions.assertFalse(new BigInteger(String.valueOf(60))
                .equals(QuickBigMath.quickExp(new BigInteger(String.valueOf(3)), new BigInteger(String.valueOf(8)))));

    }

    @Test
    void quickExpModTest(){
        Assertions.assertEquals(new BigInteger(String.valueOf(6)),
                QuickBigMath.quickExpMod(new BigInteger(String.valueOf(3)), new BigInteger(String.valueOf(45)),
                        new BigInteger(String.valueOf(7))));
    }


    @Test
    void testModEq(){
        BigInteger a = new BigInteger(String.valueOf(315));
        BigInteger b = new BigInteger(String.valueOf(23));
        BigInteger m = new BigInteger(String.valueOf(13));

        Assertions.assertEquals(QuickBigMath.quickExp(a,b).mod(m),
                QuickBigMath.quickExpMod(a,b,m));
    }

    @Test
    void testRandom(){
        BigInteger [] lengths = {new BigInteger(String.valueOf(10)), new BigInteger(String.valueOf(24)),
                new BigInteger(String.valueOf(105)), new BigInteger(String.valueOf(156)),
                new BigInteger(String.valueOf(174))};

        Random rand = new Random();

        Arrays.stream(lengths).toList().forEach(a ->
                Assertions.assertEquals(a,
                        new BigInteger(String.valueOf(rand.rand(a).toString(2).length()))));
    }
}
