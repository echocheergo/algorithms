package javasrc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArr {
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        int n = arrayOfArrays.length;
        int length = 0;
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new Comparator<Element>() {

            @Override
            public int compare(Element e1, Element e2) {
                if (e1.value < e2.value) {
                    return -1;
                }
                if (e1.value == e2.value) {
                    return 0;
                }
                return 1;
            }
        });
        for (int i = 0; i < n; i++) {
            int[] arr = arrayOfArrays[i];
            length += arr.length;
            if (arr.length != 0) {
                minHeap.offer(new Element(i, 0, arr[0]));
            }
        }
        int[] res = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Element tmp = minHeap.poll();
            res[cur++] = tmp.value;
            if (tmp.indexInArr < arrayOfArrays[tmp.indexOfArr].length - 1) {
                tmp.indexInArr++;
                tmp.value = arrayOfArrays[tmp.indexOfArr][tmp.indexInArr];
                minHeap.offer(tmp);
            }

        }
        return res;
    }
    class Element {
        int indexOfArr;
        int indexInArr;
        int value;
        Element(int indexOfArr, int indexInArr, int value) {
            this.indexOfArr = indexOfArr;
            this.indexInArr = indexInArr;
            this.value = value;
        }
    }
}
