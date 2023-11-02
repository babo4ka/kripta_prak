package millerRabinTask;

import java.math.BigInteger;

public class BigLog {

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
}
