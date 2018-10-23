import java.math.BigInteger;
import java.util.ArrayList;

public class BBS extends Generator {
    private static BigInteger p=new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    private static BigInteger  q=new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F",16);
    protected static BigInteger n =p.multiply(q);
    protected static BigInteger r =new BigInteger("5");
    BBS()
    {
        this.type="bit";
        this.generatorName="BBS";


    }
    int getNewBit()
    {
        r=r.pow(2).mod(n);
        return r.mod(new BigInteger("2")).intValue();
    }
    @Override
    ArrayList<Integer> generate()
    {
        System.out.println("BBS");
        for (int i = 0; i <Nbit ; i++) {
            int temp=getNewBit();
            keeper.add(temp);
            addElement(temp,keeperMap);
           // System.out.print(temp);
        }
        return keeper;
    }

}
