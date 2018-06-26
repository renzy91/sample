package algorithm.sort;

/**
 * @author renzhiyong
 * @description:插入排序
 * @date 2018-06-26 17:14
 */
public class InsertSort {
    public void insertSort(int[] arr) {
        int temp,j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,7,2,1,8,9,6,0};
        new InsertSort().insertSort(a);
        System.out.println();
    }
}
