/*
 * Recursion---works like stack
 * 
*/

package com.leet;

/**
 * @author cteja
 *
 */
public class StringReverseRecursion {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="123 4";

		reverse(s,0,s.length());
	}
	public static void reverse(String s,int i,int n){


		if(i==n) return;
		reverse(s,i+1,n);
		System.out.print(s.charAt(i));
	}
}
