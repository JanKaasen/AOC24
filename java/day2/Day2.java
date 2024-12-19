import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Day2 {
	public static void main(String[] args) {
		ArrayList<String> data = getInput("../input.txt");

	}

	static ArrayList<String> getInput(String filePath) {
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

}
