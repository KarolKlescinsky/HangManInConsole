import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangManMain {

	public static void main(String[] args) throws IOException {

		HangManMain hangman = new HangManMain();

		String randomWord = hangman.getRandomWord();
		char[] randomWordByCharacters = randomWord.toCharArray();
		char[] playersCorrectGuesses = new char[randomWord.length()];
		char under = '_';

		for (int i = 0; i < randomWord.length(); i++) {
			playersCorrectGuesses[i] = under;
		}

		System.out.println(randomWord);
		System.out.println("I guess the number which is " + randomWord.length() + " long.");

		do {
			System.out.println("Enter character");
			char playersGuess = new ReadLine().readLine().toLowerCase().charAt(0);

			for (int i = 0; i < randomWord.length(); i++) {
				if (randomWordByCharacters[i] == playersGuess) {
					System.out.println("Good one.");
					System.out.println(randomWordByCharacters);
					playersCorrectGuesses[i] = randomWordByCharacters[i];
					System.out.println(playersCorrectGuesses);

				} else {
					System.out.println("Wrong guess.");
				}
			}

		} while (!isGuessed());

	}

	private static boolean isGuessed() {
		return false;
	}

	public String getRandomWord() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("Words.txt"));
		String line = reader.readLine();
		List<String> words = new ArrayList<String>();
		while (line != null) {
			String[] wordsLine = line.split(" ");
			for (String word : wordsLine) {
				words.add(word);
			}
			line = reader.readLine();
		}

		Random rand = new Random();
		String randomWord = words.get(rand.nextInt(words.size()));
		reader.close();

		return randomWord;
	}

}
