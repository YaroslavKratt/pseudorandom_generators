import java.util.ArrayList;

public class L20 extends Generator{
    private int state;
    L20(int state)
    {
        this.state=state;
       this.type="bit";
        this.generatorName="L20";


    }
    int getNewBit()
    {
        this.state=(((state>>19)&1)^((state>>8)&1)^((state>>4)&1)^((state>>2)&1))|(state<<1);
        return (state>>20)&1;
    }
    @Override
    ArrayList<Integer> generate(){
        System.out.println("L20");
        for (int i = 0; i <Nbit ; i++)
            {
                int temp=getNewBit();
                keeper.add(temp);
                addElement(temp,keeperMap);
                //System.out.println(temp+" ");
            }
            return keeper;
    }
}

