package lab1;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class Result {
	private String testName;
	private String generatorName;
	private boolean result;
	private double alpha;
	private double hiSquared;
	private double hiSquaredMinusAlpha;



	Result(String testName, Generator gen, Test test, boolean result, double hiSquared, double hiSquaredMinusAlpha) {
		this.testName=testName;
		this.generatorName = gen.getGeneratorName();
		this.alpha = test.getAlpha();
		this.result = result;
		this.hiSquared=hiSquared;
		this.hiSquaredMinusAlpha= hiSquaredMinusAlpha;

	}

	public double getHiSquared() {
		return hiSquared;
	}

	public double getHiSquaredMinusAlpha() {
		return hiSquaredMinusAlpha;
	}

	public double getAlpha() {
		return alpha;
	}

	public String getGeneratorName() {
		return generatorName;
	}

	public String getTestName() {
		return testName;
	}
	boolean getResult() {
		return result;
	}

	@Override
	public String toString()
	{
		return getGeneratorName() + ";"+ getResult() + ";" + Math.round(getHiSquared()) + ";" + Math.round(getHiSquaredMinusAlpha())+  ";\n";
	}

}
