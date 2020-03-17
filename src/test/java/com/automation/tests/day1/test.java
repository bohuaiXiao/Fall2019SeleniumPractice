package com.automation.tests.day1;

import java.util.Arrays;

/**
 * @author:
 * @create:
 * @date:
 */
public class test {
    public static void main(String[] args) {
        System.out.println("A"+0+1);
        System.out.println("B"+(0)+(1));
        String a = " ";
        a.trim();
        System.out.println(a.equals("")+" "+a.isEmpty());
        int num[];
        num = new int[2]    ;
        num[0] =10;
        num[1] =20  ;
        num = new int[4];
        num[2] =30  ;
        num[3] =40  ;
        System.out.println(Arrays.toString(num));

        String ta = "a";
        ta = ta.concat("b");
        System.out.println("ta = " + ta);
        String tb = "c";
        ta+=tb  ;
        System.out.println("ta = " + ta);
        ta.replace('c','d');
        System.out.println(ta   );
        int x=1;
        int e =x++;
        int r =++x;
        int d = x++;
        //int f = (e<r)?(e<d)?e:(r<d)?r:d;
        //System.out.println("f = " + f);
        int[] num1 = new int[3];
        int[] num2 = {1,2,3,4,5};
        num1 = num2;
        System.out.println(Arrays.toString(num1));

        String[][] arr = {{"a","b","c"},{"d","e"}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("a")){
                    break;
                }
                System.out.println(arr[i][j]);
            }
        }
    }
    public int findMax(int [] arr){
        return 0;
    }
}
