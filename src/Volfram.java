import java.util.ArrayList;

public class Volfram extends Generator {
    private int state;
    Volfram(int state) {
        this.state=state;
        this.type="bit";
        this.generatorName="Volfram";

    }
    int getNewBit() {
        int x=state&1;
        state=leftShift(state)^(state|rightShift(state));
       // System.out.println(x);
        return x;
    }
    int rightShift(int n) {
 return (n >>> 1) | (n << (Integer.SIZE - 1));    }
    int leftShift(int n) {
        return (n << 1) | (n >>> (Integer.SIZE - 1));
    }
    @Override
    ArrayList<Integer> generate() {
        System.out.println("Volfram");
        for (int i = 0; i <Nbit ; i++)
        {
            int temp=getNewBit();
           // System.out.println(temp);
            keeper.add(temp);
            addElement(temp,keeperMap);
        //    System.out.println(temp+" ");
        }
        return keeper;
    }
}

