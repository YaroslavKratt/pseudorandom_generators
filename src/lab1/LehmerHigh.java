package lab1;

import java.util.ArrayList;

public class LehmerHigh extends Lehmer {
    LehmerHigh(){
        this.type="byte";
        this.generatorName="LehmerHigh";

    }
    @Override
     ArrayList<Integer> generate()
    {
        System.out.println("LehmerHigh");
        for (int i=0;i<Nbyte; i++)
        {
            x=(a*x+c)%m;

            int xByte=(x>>24)&255;
          //  System.out.println(Integer.toBinaryString(xByte)+" ");
            keeper.add(xByte);
            addElement(xByte,keeperMap);
        }
      return keeper;
    }
}
