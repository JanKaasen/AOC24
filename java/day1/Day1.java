import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Day1 {

	public static void main(String[] args) {
		ArrayList<String> data = getInput("../input.txt");
		ArrayList<String> l = new ArrayList<>();
		ArrayList<String> r = new ArrayList<>();
		ArrayList<Integer> rightInt = new ArrayList<>();
		ArrayList<Integer> leftInt = new ArrayList<>();
        
		separateLists(data, l, r);
		leftInt = convertToInt(l);
		rightInt = convertToInt(r);
		leftInt.sort(null);
		rightInt.sort(null);

		int similarities = getSimilarities(leftInt, rightInt);
		int result = getFinalResult(leftInt, rightInt);

		System.out.println(result);
		System.out.println(similarities);
	}

	static ArrayList<String> getInput(String filePath) {
		ArrayList<String> data = new ArrayList<>();

		try {
			File inputObject = new File(filePath);
			Scanner myReader = new Scanner(inputObject);
			while (myReader.hasNextLine()) {
				data.add(myReader.nextLine());
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();

		}

		return data;
	}

	static void separateLists(ArrayList<String> data, ArrayList<String> L, ArrayList<String> R) {
		for (String line : data) {
			String[] linePart = line.split("   ");
			L.add(linePart[0]);
			R.add(linePart[1]);
		}
	}

 /**
  * Converts arraylist elements to int
  *
  * @param arrayList
  * @return arrayList
  */
	static ArrayList<Integer> convertToInt(ArrayList<String> arrayList) {
		ArrayList<Integer> convertedList = new ArrayList<>();
		for (String line : arrayList) {
			convertedList.add(Integer.parseInt(line));
		}
		return convertedList;
	}

	static int getFinalResult(ArrayList<Integer> L, ArrayList<Integer> R) {
		int result = 0;

		for (int i = 0; i < L.size(); i++) {
			result += Math.abs(L.get(i) - R.get(i));
		}

		return result;
	}

	static int getSimilarities(ArrayList<Integer> L, ArrayList<Integer> R) {
		int similarities = 0;
		for (int number : L) {
			similarities += number * Collections.frequency(R, number);
		}

		return similarities;
	}

}
