package NewSupermarket.Impl;

import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.Merchandise;

public class SuiYuanCustomer extends AbsCustomer {
    private static final double MUST_BUY_CHANCE = 0.8;
    private static final double GUANG_BUY_CHANCE = 0.1;

    public SuiYuanCustomer(String custId, Category mustBuy){
        super(custId,mustBuy,DEFAULT_GUANG_COUNT);
    }

    public int buyMerchandise(Merchandise merchandise){
        // 买一个商品的概率
        double chanceToBuy = merchandise.getCatgory() == getShouldBuy() ? MUST_BUY_CHANCE : GUANG_BUY_CHANCE;

        // 缘分不到，那就返回0
        if(chanceToBuy<Math.random()){
            return 0;
        } else {
            // 否则就买1个或者多个，看缘分到哪
            return 1+(int) (Math.random()*3);
        }
    }
}
