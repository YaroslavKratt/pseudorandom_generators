package lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class UniformityTest  extends Test {
	public static final  String UNIFORMITY_TEST_MESSAGE="UniformityTestlab1.Test";
	int r = 256;
	int m = Generator.Nbyte / r;
	int n = m * r;
	{

	}
	private int []bytes;


	UniformityTest(ArrayList<Integer> bytesList,int alphaFlag) {
		super(alphaFlag);
		l = 255*(r -1);
		hiSquared1MinusAlfa = Math.sqrt(2 * l) * z + l;
		bytes = new int[n];
		for (int i = 0; i < n; i++) {
			bytes[i] = bytesList.get(i);
		}

	}

	@Override
	void calculate() {

		int vIJ[][] = new int[r][256];
		int vI[] = new int[r];
		double res=0;
		Arrays.fill(vI,0);
		for (int j=0; j<r; j++) {
			for (int i=m*j; i<m *j + m; i++) {
				vIJ[j][bytes[i]]++;
			}
		}
		for (int j = 0; j < r; j++) {
			for (int i = 0; i < vIJ.length; i++) {
				//System.out.println(i+" "+j);
				vI[j] += vIJ[i][j];
			}
			
		}
		for (int i = 0; i < 256 ; i++) {
			for (int j = 0; j < r; j++) {
				if(vI[j] != 0) {
					res += (Math.pow(vIJ[j][i], 2)) / (vI[j] * m);
				}
			}
		}
		res = n * (res - 1);
		hiSquared=res;

	}

	void result() {
		System.out.println(UniformityTest.UNIFORMITY_TEST_MESSAGE);
		calculate();
		System.out.println(Test.HI_POW_2 + hiSquared + Test.HI_POW_2_1_MINUS_ALFA + hiSquared1MinusAlfa);
		if (this.hiSquared <= hiSquared1MinusAlfa) {
			System.out.println(Test.PASSED);
			System.out.println();
		} else {
			System.out.println(Test.NOT_PASSED);
			System.out.println(Test.SEPARATOR);
		}

	}
}
