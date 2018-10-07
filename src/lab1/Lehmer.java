package lab1;

import java.util.ArrayList;

public  abstract class  Lehmer extends Generator{
    int m=Integer.MAX_VALUE;
    int a=(int)(Math.pow(2,16)+1);
    int c=119;
    int x=1;
    abstract ArrayList<Integer> generate();
}
