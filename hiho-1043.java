

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] c = new int[n];
		int[] v = new int[n];
		for(int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
			v[i] = scanner.nextInt();
		}
		int[] f = new int[m];
		for(int i = 0; i < n; i++) {
			for(int j = c[i]; j < m; j++) {
				f[j] = Math.max(f[j], f[j-c[i]] + v[i]);
			}
		}
		System.out.println(f[m-1]);
	}
}
