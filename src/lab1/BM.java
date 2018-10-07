package lab1;

import java.math.BigInteger;
import java.util.ArrayList;

public class BM extends Generator
{

   private static BigInteger  a=new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
   private static BigInteger  p=new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3",16);
   private BigInteger T=new BigInteger("111111111");
   private static final BigInteger CONST=(p.subtract(new BigInteger("1"))).divide(new BigInteger("2"));

   BM()
   {
       this.type="bit";
   }
   int getNewBit()
   {
        if(T.compareTo(CONST)==-1)
        {
            T= a.modPow(T,p);
            return 1;
        }
        else{
            T= a.modPow(T,p);
            return 0;
        }
   }
   @Override
   ArrayList<Integer> generate()
   {
       System.out.println("BM");
       for (int i = 0; i < Nbit; i++) {
           int temp= getNewBit();
           keeper.add(temp);
           addElement(temp,keeperMap);
          // System.out.print(temp);
       }
       return keeper;
   }

}
