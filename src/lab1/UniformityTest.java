package lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class UniformityTest  extends Test {
	public static final  String UNIFORMITY_TEST_MESSAGE = "UniformityTest";
	public static final int R = 256;
	public static final int M = Generator.Nbyte / R;
	public static final int N = M * R;
	private int []bytes;


	UniformityTest(ArrayList<Integer> bytesList,int alphaFlag) {
		super(alphaFlag);
		l = 255*(R -1);
		this.testName=UniformityTest.UNIFORMITY_TEST_MESSAGE;
		hiSquared1MinusAlfa = Math.sqrt(2 * l) * z + l;
		bytes = new int[N];
		for (int i = 0; i < N; i++) {
			bytes[i] = bytesList.get(i);
		}

	}

	@Override
	void calculate() {
		hiSquared=0;
		int vIJ[][] = new int[R][256];
		int vI[] = new int[R];
		Arrays.fill(vI,0);
		for (int j = 0; j< R; j++) {
			for (int i=M*j; i<M *j + M; i++) {
				vIJ[j][bytes[i]]++;
			}
		}
		for (int j = 0; j < R; j++) {
			for (int i = 0; i < vIJ.length; i++) {
				vI[j] += vIJ[i][j];
			}
			
		}
		for (int i = 0; i < 256 ; i++) {
			for (int j = 0; j < R; j++) {
				if(vI[j] != 0) {
					hiSquared += (Math.pow(vIJ[j][i], 2)) / (vI[j] * M);
				}
			}
		}
		hiSquared = N * (hiSquared - 1);

	}

	boolean result() {
		System.out.println(UniformityTest.UNIFORMITY_TEST_MESSAGE);
		calculate();
		System.out.println(Test.HI_POW_2 + hiSquared + Test.HI_POW_2_1_MINUS_ALFA + hiSquared1MinusAlfa);
		if (this.hiSquared <= hiSquared1MinusAlfa) {
			System.out.println(Test.PASSED);
			System.out.println();
			return true;
		} else {
			System.out.println(Test.NOT_PASSED);
			System.out.println(Test.SEPARATOR);
			return  false;
		}

	}
}
