package quickExpTask.Nod;

import java.math.BigInteger;

public class Nod {

    public static BigInteger nod(BigInteger a, BigInteger b){

        while (!a.equals(BigInteger.valueOf(0)) && !b.equals(BigInteger.valueOf(0))){
            if(a.compareTo(b) == 1){
                a = a.mod(b);
            }else{
                b = b.mod(a);
            }
        }

        return a.add(b);
    }
}
