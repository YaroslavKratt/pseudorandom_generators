package lab1;

import java.util.ArrayList;
import java.util.Map;

public class EquaProbabilityOfSigns extends Test {
    double hiSquare=0;
    double Z=1.28155;     //0.9=1.28155, 0.95=1.64485, 0.99=2.32635
    double l=255;
    double hiSquare1MinusAlfa=Math.sqrt(2*l)*Z+l;
    public static final String EQUAL_PROBABILITY_OF_SIGNS_MASSEGE = "EquaProbabilityOfSigns lab1.Test";


    EquaProbabilityOfSigns(int alphaFlag){
        super(alphaFlag);
    }

    double calculate( Map<Integer,Integer> bytesMap) {
        int s=0;
        for(int i=0; i<256;i++) {
            int k;

            if(bytesMap.get(i)==null) {
                k = 0;
            }
            else{
                k=bytesMap.get(i);
            }
            hiSquare=hiSquare + Math.pow(k - (Generator.Nbyte / 256),2) / (Generator.Nbyte / 256);
        }
        return hiSquare;
    }
    void result( Map<Integer,Integer> bytesMap) {
        System.out.println(EquaProbabilityOfSigns.EQUAL_PROBABILITY_OF_SIGNS_MASSEGE);
        calculate(  bytesMap);
        System.out.println(Test.HI_POW_2+ hiSquare+ Test.HI_POW_2_1_MINUS_ALFA + hiSquare1MinusAlfa);
        if(hiSquare<=hiSquare1MinusAlfa) {
            System.out.println(Test.PASSED);
            System.out.println(Test.SEPARATOR);
        }
        else {
            System.out.println(Test.NOT_PASSED);
            System.out.println(Test.SEPARATOR);
        }
    }
}
