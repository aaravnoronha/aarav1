package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    // longprefix test
        String[] A = new String[]{"flower","flow","flight", "fl"};
        String S = longprefix(A);
        System.out.printf("longprefix %s\n",S );

        int[] B = new int[]{-1,2,1,-4,3,-1,5,3,-2,-8,-7,8};
        System.out.printf("maxsubarray: %d\n",maxsubarray(B));

        int[][] C = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.printf("rotatearray %s\n", Arrays.deepToString(rotatearray(C)));

        int D = 3473;
        System.out.printf("intToRoman: %s\n",intToRoman(D));


    }

    // e.g. ["flower","flow","flight"], outputs "fl"
    public static String longprefix(String [] A) {
       int charnum = 0;
       String prefix ="";
       boolean done = false;
       while(!done) {
           String cmp = A[0].substring(charnum,charnum+1);
           // check charnum-th character in all Strings from 1 to A.length
           for(int i = 1; i < A.length; i++) {
               if (charnum >= A[i].length()) {
                   done = true;
               } else {
                   String cmp2 = A[i].substring(charnum, charnum + 1);
                   if (!cmp.equals(cmp2)) {
                       done = true;
                   }
               }
           }
           if(!done) {
               prefix += cmp;
           }
           charnum++;
       }
       return prefix;

    }
    public static int maxsubarray(int [] A) {
        int n = A.length;
        int[] S = new int[n];
        // populate S
        // sum of elements in A
        S[0] = A[0];
        for(int i = 1; i < n; i++) {
            S[i] = S[i - 1] + A[i];
        }

        // compute max subarray
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sumij;
                if(i == 0) {
                    sumij = S[j];
                } else {
                    sumij = S[j] - S[i-1];
                }
                if(sumij > max) {
                    max = sumij;
                }
                // System.out.printf("i=%d,j=%d,sumij=%d,max=%d\n", i,j,sumij,max);
            }

        }
        return max;
    }

    public static int[][] rotatearray(int [][] A) {
        int n = A.length;
        int[][] rotA = new int[n][n];
        for(int i =0; i<n;i++) {
            for(int j =0;j<n;j++) {
                rotA[j][n-i-1] = A[i][j];
            }
        }
        return rotA;
    }

    public static String intToRoman(int n) {
        String S = "";
        HashMap<Integer, String> map10 = new HashMap<Integer, String>();
        HashMap<Integer, String> map100 = new HashMap<Integer, String>();
        HashMap<Integer, String> map1000 = new HashMap<Integer, String>();
        map10.put(0, "");map10.put(1, "I");map10.put(2, "II");map10.put(3, "III");map10.put(4, "IV");map10.put(5, "V");
        map10.put(6,"VI");map10.put(7,"VII");map10.put(8, "VIII");map10.put(9, "IX");map100.put(0, "");map100.put(10, "X");
        map100.put(20, "XX");map100.put(30, "XXX");map100.put(40, "XL");map100.put(50, "L");map100.put(60, "LX");map100.put(70, "LXX");map100.put(80, "LXXX");
        map100.put(90, "IC");map1000.put(100, "C");map1000.put(200, "CC");map1000.put(300, "CCC");map1000.put(400, "CD");map1000.put(500, "D");
        map1000.put(600, "DC");map1000.put(700, "DCC");map1000.put(800, "DCCC");map1000.put(900, "CM");
        int A = n % 10;
        S = map10.get(A) + S;
        n -= A;
        A = n % 100;
        S = map100.get(A) + S;
        n -= A;
        A = n % 1000;
        S = map1000.get(A) + S;
        n -= A;
        return S;

    }
}







