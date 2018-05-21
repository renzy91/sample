package algorithm.backpack;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-17 17:59
 */
public class DP {

    public static void main(String[] args) {
        int capacity = 40;
        int[] weight = {10, 20, 30, 40};
        int[] price = {60, 100, 90, 100};

        int[] preResult = new int[capacity/10];
        int[] result = new int[capacity/10];

        for (int i = 0; i < capacity / 10; i++) {
            if (i*10 < weight[0]) {
                preResult[i] = 0;
            } else {
                preResult[i] = price[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < capacity / 10; j++) {
                if (j*10 < weight[i]) {
                    result[j] = preResult[j];
                } else {
                    result[j] = Math.max(preResult[j], preResult[(j*10 - weight[i])/10] + price[i]);
                }
            }

            System.arraycopy(result, 0, preResult, 0, capacity/10);
        }

        System.out.println(result[capacity/10-1]);
    }
}
