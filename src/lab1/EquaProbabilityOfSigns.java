package lab1;

import java.util.ArrayList;
import java.util.Map;

public class EquaProbabilityOfSigns extends Test {
    double hiSquare=0;
    double Z=1.28155;     //0.9=1.28155, 0.95=1.64485, 0.99=2.32635
    double l=255;
    double hiSquare1MinusAlfa=Math.sqrt(2*l)*Z+l;
    public static final String EQUAL_PROBABILITY_OF_SIGNS_MASSEGE = "EquaProbabilityOfSigns lab1.Test";
    Map<Integer,Integer> bytesMap;

    EquaProbabilityOfSigns(int alphaFlag, Map<Integer,Integer> bytesMap) {
        super(alphaFlag);
        this.bytesMap=bytesMap;
    }

    @Override
    void calculate() {
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
    }
    void result() {
        System.out.println(EquaProbabilityOfSigns.EQUAL_PROBABILITY_OF_SIGNS_MASSEGE);
        calculate();
        System.out.println(Test.HI_POW_2 + hiSquared + Test.HI_POW_2_1_MINUS_ALFA + hiSquared1MinusAlfa);
        if (this.hiSquared <= hiSquared1MinusAlfa) {
            System.out.println(Test.PASSED);
            System.out.println();
        } else {
            System.out.println(Test.NOT_PASSED);
            System.out.println(Test.SEPARATOR);
        }

    }
}

