package javasrc;

import java.util.Random;

public class UberWeightedRandom {
    public int UberWeightedRandom(int[] input) {
        // if weight not changed
        // preprocess to get prefix sum
        int[] cum = new int[input.length];
        cum[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            cum[i] = cum[i - 1] + input[i];

        }
        Random rand = new Random();
        int target = rand.nextInt(cum[input.length - 1]) + 1;
        return find(cum, target, 0, cum.length - 1);

    }

    private int find(int[] arr, int key, int l, int r) {
        // find the smallest larger or equal ele

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > key) {
                r = mid - 1;

            } else if (arr[mid] < key){
                l = mid + 1;

            } else {
                return mid;
            }
        }
        return l;
        }
    }

