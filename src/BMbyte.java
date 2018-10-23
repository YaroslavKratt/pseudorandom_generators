import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class BMbyte extends Generator{
    private static BigInteger a=new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    private static BigInteger  p=new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3",16);
    private BigInteger T=new BigInteger(String.valueOf(new Random().nextInt()));
    private static final BigInteger CONST=(p.subtract(new BigInteger("1"))).divide(new BigInteger("256"));

    BMbyte()
    {
       this.type="byte";
        this.generatorName="BMbyte";

    }
    int getNewBit()
    {
        T= a.modPow(T,p);
        for (int i = 1; i < 256; i++)
        {
            if((T.compareTo(CONST.multiply(new BigInteger(String.valueOf(i))))==1)&&(T.compareTo(CONST.multiply(new BigInteger(Integer.toString(i+1))))==-1))
            {

                return i;
            }
       }
        return 0;
    }
    @Override
    ArrayList<Integer> generate()
    {
        System.out.println("BMbyte");
        for (int i = 0; i < Nbyte; i++) {
            int temp= getNewBit();
            keeper.add(temp);
            addElement(temp,keeperMap);
            //System.out.print(temp+" ");
        }
        return keeper;
    }

}

