package lab1;

import javax.jws.soap.SOAPBinding;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigInteger;
import java.util.ArrayList;

public class BBSbyte extends BBS {
    BBSbyte(){
       this.type="byte";
    }
    @Override
    int getNewBit() {
        r=r.pow(2).mod(n);
        return r.mod(new BigInteger("256")).intValue();
    }
    @Override
    ArrayList<Integer> generate()
    {
        System.out.println("BBSbyte");
        for (int i = 0; i <Nbyte ; i++) {
            int temp=getNewBit();
            keeper.add(temp);
            addElement(temp,keeperMap);
        }
        return keeper;
    }
}
