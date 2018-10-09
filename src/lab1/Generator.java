package lab1;
import java.io.UnsupportedEncodingException;
import java.util.*;

public abstract class Generator {
    protected  String type;
    protected static int Nbit=3000000;
    public static int Nbyte=375000;//количество итераций
    //количество итераций
     protected String generatorName;
  public Map<Integer,Integer> keeperMap = new LinkedHashMap<>() ;
   protected ArrayList<Integer>keeper = new ArrayList<Integer>();

   public  String getType()
   {
       return type;
   }

    public String getGeneratorName() {
        return generatorName;
    }

    abstract ArrayList<Integer> generate() throws UnsupportedEncodingException;

    protected ArrayList<Integer> binToByte(ArrayList<Integer> binArr)
   {
       String temp="";
       int j=1;
       ArrayList<Integer> byteArr=new ArrayList<Integer>();
       for (Integer bit:binArr)
       {
           temp=temp+Integer.toString(bit);
           if(j%8==0)
           {    int n=Integer.parseInt(temp,2);
               //System.out.println(N);
               byteArr.add(n);
               j=0;
               temp="";
           }
           j++;

       }
       if(temp!="")
       byteArr.add(Integer.parseInt(temp,2)); //неполный байт не пропадает
       return byteArr;
   }
   LinkedHashMap<Integer, Integer> arrListToMap(ArrayList<Integer> arr)
   {   /*  if(getType()=="bit")
            arr=binToByte(arr);*/

       LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
       for (Integer e: arr) {
           addElement(e,map);
       }

       return map;

   };
    static  Map<Integer, Integer> addElement(Integer key,Map<Integer, Integer> m)
   {
       if(m.get(key)==null)
           m.put(key,1);
       else
       {
           m.put(key, m.get(key)+1);
       }
       return m;
       
   }
    static int count(Map<Integer,Integer> keeperMap1) //общее кол-во байтов
   {
       int n=0;
       for (Map.Entry<Integer, Integer> entry :keeperMap1.entrySet())
       {
           n= n+entry.getValue();
       }
       return  n;
   }

}
