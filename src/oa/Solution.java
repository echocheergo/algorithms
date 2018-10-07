package oa;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // number of students
        int[] skills = new int[n]; // skills array
        for (int i = 0; i < n; i++) {
            skills[i] = in.nextInt();
        }
        int k = in.nextInt(); // target
        long res = formingTeams(n, skills, k);
        System.out.println(res);
        in.close();
    }


    public static long formingTeams(int n, int[] skills, int target) {
        // since only one index needs to be unique
        // fix leftmost as the variable
        // therefore mid and right can be the same
        // test few and see that duplicates: if mid and right not same value then get product 2) if same then get Cn2 combination
        long count = 0;
        if (n < 3) {
            return count;
        }
        // sort first
        Arrays.sort(skills);

        for (int i = 0; i < n - 2; i++) {
            // ensure at least one student is different

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = skills[i] + skills[left] + skills[right];
                if (sum == target) {
                    int rightDup = 1;
                    while (skills[right] == skills[right - 1] && left < right - 1) {
                        rightDup++;
                        right--;
                    }
                    int leftDup = 1;
                    while (skills[left] == skills[left + 1] && left < right - 1) {
                        leftDup++;
                        left++;
                    }
                    if (left + 1 == right && skills[left] == skills[right]) {
                        count += (leftDup + rightDup) * (leftDup + rightDup - 1) / 2;
                    } else {
                        count += (leftDup * rightDup);
                    }
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
