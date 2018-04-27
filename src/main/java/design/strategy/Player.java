package design.strategy;


import design.strategy.strategy.OriginalSaleStrategy;
import design.strategy.strategy.SaleStrategy;
import design.strategy.strategy.SuperVipSaleStrategy;
import design.strategy.strategy.VipSaleStrategy;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 14:35
 */
public class Player {
    private SaleStrategy saleStrategy = new OriginalSaleStrategy();
    private double totalAmount = 0;
    private double amount = 0;

    public void buy(double amount) {
        this.amount = amount;
        totalAmount += amount;
        saleStrategy = StrategyFactory.getSaleStrategy(this);
    }

    public double lastPay() {
        return saleStrategy.salePirce(amount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
