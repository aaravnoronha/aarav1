package com.company;

public class Main {

    public static void main(String[] args) {
	    // longprefix test
        String[] A = new String[]{"flower","flow","flight", "fl"};
        String S = longprefix(A);
        System.out.printf("longprefix %s\n",S );
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
}
