package lab1;

import java.util.ArrayList;

public class UniformityTest  extends Test {
	public static final  String UNIFORMITY_TEST_MESSAGE="UniformityTestlab1.Test";
	int r = 512;
	int m = Generator.Nbyte / r;
	int n = m * r;
	private int []bytes;


	UniformityTest(ArrayList<Integer> bytesList,int alphaFlag) {
		super(alphaFlag);
		this.l = 255*(r -1);
		hiSquared1MinusAlfa = Math.sqrt(2 * l) * z + l;
		bytes = new int[bytesList.size()];
		for (int i = 0; i < bytesList.size(); i++) {
			bytes[i] = bytesList.get(i);
		}

	}

	@Override
	void calculate() {
		int[][] frequencies = new int[256][r];
		for (int i = 0; i < 256; i++)
			for (int j = 0; j < r; j++)
				frequencies[i][j] = 0;
		for (int i = 1; i < n; i++)
			frequencies[bytes[i]][i / m]++;
		int[] a = new int[256];
		for (int i = 0; i < 256; i++) {
			a[i] = 0;
			for (int j = 0; j < 512; j++)
				a[i] += frequencies[i][j];
		}
		hiSquared = 0.0;
		for (int i = 0; i < 256; i++)
			for (int j = 0; j < 512; j++)
				if (a[i] != 0)
					hiSquared += (Math.pow(frequencies[i][j], 2) / a[i]);
				else
					hiSquared += Math.pow(frequencies[i][j], 2);
		hiSquared = n * ((hiSquared / this.r) - 1);


	}

	void result() {
		System.out.println(Test.SEPARATOR);
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
