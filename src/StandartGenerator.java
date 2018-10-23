import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Random;

public class StandartGenerator extends Generator{
    StandartGenerator(){
        this.generatorName="StandartGenerator";

    }
   private Random rand=new Random();
    @Override
    ArrayList<Integer> generate()
    {
        this.type="bit";
        System.out.println("StandartGenerator");
        for (long i=0; i<Nbit; i++)
        {
            int n= rand.nextInt(2);
            keeper.add(n);
            addElement(n,keeperMap);
           // System.out.print(N);
        }
        return keeper;
    }
   @Override public String toString(){

   return "done";}
}
