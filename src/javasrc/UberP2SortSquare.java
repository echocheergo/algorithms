package javasrc;

public class UberP2SortSquare {
    public int[] sortSquare(int[] arr) {
        int len = arr.length;
        // find first >=0 number can be optimized using BS
        // O (N)
        int k = 0;
        while (k < len) {
            if (arr[k] < 0) {
                k++;
            } else {
                break;
            }
        }
        // merge
        int i = k - 1;
        int j = k;
        int ind = 0;
        int[] tmp = new int[len];
        while (i >= 0 && j < len) {
            int p1 = arr[i] * arr[i];
            int p2 = arr[j] * arr[j];
            if (p1 < p2) {
                tmp[ind++] = p1;
                i--;
            } else {
                tmp[ind++] = p2;
                j++;
            }
        }
        while (i >= 0) {
            tmp[ind++] = arr[i] * arr[i];
            i--;
        }
        while (j < len) {
            tmp[ind++] = arr[j] * arr[j];
            j++;
        }
    return tmp;
    }
}
