package design.strategy;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 14:46
 */
public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.buy(1000);
        System.out.println(player.lastPay());
        player.buy(1000);
        System.out.println(player.lastPay());
        player.buy(1000);
        System.out.println(player.lastPay());
        player.buy(1000);
        System.out.println(player.lastPay());
    }
}
