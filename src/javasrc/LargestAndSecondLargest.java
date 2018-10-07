package javasrc;

import java.util.ArrayList;

public class LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        // new Element class to record compared values;
        // compare in pairs as -><-
        Element[] arr = convert(array);
        int largerLen = array.length;
        while (largerLen > 1) {
            compareAndSwap(arr, largerLen);
            largerLen = (largerLen + 1) / 2;
        }
        int[] res = new int[2];
        res[0] = arr[0].value;
        res[1] = getLargest(arr[0]);
        return res;
    }
    class Element {
        int value;
        ArrayList<Integer> compared;
        Element(int value) {
            this.value = value;
            this.compared = new ArrayList<Integer>();
        }
    }
    private Element[] convert(int[] array) {
        Element[] res = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = new Element(array[i]);
        }
        return res;
    }
    // compare in pairs
    private void compareAndSwap(Element[] arr, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[i].value < arr[len - 1 - i].value) {
                swap(arr, i, len - 1 - i);
            }
            arr[i].compared.add(arr[len - 1 - i].value);
        }
    }

    private void swap(Element[] arr, int l, int r) {
        Element tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private int getLargest(Element seed) {
        int max = Integer.MIN_VALUE;
        for (int i : seed.compared) {
            max = Math.max(max, i);
        }
        return max;
    }
}
