import java.util.Scanner;

public class Game {
	public static void main(String[] args) {

		/*
		int rows = 0;
		int collumns = 0;

		Scanner input = new Scanner(System.in);
		String letters;

		do {
			letters = input.next();

			for (int i = (int) Math.sqrt(letters.length()); i > 1; i--) {
				if (letters.length() % i == 0) {
					collumns = i;
					rows = letters.length() / i;
					break;
				}
			}
		} while (rows == 0);

		char[][] finalArr = new char[rows][collumns];
		char[] symbols = letters.toCharArray();

		int i = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < collumns; c++) {
				finalArr[r][c] = symbols[i];
				i++;
			}
		}
		*/
		
		int rows = 0;
		int collumns = 0;
		
		Scanner input = new Scanner(System.in);
		boolean goOn;
		char[][] array;
		do {
			goOn = false;
			System.out.println("Enter dimensions.");
			System.out.print("Number of rows:");
			rows = input.nextInt();
			System.out.print("Number of collumns:");
			collumns = input.nextInt();
			array = new char [rows][collumns];
		
			System.out.println("Enter the array row by row.");
			for( int r = 0; r < rows; r++) {
				String row;
				int rowLength;
				row = input.next();
				rowLength=row.length();
				if(rowLength == collumns) {
					for( int c = 0; c < collumns; c++) {
						array[r][c] = row.charAt(c);					
					}
				} else { 
					System.out.println("Incorrect input.");
					goOn = true;
					break;
				}
			}
		}while(goOn);
		
		//------------------------------------------------------------

		// prints the 2D array
		/*
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < collumns; c++) {
				System.out.print(finalArr[r][c] + "  ");
			}
			System.out.println();
		}
		*/

		System.out.println("Enter search word: ");
		String searchWord;
		searchWord = input.next();
		input.close();

		int counts = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < collumns; c++) {
				if (array[r][c] == searchWord.charAt(0)) {
					counts += findTheWord(r, c, array, searchWord);
				}
			}
		}

		// checks if the word is written in the same way backwards
		boolean palindrome = true;
		for (int p = 0; p < searchWord.length() / 2; p++) 
		{
			if (searchWord.charAt(p) == searchWord.charAt(searchWord.length()- p - 1)) {
			} else {
				palindrome = false;
				break;
			}
		}

		if (palindrome) {
			System.out.println(counts / 2);
		} else {
			System.out.println(counts);
		}
	}

	private static int findTheWord(int r, int c, char[][] arr, String word) {
		int counts = 0;
		int rightLetters = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 1; k < word.length(); k++) {
					if (r + k * i >= 0 && r + k * i < arr.length && c + k * j >= 0 && c + k * j < arr[0].length) { // is the element out of bounds
						if (arr[r + k * i][c + k * j] == word.charAt(k) && i != -j) { // is the element the next letter of the word
							rightLetters++;
						} else {
							rightLetters = 0;
							break;
						}
					}
				}
				if (rightLetters == word.length() - 1) {
					counts++;
					rightLetters = 0;
				}
			}
		}

		return counts;
	}
}

/*
 * //TO DO : ADD 3 OTHERS METHODS FOR OTHER DIRECTIONS private static int
 * countMatches(char [][] finalArr,char searchLetters[],String searchWord, int
 * direction){ int countMatches = 0; int currentMatches =0; for (int r = 0; r <
 * finalArr.length; r++) { for ( int c = 0; c < finalArr[0].length; c++) { int
 * patternIndex = 0; //add directions to R or C with pattern Index
 * if(finalArr[r][c] == searchLetters[patternIndex]) { patternIndex++;
 * currentMatches++; } if( currentMatches == searchWord.length()) { countMatches
 * ++; //only zero or one } } } return countMatches; } }
 */

