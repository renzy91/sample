package design.strategy.strategy;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 14:33
 */
public class SuperVipSaleStrategy implements SaleStrategy {
    @Override
    public double salePirce(double originalPrice) {
        return originalPrice * 0.5;
    }
}
