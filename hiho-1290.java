
import java.util.Scanner;

public class Hiho_1290 {

	static int N = 110;
	static int[][] up;
	static int[][] r;
	static int[][] a;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		a = new int[N][N];
		up = new int[N][N];
		r = new int[N][N];
		for (int i = 0; i <n; i++) {
			String string = scanner.next();
			char[] ch = string.toCharArray();
			for (int j = 0; j < m; j++) {
				if (ch[j] == '.') a[i][j] = 0;
				else a[i][j] = 1;
			}
			a[i][m] = 1;
		}
//		print(n,m);
		for(int i = 0; i <= m; i++) {
			a[n][i] = 1;
		}
		//初始化第一行
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (a[0][i] == 1) cnt++;
			r[0][i] = cnt;
			up[0][i] = INF;
		}
		
		cnt = 0;
		//一开始往右走，要判断
		if (a[0][1] != 1)++cnt;
		//初始化第一列
		for (int i = 0; i < n; i++) {
			if (a[i][0] == 1) cnt++;
			up[i][0] = cnt;
			r[i][0] = INF;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				up[i][j] = getUp(i, j);
				r[i][j] = getRight(i, j);
				if (a[i][j] == 1) {
					up[i][j]++;
					r[i][j]++;
				}
			}
		}
		System.out.println(Math.min(up[n-1][m-1], r[n-1][m-1]));
	}
	public static int getUp(int i, int j) {
		int x = up[i-1][j];
		int y = r[i-1][j];
		if (a[i-1][j+1] != 1) y++;
		return Math.min(x, y);
	}
	public static int getRight(int i, int j) {
		int x = r[i][j-1];
		int y = up[i][j-1];
		if (a[i+1][j-1] != 1) y++;
		return Math.min(x, y);
	}
	
	public static void print(int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
