package algorithm.sort;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-16 18:57
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,6,9,3,5,3,6,87,3,2,5,6};
        sort(array, 0, array.length-1);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = array[left];
        int l = left;
        int r = right;
        while(l != r) {
            while(l < r && array[r] >= temp) {
                r--;
            }
            while (l < r && array[l] <= temp) {
                l++;
            }

            int t= array[l];
            array[l] = array[r];
            array[r] = t;
        }
        array[left] = array[l];
        array[l] = temp;

        sort(array, left, l);
        sort(array, l+1, right);
    }

}
