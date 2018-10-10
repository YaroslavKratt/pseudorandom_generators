package lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Generator> generators = new ArrayList<Generator>();
		ArrayList<ArrayList<Integer>> bytes = new ArrayList<>();
		ArrayList<LinkedHashMap<Integer, Integer>> map = new ArrayList<>();
		ArrayList<Result> resultUT = new ArrayList<Result>();
		ArrayList<Result> resultIT = new ArrayList<Result>();
		ArrayList<Result> resultEPT = new ArrayList<Result>();


		Scanner sc = new Scanner(System.in);

		generators.add(new StandartGenerator());
		generators.add(new LehmerLow());
		generators.add(new LehmerHigh());
		generators.add(new Geffe(new Random().nextInt(), new Random().nextInt(), new Random().nextInt()));
		generators.add(new L20(new Random().nextInt()));
		generators.add(new L89());
		generators.add(new Librarian("/home/raccoon/IdeaProjects/pseudorandom_generators/src/lab1/harry.txt"));
		generators.add(new BM()); //lab1/harry.txt
		generators.add(new BMbyte());
		generators.add(new BBS());
		generators.add(new BBSbyte());
		generators.add(new Volfram(new Random().nextInt()));

		System.out.println(Test.INPUT_MASSEGE);
		int next = sc.nextInt();

		while (true) {
			if ((next != 1) && (next != 2) && (next != 3)) {
				System.out.println(Test.WRONG_INPUT_MASSEGE);
				next = sc.nextInt();
			} else {
				break;
			}
		}
		for (Generator gen : generators) {
			ArrayList<Integer> temp = gen.generate();

			if (gen.getType().equals("bit")) {
				ArrayList<Integer> bytesReDone = gen.binToByte(temp);
				EquaProbabilityOfSigns eq = new EquaProbabilityOfSigns(next, gen.arrListToMap(bytesReDone));
				IndependentTest ind = new IndependentTest(bytesReDone, next);
				UniformityTest ut = new UniformityTest(bytesReDone, next);
				bytes.add(gen.binToByte(temp));
				resultUT.add(new Result(eq.getTestName(), gen, eq, eq.result(), eq.hiSquared, eq.hiSquared1MinusAlfa));
				resultEPT.add(new Result(ind.getTestName(), gen, ind, ind.result(), ind.hiSquared, ind.hiSquared1MinusAlfa));
				resultIT.add(new Result(ut.getTestName(), gen, ut, ut.result(), ut.hiSquared, ut.hiSquared1MinusAlfa));

			}
			if (gen.getType().equals("byte")) {
				EquaProbabilityOfSigns eq = new EquaProbabilityOfSigns(next, gen.arrListToMap(temp));
				IndependentTest ind = new IndependentTest(temp, next);
				UniformityTest ut = new UniformityTest(temp, next);

				bytes.add(temp);
				resultUT.add(new Result(eq.getTestName(), gen, eq, eq.result(), eq.hiSquared, eq.hiSquared1MinusAlfa));
				resultEPT.add(new Result(ind.getTestName(), gen, ind, ind.result(), ind.hiSquared, ind.hiSquared1MinusAlfa));
				resultIT.add(new Result(ut.getTestName(), gen, ut, ut.result(), ut.hiSquared, ut.hiSquared1MinusAlfa));
			}
			map.add(gen.arrListToMap(temp));

		}
		Main.print(resultEPT);
		Main.print(resultIT);
		Main.print(resultUT);
	}

	static void print(ArrayList<Result> result) throws IOException {
		String fileName = result.get(0).getTestName() + "_" + ".csv";
		FileWriter fw = new FileWriter(fileName, true);
		fw.write("Alpha=" + result.get(0).getAlpha() + ";\n");
		fw.write("Generator Name;Result;hiSuares;hiSquaredMinusAlpha;\n");
		for (Result e : result) {
			fw.write(e.toString());

		}
		fw.close();
	}
}
