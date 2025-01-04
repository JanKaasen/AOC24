import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day2 {
	public static void main(String[] args) {
		ArrayList<String> data = getInput("./input.txt");
		List<ArrayList<Integer>> intArrayList = converttoIntegers(data);
		int safeCounter = 0;
		for (ArrayList<Integer> line : intArrayList) {
			if ((isStrictlyIncreasing(line) || isStrictlyDecreasing(line)) && diffNotMoreThanThree(line)) {
				safeCounter++;
			}
		}
		System.out.println(safeCounter);
	}

	public static ArrayList<String> getInput(String filePath) {
		ArrayList<String> inputArrayList = new ArrayList<>();
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);
			while (fileReader.hasNextLine()) {
				inputArrayList.add(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return inputArrayList;
	}

	public static List<ArrayList<Integer>> converttoIntegers(ArrayList<String> arrayList) {
		List<ArrayList<Integer>> resultList = new ArrayList<>();

		for (String line : arrayList) {
			ArrayList<Integer> lineList = new ArrayList<>();
			String[] ln = line.split(" ");
			for (int i = 0; i < ln.length; i++) {
				lineList.add(Integer.parseInt(ln[i]));
			}
			resultList.add(lineList);
		}

		return resultList;
	}

	public static boolean isStrictlyIncreasing(ArrayList<Integer> integerArrayList) {
		for (int i = 0; i < integerArrayList.size() - 1; i++) {
			if (integerArrayList.get(i) >= integerArrayList.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isStrictlyDecreasing(ArrayList<Integer> integerArrayList) {
		for (int i = 0; i < integerArrayList.size() - 1; i++) {
			if (integerArrayList.get(i) <= integerArrayList.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean diffNotMoreThanThree(ArrayList<Integer> integerArrayList) {
		for (int i = 0; i < integerArrayList.size() - 1; i++) {
			if (Math.abs(integerArrayList.get(i) - integerArrayList.get(i + 1)) > 3) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSafe(ArrayList<Integer> integerArrayList) {
		if ((isStrictlyDecreasing(integerArrayList) || isStrictlyIncreasing(integerArrayList))
				&& diffNotMoreThanThree(integerArrayList)) {
			return true;
		}
		return false;
	}
}
