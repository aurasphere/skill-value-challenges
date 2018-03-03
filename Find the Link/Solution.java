package co.aurasphere.skillvalue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

		List<String> words = new LinkedList<>();
		while (bufferedReader.ready()) {
			words.add(bufferedReader.readLine());
		}

		// Initializes the final result to 0 in case we don't find any solution.
		String finalResult = "0";
		StringBuilder tmpResult = new StringBuilder();
		String firstWord = words.get(0);
		int wordsSize = words.size();
		int firstWordLength = firstWord.length();

		// Iterates each character of the first word. We add a label to continue
		// from here.
		outer: for (int x = 0; x < firstWordLength; x++) {
			tmpResult.append(firstWord.charAt(x));

			// Iterates each word.
			for (int y = 1; y < wordsSize; y++) {
				String currentWord = words.get(y);

				// If the current word doesn't contain the substring, that is
				// not a common substring. We start over by cleaning up the
				// current buffer and going to the next letter of the first word
				// on the outer loop.
				if (!currentWord.contains(tmpResult.toString())) {
					tmpResult = new StringBuilder();
					continue outer;
				}
			}

			// If we get here it means that our string has been matched by all
			// words. In this case, if that's equal or better than any result we
			// have found before, that's our final result. We include it even if
			// equal because since the problem states that it will always be
			// only one common substring, we will always have one result at max.
			// If that result happens to be 1 character, that will replace the
			// initial 0 value and it is guaranteed that no more results will be
			// found.
			if (tmpResult.length() >= finalResult.length()) {
				finalResult = tmpResult.toString();
			}
		}
		System.out.println(finalResult);
	}

}
