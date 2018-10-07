package javasrc;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;


public class Main {




    public static void main(String[] args) {
        // write your code here
//        TreeNode in = new TreeNode(1);
//        TreeNode a = new TreeNode(2);
//        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(4);
//        TreeNode d = new TreeNode(5);
//        in.left = a;
//        in.right = b;
//        a.left = c;
//        b.right = d;
//        List<String> input2 = new ArrayList<>();
//        input2.add("cat");
//        input2.add("cats");
//        input2.add("and");
//        input2.add("dog");
//        input2.add("sand");
//        SerializeBinaryTree obj = new SerializeBinaryTree();
//        Node head = obj.SerializeBinaryTree(in);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
//        UberRateLimiter rl = new UberRateLimiter();
//
//        while (true) {
//            System.out.println(rl.isAllow(1));
//
//            try {
//                Thread.sleep(10);
//
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
//        }
        UberWeightedRandom res = new UberWeightedRandom();
        int[] in = {1,2,3,4};
        int[] out = new int[4];
        for (int i = 0; i < 1000; i++) {
            int j = res.UberWeightedRandom(in);
            out[j]++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        for (int i = 0; i < out.length; i++) {

            System.out.printf("%d : ratio is %f", i, (double) out[i] / 10);

        }



    }
}


