import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int one = 1 ;
    int zero = 1 ;
    for(int i=1;i<n;i++)
    {
        int nzero = one ;
        int none = one+zero ;
        
        one = none;
        zero = nzero ;
    }
    int ans = one+zero;
    System.out.println(ans*ans);
 }

}