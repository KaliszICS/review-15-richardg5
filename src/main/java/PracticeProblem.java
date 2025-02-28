public class PracticeProblem {
	private static final int MIN_LENGTH = 2;
	private static final int NO_CASE_RETURN = -1;
	private static final int NUMBER_OF_CHARACTERS = 26;

	public static void main(String args[]) {

	}

	public static int goodString(String check) {
		if (check.length() < MIN_LENGTH) {
			return NO_CASE_RETURN;
		} else if (check.charAt(0) == check.charAt(check.length() - 1)) {
			return 0;
		}
		int[] startIndexes = new int[NUMBER_OF_CHARACTERS];
		int[] endIndexes = new int[NUMBER_OF_CHARACTERS];
		for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
			startIndexes[i] = check.indexOf((char) ('a' + i));
			endIndexes[i] = check.lastIndexOf((char) ('a' + i));
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
			if (endIndexes[i] - startIndexes[i] + 1 >= MIN_LENGTH) {
				ans = Math.min(ans, startIndexes[i] + (check.length() - endIndexes[i] - 1));
			}
		}
		if (ans == Integer.MAX_VALUE) {
			ans = NO_CASE_RETURN;
		}
		return ans;
	}
}
