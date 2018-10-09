package lab1;

import java.util.ArrayList;
import java.util.Arrays;


public class IndependentTest  extends Test{
    private int []bytes;
    public static final  String INDEPENDENT_TEST_MESSAGE="IndependentTest";
    IndependentTest(ArrayList<Integer>  bytesList, int flagOfAlfa) {
        super(flagOfAlfa);
        l=Math.pow(l,2);
        hiSquared1MinusAlfa = Math.sqrt(2 * l) * z + l;
        bytes = new int[bytesList.size()];
        this.testName = IndependentTest.INDEPENDENT_TEST_MESSAGE;

        for (int i = 0; i < bytesList.size(); i++) {
            bytes[i] = bytesList.get(i);
        }
    }
@Override
     void calculate() {
       int [][]frequency = new int[256][256];
       int []a=new int [256];
       int []v= new int [256];
       double res = 0;
       Arrays.fill(a, 0);
       Arrays.fill(v, 0);
       hiSquared =0;

       for (int i = 0; i < 256; i++) {
           for (int j = 0; j < 256; j++) {
               frequency[i][j] = 0;
           }
       }
        for (int i = 1; i <( bytes.length/2); i++) {
            ++frequency[bytes[2*i-1]][ bytes[2*i]];
            }
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                a[i] += frequency[i][j];
                v[i] += frequency[j][i];
            }
        }
       for (int i = 0; i <256; i++) {
            for (int j = 0; j <256 ; j++) {
                if(frequency[i][j] == 0 ) {
                    continue;
                }
                res +=  ( Math.pow(frequency[i][j], 2) / (a[i] * v[j]));
                }
            }
        hiSquared = (bytes.length / 2) * (res -1);
    }
    boolean result() {
        System.out.println(IndependentTest.INDEPENDENT_TEST_MESSAGE);
        calculate();
        System.out.println(Test.HI_POW_2 + hiSquared + Test.HI_POW_2_1_MINUS_ALFA + hiSquared1MinusAlfa);
        if (this.hiSquared <= hiSquared1MinusAlfa) {
            System.out.println(Test.PASSED);
	        System.out.println(Test.SEPARATOR);
	        System.out.println();
	        return true;
        } else {
            System.out.println(Test.NOT_PASSED);
            System.out.println(Test.SEPARATOR);
            return false;
        }

    }


}
