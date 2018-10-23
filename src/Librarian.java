import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;

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
    ArrayList<Integer> generate() throws IOException {
        System.out.println("Librarian");
        String txt = "";
        try
        {
            FileInputStream fis=new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "ASCII"));
            String line;
            while((line = br.readLine())!= null)
            { txt=txt+line;
            }
            char[] charArr= txt.toCharArray();
            int size =0;
            for (char b:charArr) {
                if(b>256)
                    continue;
                keeper.add((int) b);
                size++;

            }
            this.Nbyte = size;
        }
        catch (IOException e)
        {
            System.out.println("No such file, try again");
        }


            //System.out.print(Integer.toBinaryString(new Integer(e))+" ");
        return keeper;

        }
    }

