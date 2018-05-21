package algorithm.gold;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-17 14:37
 */
public class Divide {

    int[] gold = {0, 400, 500, 200, 300, 350};
    int[] person = {0, 5, 5, 3, 4, 3};

    public void gold() {
        int work = 10;
        int sum = handle(work, 5);
        System.out.println(sum);
    }

    public int handle(int work, int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 && work >= person[n]) {
            return gold[n];
        }

        if (n == 1 && work < person[n]) {
            return 0;
        }

        if (work < person[n]) {
            return handle(work, n - 1);
        }

        return Math.max(handle(work, n - 1), handle(work - person[n], n - 1) + gold[n]);
    }

    public int dp(int n, int work) {
        int[] preResult = new int[work+1];
        int[] result = new int[work+1];

        for (int i = 1; i <= work; i++) {
            if (i < person[1]) {
                preResult[i] = 0;
            } else {
                preResult[i] = gold[1];
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= work; j++) {
                if (j < person[i]) {
                    result[j] = preResult[j];
                } else {
                    result[j] = Math.max(preResult[j], preResult[j-person[i]] + gold[i]);
                }
            }

            System.arraycopy(result, 0, preResult, 0, work+1);
        }

        return result[work];
    }

    public static void main(String[] args) {
//        Divide divide = new Divide();
//        divide.gold();

        System.out.println(new Divide().dp(5, 10));
    }

}
