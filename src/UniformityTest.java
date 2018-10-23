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
		System.out.println(N);
		for (int i = 0; i < N-1; i++) {
			bytes[i] = bytesList.get(i);
		}

	}

	@Override
	void calculate() {
		hiSquared = 0;
		int vIJ[][] = new int[R][256];
		int vI[] = new int[R];
		Arrays.fill(vI, 0);
		int[][] frequencies = new int[R][256];
		for (int i = 0; i < N; i++)
			frequencies[bytes[i]][i / M]++;
		int[] a = new int[256];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < 256; j++)
				a[i] += frequencies[i][j];
		}
		for (int i = 0; i < R; i++)
			for (int j = 0; j < 256; j++)
				if (a[i] != 0)
					hiSquared += (Math.pow(frequencies[i][j], 2) / a[i]);
				else
					continue;
		hiSquared = N * (hiSquared/M - 1);
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
