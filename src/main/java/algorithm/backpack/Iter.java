package algorithm.backpack;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-17 17:25
 */
public class Iter {
    int[] weight = {10, 20, 30, 40};
    int[] price = {60, 100, 90, 100};

    public int handle(int capacity, int n) {
        if (n < 0 || capacity <= 0) {
            return 0;
        }
        if (n == 0 && capacity >= weight[n]) {
            return price[n];
        }
        if (n == 0 && capacity < weight[n]) {
            return 0;
        }

        //剩余重量不能放下当前物品
        if (capacity < weight[n]) {
            return handle(capacity, n-1);
        }

        return Math.max(handle(capacity, n-1), handle(capacity-weight[n], n-1) + price[n]);
    }

    public static void main(String[] args) {
        System.out.println(new Iter().handle(40, 3));
    }
}
