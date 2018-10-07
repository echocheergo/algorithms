package javasrc;

public class Move0sToEnd {
    // 1. not remain original order: like quickSort: -> <-
    // 2. remain order: two brakes same direction 1) only copy non-0 and fill with 0 (bad when large array and few non-0) 2) swap, switch pointers when cross
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array.length < 2) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[slow] == 0 && array[fast] != 0) {
                swap(array, slow, fast);
                fast++;
                slow++;
            }
            else if (array[slow] != 0 && array[fast] == 0) {
                slow++;
                fast++;
            }
            else if (array[slow] != 0 && array[fast] != 0) {
                slow++;
                if (slow > fast) {
                    fast = slow;
                }
            }
            else if (array[slow] == 0 && array[fast] == 0) {
                fast++;
            }
        }
        return array;
    }
    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
