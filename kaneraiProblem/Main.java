package kaneraiProblem;

public class Main {

	private static String maxPossible(String word, int k) {
		int wordLen = word.length();
		if(wordLen == 1) return word;
		int start = 0, end = 0;
		int currMin = word.charAt(start), currMax = currMin;
		char currChar;
		int wordStart = 0, wordEnd = 0;
		int maxUntilNow = 1;
		while(end < wordLen) {
			currChar = word.charAt(end);
			System.out.println("considering end = "+end+" currChar = "+currChar);
			if(Math.abs(currChar - currMin) <= k && Math.abs(currMax - currChar) <= k) {
				/*
				 * ok to take this
				 */
				
				if(currChar < currMin) currMin = currChar;
				if(currChar > currMax) currMax = currChar;
			}
			else {
				/*
				 * not ok to take this
				 * consider word[start..end - 1]
				 */
				if(end - start > maxUntilNow) {
					maxUntilNow = end - start;
					wordStart = start;
					wordEnd = end - 1;
				}
				start = end;
				currMin = currChar;
				currMax = currChar;
				
			}
			end++;
		}
		/*
		 * consider end - start
		 */
		if(end - start > maxUntilNow) {
			maxUntilNow = end - start;
			wordStart = start;
			wordEnd = end - 1;
		}
		return word.substring(wordStart, wordEnd + 1);
		
	}
	public static void main(String[] args) {
		System.out.println(maxPossible("weddinggghhtrgyhhggg", 1));

	}

}
