import java.util.ArrayList;

public class Geffe extends Generator {
    int state1;
    int state2;
    int state3;

    int exit;
    Geffe(int start1, int start2,int start3)
    {  this.state1=start1;
        this.state2=start2;
        this.state3=start3;
        type="bit";
        this.generatorName="Geffe";


    }
    int L11(){
        this.state1=(((state1>>10)&1)^((state1>>8)&1))|(state1<<1);
        return (state1>>11)&1;
    }

    int L9(){
        this.state2 = (((state2>>8)&1)^((state2>>7)&1)^((state2>>5)&1)^((state2>>4)&1))|(state2<<1);
        return (state2>>9)&1;
    }

    int L10(){
        this.state3 = (((state3>>9)&1)^((state3>>6)&1))|(state3<<1);
        return (state3>>10)&1;
    }
    int geffe(){
        int x=L11();
        int y=L9();
        int s=L10();
        return s&x^(1^s)&y;
    }
@Override
    ArrayList<Integer> generate()
    {
        System.out.println("Geffe");
        for(int i=0; i<Nbit; i++){
               int temp=geffe();

                keeper.add(temp);
                addElement(temp,keeperMap);
                //System.out.println(temp+" ");
            }
            return keeper;

    }


}