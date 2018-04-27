package design.strategy.strategy;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 14:32
 */
public class OriginalSaleStrategy implements SaleStrategy {
    @Override
    public double salePirce(double originalPrice) {
        return originalPrice;
    }
}
