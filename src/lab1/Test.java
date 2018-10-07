package lab1;

import java.util.Scanner;

public  abstract class Test {
    double hiSquared = 0;
    double z;
    private double z09 = 1.28155;
    private double z095 = 1.64485;
    private double z099 = 2.32635;//0.9=1.28155, 0.95=1.64485, 0.99=2.32635
    double l = 255;
    double hiSquared1MinusAlfa;
    public static final String HI_POW_2 = " hi squared= ";
    public static final String HI_POW_2_1_MINUS_ALFA = " hi squared 1-alfa= ";
    public static final String PASSED = " PASSED ";
    public static final String NOT_PASSED = " FUCKED UP ";
    public static final String SEPARATOR = "------------------------------------------------------------keks------------------------------------------------------------------------";
    public static final String INPUT_MASSEGE = " Please choose alfa:  \n 1) alfa=0.9 \n 2) alfa=0.95 \n 3) alfa= 0.99";
    public static final String WRONG_INPUT_MASSEGE = " Please enter correct input";

    Test(int flagOfAlfa) {

        switch (flagOfAlfa) {
            case 1:
                z = z09;
                break;
            case 2:
                z = z095;
                break;
            case 3:
                z = z099;
                break;

        }
    }

    abstract void calculate();

    void result() {
        System.out.println(IndependentTest.INDEPENDENT_TEST_MESSAGE);
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
