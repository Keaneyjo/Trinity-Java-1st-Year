package toDocument;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class toDocumentMain {
	
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner (System.in);
		FileWriter fileWriter;
		try
		{
				fileWriter = new FileWriter("toDocText.txt");
				BufferedWriter bufferedWriter = new BufferedWriter (fileWriter);
				toDocument(bufferedWriter, inputScanner);
				fileWriter.close();
			} catch (IOException e) {e.printStackTrace();
		}
	}

	public static void toDocument (BufferedWriter bufferedWriter, Scanner inputScanner)
	{

		String wordLine;
		while (("toDocText.txt") != null) {
			System.out.print("Enter a word");
			bufferedReader.readLine()
		}
  

		
	}
}

