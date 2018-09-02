package java;

public class CompressString {
    public String compress(String input) {
        // Write your solution here

        if (input.length() == 0) {
            return input;
        }
        char[] arr = input.toCharArray();
        int slow = 1;
        int counter = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) { // avoid discussing arr[slow] = num)
                counter++;
            } else {
                checkCount(arr, slow, counter);
                slow++;
                arr[slow] = arr[i];
                slow++;
                counter = 1;
            }
        }
        checkCount(arr, slow, counter);


/*        int fast = 1;
        int count = 1;
        while (fast < arr.length) {
            if (arr[fast] == arr[slow]){
              if (fast != arr.length - 1) {
                fast++;
                count++;
            } else {
              slow++;
              arr[slow] = (char) (count + 1 + '0');
              count = 0;
              fast++;
            }
          } else if ((fast - slow > 1 && arr[slow] > 57) && count > 1) {
              slow++;
              arr[slow] = (char) (count + '0');
              count = 0;
          } else {
              slow++;
              arr[slow] = arr[fast];
              fast++;
              count = 1;
            }
        }
*/
        return new String(arr, 0, slow);
    }
    private void checkCount(char[] arr, int slow, int counter) {
        if (counter > 1) {
            for (char c : Integer.toString(counter).toCharArray()) {
                arr[slow] = c;
                slow++;
            }
        }
    }
}
