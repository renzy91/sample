package algorithm.backpack;

import java.util.Arrays;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-17 10:20
 */
public class Greedy {
    Good[] goods = {
            new Good(10, 60),
            new Good(20, 100),
            new Good(30, 90),
            new Good(40, 100),
    };

    public void bag(double capacity) {
        valueSort(goods);

        for (int i = 0; i < goods.length && capacity > 0; i++) {
            if (goods[i].weight <= capacity) {
                goods[i].choose = true;
                capacity -= goods[i].weight;
            }
        }

        for (Good good : goods) {
            System.out.println(good);
        }
    }

    private void valueSort(Good[] goods) {
        Arrays.sort(goods, (o1, o2) -> {
            if (o1.price/o1.weight > o1.price/o2.weight) {
                return -1;
            }
            return 1;
        });
    }

    class Good {
        double weight;
        double price;
        boolean choose;

        public Good(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Good{" +
                    "weight=" + weight +
                    ", price=" + price +
                    ", choose=" + choose +
                    '}';
        }
    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        greedy.bag(40);

    }
}
