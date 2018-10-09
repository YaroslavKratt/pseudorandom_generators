package lab1;

import java.util.ArrayList;

public class LehmerLow extends Lehmer {
    LehmerLow()
    {
        this.type="byte";
        this.generatorName="LehmerLow";


    }
    @Override
    ArrayList<Integer> generate()
    {
        System.out.println("LehmerLow");
        for(int i=0; i<Nbyte; i++)
        {
            x=(a*x+c)%m;
            int xByte=x&255;
          //  System.out.println(Integer.toBinaryString(xByte)+" ");
            keeper.add(xByte);
            addElement(xByte,keeperMap);
        }

   return keeper; }
}
