import java.util.*;

public class SortLevel {

    private static void change(int indexFirst, int indexSecond, int[] array) {
        int value = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = value;
    }

    public static void SelectionSortStep(int array[], int i) {
        if (i >= array.length) {
            return;
        }
        int min = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        if (min != i) {
            change(i, min, array);
        }
    }

    public static boolean BubbleSortStep(int array[]) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                change(i + 1, i, array);
            }
        }
        return isSorted;
    }

    public static void InsertionSortStep(int[] array, int step, int i) {
        // Loop 1. Get all numbers using step
        for (int j = i + step; j < array.length; j += step) {
            /* Loop 2. For each number, look for a place to insert.
            To do this, we sequentially compare the numbers.*/
            for (int k = i; k < j; k += step) {
                if (array[j] < array[k]) {
                    /*Place found. Index insert = k.
                    Now you need to shift all elements to the right by 1
                    and insert the element to a new location.*/

                    //We will save the old value and insert it into a new place in the next iteration.
                    int valuePrev = array[k];
                    int valueNext = array[k + step];
                    for (int l = k + step; l <= j; l += step) {
                        valueNext = array[l];
                        array[l] = valuePrev;
                        valuePrev = valueNext;
                    }
                    array[k] = valueNext;
                    break;
                }
                break;
            }
        }
    }
}
