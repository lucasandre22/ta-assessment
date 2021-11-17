import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Solve {

	public static HashMap<Integer, Vector<Character>> keysMap = new HashMap<Integer, Vector<Character>>();

	public static void buildMap() {
		int letter = 'a';

		for(int i = 2; i < 10; i++) {
			keysMap.put(i, new Vector<>());
			int keyLimitLetter = (i == 7 || i == 9) ? letter + 3 : letter + 2;
			for(int j = letter; j <= keyLimitLetter; letter++, j++) {
				keysMap.get(i).add((char) j);
			}
		}
	}

	public static int getLetterMapIndex(char letter) {
		int asc = (int) letter;
		if(asc > 'o') {
			if(asc < 't')
				return 7;
			return asc < 'w' ? 8 : 9;
		} else {
			return (asc - 'a') / 3 + 2;
		}
	}

	public static int getTimesToPress(int index, char letter) {
		return keysMap.get(index).indexOf(letter) + 1;
	}

	public static void main(String[] args) {
		String inputWord;
		Scanner scanner = new Scanner(System.in);
		char letter;
		int mapKey;
		Solve.buildMap();
		inputWord = scanner.next();
		scanner.close();
		for(int i = 0; i < inputWord.length(); i++) {
			letter = inputWord.charAt(i);
			mapKey = getLetterMapIndex(letter);
			System.out.println("#" + mapKey + "=" + getTimesToPress(mapKey, letter));
		}
	}
}
