package algorithm.sort;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-06-27 10:00
 */
public class HeapSort {
    public void heapSort(int[] arr) {
        int length = arr.length;
        for (int i = length/2-1; i >= 0 ; i--) {
            adjustHeap(arr, i, length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            adjustHeap(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2*i+1; j < length; j = 2*j+1) {
            if (j+1 < length && arr[j+1] > arr[j]) {
                j++;
            }
            if (arr[i] < arr[j]) {
                arr[i] = arr[j];
                i = j;
            }
        }

        arr[i] = temp;

    }

    public static void main(String[] args) {
        int[] a = {4,3,5,7,2,1,8,9,6,0};
        new HeapSort().heapSort(a);
        System.out.println();
    }
}
