package algorithm.sort;

/**
 * @author renzhiyong
 * @description:希尔排序
 * @date 2018-06-26 17:24
 */
public class ShellSort {
    public void shellSort(int[] arr) {
        int step = 0;
        while(step < arr.length) {
            step = step*3 + 1;
        }

        while (step >= 1) {
            for (int i = step; i < arr.length; i = i + step) {
                int temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j = j - step;
                }
                arr[j + step] = temp;
            }

            step = (step - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,7,2,1,8,9,6,0};
        new ShellSort().shellSort(a);
        System.out.println();
    }
}
