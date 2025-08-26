package labTest1;
//

//public class Task1 {
//
//	public static void main(String[] args) {
//		int n = 60;
//
//		long start;
//		long end;
//
//		start = System.currentTimeMillis();
//		System.out.println(f_iter(n));
//		end = System.currentTimeMillis();
//
////		start = System.currentTimeMillis();
////		System.out.println(f_rec(n));
////		end = System.currentTimeMillis();
//
//		long runTime = end - start;
//		System.out.println("start: " + start + " end: " + end + " run time is: " + runTime);
//
//	}
//
//	public static long f_rec(int n) {
//		if (n == 0) {
//			return 0;
//		} else if (n == 1) {
//			return 1;
//		} else if (n < 0) {
//			return -1;
//		}
//		return n + f_rec(n - 1) + f_rec(n - 2);
//	}
//
//	public static long f_iter(int n) {
//		if (n < 0)
//			return -1;
//		if (n == 0)
//			return 0;
//		if (n == 1)
//			return 1;
//		long f0 = 0;
//		long f1 = 1;
//
//		for (int i = 2; i <= n; i++) {
//			long fi = i + f1 + f0;
//			f0 = f1;
//			f1 = fi;
//		}
//		return f1;
//	}
//
//}

public class Task1 {
	static long calls = 0;

	static int f(int x, int y, int z) {
		calls++;
		if (x == 0)
			return y + z;
		if (y == 0)
			return x + z;
		if (z == 0)
			return x + y;
		return f(x - 1, f(x - 1, y, z), z);
	}


	public static void main(String[] args) {
		calls = 0;
		int output20s = f(20, 20, 20);
		long output20calls = calls;
		System.out.println("f20s = " + output20s + ", calls = " + output20calls);

		int output25s = f(25, 25, 25);
		long output25calls = calls;
		System.out.println("f25s = " + output25s + ", calls = " + output25calls);
	}
}
