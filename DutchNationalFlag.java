package wayfair;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void dnf(int[] a, int low, int high) {
        int startIndex = 0;
        int endIndex = a.length - 1;
        int temp;

        for (int i = 0; i <= endIndex ;) {
            if (a[i] < low) {
                temp = a[i];
                a[i] = a[startIndex];
                a[startIndex] = temp;
                i++;
                startIndex++;
            } else if (a[i] > high) {
                temp = a[i];
                a[i] = a[endIndex];
                a[endIndex] = temp;
                endIndex--;
                // do not increment i. We have to revisit this again
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 1, 1, 0, 0, 2, 1, 1, 0, 2, 1, 1 , 1, 1, 0};
        DutchNationalFlag.dnf(a, 0, 1);
        System.out.println(Arrays.toString(a));

    }

}