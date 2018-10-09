package lab1;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Librarian extends Generator{
    private String str="";
    private byte []arr;
    String fileName;
    ArrayList<String>bytes=new ArrayList<String>();
    Librarian(String fileName)
    {
        this.fileName=fileName;
        this.type="byte";
        this.generatorName="Librarian";




    }
    @Override
    ArrayList<Integer> generate() throws UnsupportedEncodingException {
        System.out.println("Librarian");
        try
        {
            FileInputStream bf=new FileInputStream(fileName);
            int line;
            int j=bf.available();
            while(j!=0)
            {
              //  System.out.println(str+" ");
                int k=bf.read();
                //System.out.println(Integer.toBinaryString(k));
                keeper.add(k);
                addElement(k,keeperMap);
                j--;
            }
            System.out.println(str);


        }
        catch (IOException e)
        {
            System.out.println("No such file, try again");
        }


            //System.out.print(Integer.toBinaryString(new Integer(e))+" ");
        return keeper;

        }
    }

