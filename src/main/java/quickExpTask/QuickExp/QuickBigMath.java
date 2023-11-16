package quickExpTask.QuickExp;

import java.math.BigInteger;

public class QuickBigMath {

    public static BigInteger quickExp(BigInteger a, BigInteger b){

        BigInteger result = BigInteger.ONE;
        BigInteger mul = a;

        String binaryB = b.toString(2);

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = result.multiply(mul);
            mul = mul.multiply(mul);
        }

        return result;
    }

    public static BigInteger quickExpMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger mul = a.mod(m);

        String binaryB = b.toString(2);

        for(int i=binaryB.length()-1; i>=0;i--){
            if(binaryB.charAt(i) == '1')
                result = (result.multiply(mul)).mod(m);
            mul = (mul.multiply(mul)).mod(m);
        }


        return result;
    }


    public static BigInteger bigLog2(BigInteger n){
        String binary = n.toString(2);
        int place = 0;
        for(int i=0; i<binary.length();i++){
            if(binary.charAt(i) == '1'){
                place = i;
                break;
            }
        }
        place = (binary.length()-1) - place;

        return new BigInteger(String.valueOf(place));
    }


    public static BigInteger nod(BigInteger a, BigInteger b){

        while (!a.equals(BigInteger.valueOf(0)) && !b.equals(BigInteger.valueOf(0))){
            if(a.compareTo(b) > 0){
                a = a.mod(b);
            }else{
                b = b.mod(a);
            }
        }

        return a.add(b);
    }
}
