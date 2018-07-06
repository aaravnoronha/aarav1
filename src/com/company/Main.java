package com.company;

public class Main {

    public static void main(String[] args) {
	    // longprefix test
        String[] A = new String[]{"flower","flow","flight", "fl"};
        String S = longprefix(A);
        System.out.printf("longprefix %s\n",S );

        int[] B = new int[]{-1,2,1,-4,3,-1,5,3,-2,-8,-7,8};
        System.out.printf("maxsubarray: %d\n",maxsubarray(B));
    }

    // e.g. ["flower","flow","flight"], outputs "fl"
    public static String  longprefix(String [] A) {
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


}






