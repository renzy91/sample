package algorithm.sort;

import java.util.Arrays;

/**
 * @author renzhiyong
 * @description: 归并排序
 * @date 2018-06-26 17:51
 */
public class MergeSort {
    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[start+l] = temp[l];
        }
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,7,2,1,8,9,6,0};
        new MergeSort().mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
