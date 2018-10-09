package lab1;

import java.util.ArrayList;
import java.util.Random;

public class L89 extends Generator{
    int state[] = new int[3];//!!! для хранения 89 бит в 3 интах !!!

    L89() {
        this.type="bit";
        Random rand=new Random();
        this.generatorName="L89";

        for (int i = 0; i <3 ; i++)
        {
             state[i]=rand.nextInt();
            //System.out.print("state["+i+"]="+state[i]);
           // System.out.print(Integer.toBinaryString(state[i])+" ");
        }
       // System.out.println();
        print();

    }

    int[] shiftRight(int onBits) //переопределенный сдвиг для числа, которое хранится по частям
    {
        int carryBitNext=0;
        int carryBitPrev=0;
        int temp[]=new int[3];
        for (int i = 0; i <3 ; i++)
        {
            carryBitPrev=carryBitNext;
            carryBitNext=state[i]&1;
            temp[i]=(state[i]>>>onBits);
            if(i>0)
            temp[i]=temp[i]|(carryBitPrev<<31);
        }
        return temp;
    }
    int[] shiftLeft(int onBits) //переопределенный сдвиг влево для числа, которое хранится по частям
    {
        int carryBitNext=0;
        int temp[]=new int[3];
        int carryBitPrev=0;

        for (int i = 2; i >=0 ; i--)
        {
            carryBitPrev=carryBitNext;
            carryBitNext=(state[i]>>31)&1;
            temp[i]=(state[i]<<onBits);
            if(i<2)
                temp[i]=temp[i]|carryBitPrev;
        }
        return temp;
    }
    int getNewBit() ///говнокод, переписать, если не впадло
    {
            int bitAfterShift88=(this.shiftRight(88)[2])&1;
            int bitAfterShift37=(this.shiftRight(37)[2]&1);
            int[] stateAfterLeftShift1=this.shiftLeft(1);
           stateAfterLeftShift1[2]=stateAfterLeftShift1[2]|(bitAfterShift37^bitAfterShift88);
           state=stateAfterLeftShift1;
           return this.shiftRight(89)[2]&1;
    }
    @Override
    ArrayList<Integer> generate()
    {
        System.out.println("L89");
        for (int i = 0; i <Nbit ; i++)
        {
            int temp=getNewBit();
            keeper.add(temp);
            addElement(temp,keeperMap);
           // System.out.print(temp);
        }
        return keeper;
    }
    void print()
    {
        for (int i = 0; i <3 ; i++) {
            System.out.print(Integer.toBinaryString(state[i])+" ");
        }
        System.out.println();
    }
}