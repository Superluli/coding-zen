package com.superluli.bits;

/**
 * Find number of 1's in binary presentation of number
 * 
 * @author Lu
 *
 */
public class FindOnes {

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i < 100000000; i++) {
			findOnes1(1);
		}
		
		long t2 = System.currentTimeMillis();
		
		for (int i = 0; i < 100000000; i++) {
			findOnes2(1);
		}
		
		long t3 = System.currentTimeMillis();
		
		System.err.println(t2 - t1);
		System.err.println(t3 - t2);
	}

	public static int findOnes1(int num) {

		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((num >>i & 1) == 1)
				count++;
		}
		return count;
	}

	public static int findOnes2(int num) {
		
		int count = 0;
		while(num > 0){
			count ++;
			num = num & (num-1);
		}
		return count;
	}
}
