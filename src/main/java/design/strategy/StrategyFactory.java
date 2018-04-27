package design.strategy;

import design.strategy.strategy.OriginalSaleStrategy;
import design.strategy.strategy.SaleStrategy;
import design.strategy.strategy.SuperVipSaleStrategy;
import design.strategy.strategy.VipSaleStrategy;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 15:06
 */
public class StrategyFactory {
    public static SaleStrategy getSaleStrategy(Player player) {
        if (player.getTotalAmount() > 3000) {
            return new SuperVipSaleStrategy();
        }
        if (player.getTotalAmount() > 2000) {
            return new VipSaleStrategy();
        }

        return new OriginalSaleStrategy();
    }
}
