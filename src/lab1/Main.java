package lab1;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws UnsupportedEncodingException {
       ArrayList<Generator> generators = new ArrayList<Generator>();
       ArrayList< ArrayList<Integer> >bytes= new ArrayList<>();
       ArrayList<LinkedHashMap<Integer,Integer>> map = new ArrayList<>();
       Scanner sc = new Scanner(System.in);

        generators.add(new StandartGenerator());
        generators.add(new  LehmerLow());
        generators.add(new LehmerHigh());
        generators.add(new  Geffe(new Random().nextInt(),new Random().nextInt(),new Random().nextInt()));
        generators.add(new L20(new Random().nextInt()));
        generators.add(new  L89());
        generators.add(new  Librarian("/home/raccoon/IdeaProjects/pseudorandom_generators/src/lab1/harry.txt"));
        generators.add(new   BM()); //lab1/harry.txt
        generators.add(new  BMbyte());
        generators.add(new   BBS());
        generators.add(new BBSbyte());
        generators.add(new Volfram(new Random().nextInt()));

        System.out.println(Test.INPUT_MASSEGE);
        int next = sc.nextInt();

        while (true){
            if((next != 1) && (next != 2) && (next !=3)){
                System.out.println(Test.WRONG_INPUT_MASSEGE);
                next =sc.nextInt();
            }
            else {
                break;
            }
        }
        for (Generator gen:generators ) {
           ArrayList<Integer> temp = gen.generate();

           if(gen.getType().equals("bit")) {
               ArrayList<Integer> bytesReDone = gen.binToByte(temp);
               EquaProbabilityOfSigns eq = new EquaProbabilityOfSigns(next,gen.arrListToMap(bytesReDone));
               IndependentTest ind = new IndependentTest(bytesReDone,next);
               UniformityTest ut = new UniformityTest(bytesReDone,next);

               eq.result();
               ind.result();
               ut.result();
               bytes.add(gen.binToByte(temp));
           }
           if(gen.getType().equals("byte")) {
               EquaProbabilityOfSigns eq = new EquaProbabilityOfSigns(next,gen.arrListToMap(temp));
               IndependentTest ind = new IndependentTest(temp,next);
               UniformityTest ut = new UniformityTest(temp,next);

               eq.result();
               ind.result();
               ut.result();
               bytes.add(temp);
           }
            map.add(gen.arrListToMap(temp));
        }
    }
}
