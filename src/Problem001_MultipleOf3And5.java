import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            n = n - 1;
            
            long sum3 = 3 * (n / 3 * (n / 3 + 1) / 2);
            
            long sum5 = 5 * (n / 5 * (n / 5 + 1) / 2);
            
            long sum15 = 15 * (n / 15 * (n / 15 + 1) / 2);
            
            long result = sum3 + sum5 - sum15;
            
            System.out.println(result);
        }
    }
}
