import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalPosition {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String startingPoint;
		startingPoint = input.nextLine();

		Pattern searchPattern = Pattern.compile("\\d+");
		Matcher matchString = searchPattern.matcher(startingPoint);

		int x = 0;
		int y = 0;

		if (matchString.find()) {
			x = Integer.parseInt(matchString.group().trim());
		}
		if (matchString.find()) {
			y = Integer.parseInt(matchString.group().trim());
		}

		String directions;
		directions = input.next();
		char[] dir = directions.toCharArray();

		boolean inverse = false;

		for (int i = 0; i < dir.length; i++) {
			if (dir[i] == '<') {
				x = (inverse) ? x + 1 : x - 1;
			} else if (dir[i] == '>') {
				x = (inverse) ? x - 1 : x + 1;
			} else if (dir[i] == 'v') {
				y = (inverse) ? y - 1 : y + 1;
			} else if (dir[i] == '^') {
				y = (inverse) ? y + 1 : y - 1;
			} else if (dir[i] == '~') {
				inverse = !inverse;
			}
		}

		System.out.println("(" + x + ", " + y + ")");
		input.close();
	}
}
