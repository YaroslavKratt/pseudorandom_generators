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
        generators.add(new  Geffe(6536,876867587,8767867));
        generators.add(new L20(34252345));
        generators.add(new  L89());
        generators.add(new  Librarian("D:\\Study\\крипта\\4 курс\\CRPT_LAB1\\src\\lab1\\harry.txt"));
        generators.add(new   BM());
        generators.add(new  BMbyte());
        generators.add(new   BBS());
        generators.add(new BBSbyte());
        generators.add(new Volfram(9849));

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
              // ut.result();
               bytes.add(gen.binToByte(temp));
           }
           if(gen.getType().equals("byte")) {
               EquaProbabilityOfSigns eq = new EquaProbabilityOfSigns(next,gen.arrListToMap(temp));
               IndependentTest ind = new IndependentTest(temp,next);
               UniformityTest ut = new UniformityTest(temp,next);

               eq.result();
               ind.result();
              // ut.result();
               bytes.add(temp);
           }
            map.add(gen.arrListToMap(temp));
        }






       // StandartGenerator stGen=new StandartGenerator();//good
        //stGen.generate();

        //Lehmer lmrLow=new LehmerLow();
        //EquaProbabilityOfSigns eq =new EquaProbabilityOfSigns();//good
       /* ArrayList<Integer> temp=lmrLow.generate();
        eq.result(lmrLow.arrListToMap(temp));*/
        //lmrLow.generate();
       // Lehmer lmrHigh=new LehmerHigh();
       // ArrayList<Integer> temp=lmrHigh.generate();//good
       // eq.result(lmrHigh.arrListToMap(temp));
       //lmrHigh.generate();
       /* Geffe gef=new Geffe(498498849,1665444684,654684686);//bad
        ArrayList<Integer> temp=gef.generate();
        temp=gef.binToByte(temp);
        eq.result(gef.arrListToMap(temp));

        //gef.generate();
        L20 l20=new L20(34252345);//good
       /* ArrayList<Integer> temp=l20.generate();
        temp=l20.binToByte(temp);
        eq.result(l20.arrListToMap(temp));*/
        /*L89 l89=new L89();//good
        /* ArrayList<Integer> temp=l89.generate();
        temp=l89.binToByte(temp);
        eq.result(l89.arrListToMap(temp));*/
        //l89.generate();
        //Librarian lbr= new Librarian("D:\\Study\\крипта\\4 курс\\CRPT_LAB1\\src\\lab1\\harry.txt");//BAD
         //ArrayList<Integer> temp=lbr.generate();
      //  eq.result(lbr.arrListToMap(temp));
      //  BM bm=new BM();//good

       /* ArrayList<Integer> temp=bm.generate();
        temp=bm.binToByte(temp);
        eq.result(bm.arrListToMap(temp));*/
        //BMbyte bMbyte=new BMbyte();//good
        //ArrayList<Integer> temp=bMbyte.generate();
        //temp=bMbyte.binToByte(temp);
       // eq.result(bMbyte.arrListToMap(temp));
        //bMbyte.generate();
       // BBS bbs=new BBS();//good
        /*ArrayList<Integer> temp=bbs.generate();
        temp=bbs.binToByte(temp);
         eq.result(bbs.arrListToMap(temp));*/
       // BBSbyte bbSbyte=new BBSbyte();//good
        /*ArrayList<Integer> temp=bbSbyte.generate();
        eq.result(bbSbyte.arrListToMap(temp));*/
       // Volfram vol=new Volfram(22222298); ///хуй пойми что не так
       /*  ArrayList<Integer> temp=vol.generate();
        temp=vol.binToByte(temp);
        eq.result(vol.arrListToMap(temp));*/



    }
}
