package vishal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\Documents\\result.txt");
		String wordToBeSearched = "vishal";
		int count = 0;
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNext()) {
				String word = sc.next();
				System.out.println(word);
				if(word.equals(wordToBeSearched)) count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("count "+count);
	}

}
