package week.two.day.seven;

import java.util.Scanner;

public class PyramidPattern04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many layers you want to print : ");
		int layers = sc.nextInt();
		System.out.println(getStartPattern(layers));

	}

	private static String getStartPattern(int layers) {
		String output = "";
		for (int i = 1; i <= layers; i++) {
			for (int k = layers; k > i; k--)
				output += " ";
			for (int j = 1; j <= i; j++) {
				if (j == 1)
					output += "*";
				else
					output += " *";
			}
			output += "\n";
		}
		for (int i = 1; i < layers; i++) {
			for (int j = 1; j <= i; j++)
				output += " ";
			for (int k = layers; k > i; k--) {
				if (k == (layers))
					output += "*";
				else
					output += " *";
			}

			output += "\n";
		}
		return output;
	}
}
