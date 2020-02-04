package org.couche.webapp.test;

public class test {

	public static void main(String[] args) throws Exception {

		String str = "25Bleu1978";

		System.out.println(str.substring(6));

	}

	public static int getLastInt(String line) {

		int offset = line.length();

		for (int i = line.length() - 1; i >= 0; i--) {

			char c = line.charAt(i);

			if (Character.isDigit(c)) {
				offset--;

			} else {

				if (offset == line.length()) {
					return -1;
				}

				return Integer.parseInt(line.substring(offset));
			}
		}

		return Integer.parseInt(line.substring(offset));
	}
}
