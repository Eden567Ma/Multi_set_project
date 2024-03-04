package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pobj.util.Chrono;

public class WordCount {
	static void wordcount(MultiSet<String> ms) throws IOException {
		
		String file = "Data/WarAndPeace.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine())!=null) {
		for (String word : line.split("\\P{L}+")) {
		if (word.equals("")) continue; // ignore les mots vides
		// TODO: traitement à faire pour le mot word
		ms.add(word);		
		}
		}
		List<String> l = ms.elements();
		for(int i=0; i<=10; i++) {
			System.out.println(l.get(i));
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		WordCount wc = new WordCount();
		Chrono chrono = new Chrono();
		MultiSet<String> mts =new HashMultiSet<String>();
		wc.wordcount(mts);
		System.out.println(mts.toString());
		//wc.wordcount(new NaiveMultiSet<String>());
		chrono.stop();
	}

}
