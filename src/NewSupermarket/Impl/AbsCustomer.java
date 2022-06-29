package NewSupermarket.Impl;

import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.Customer;
import NewSupermarket.Interface.Merchandise;
import NewSupermarket.Interface.ShoppingCart;

import static NewSupermarket.Util.ShoppingUtil.getRandomCategory;

public abstract class AbsCustomer implements Customer {
    private Category shouldBuy;
    private String custId;
    private double monetSpent;
    private int guangLeft = 0;
    private int guangCount = 0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(String custId,Category shouldBuy,int guangCount){
        this.shouldBuy = shouldBuy;
        this.guangCount = guangCount;
        this.custId = custId;
    }

    public int getGuangCount(){ return guangCount;}

    public void setGuangCount(int guangCount){ this.guangCount = guangCount;}

    public AbsCustomer(String custId,Category shouldBuy){ this(custId,shouldBuy,DEFAULT_GUANG_COUNT);}

    @Override
    public String getCustId() {return custId;}

    public void startShopping(){guangLeft = guangCount;}

    /**
     * 先看必须买的，没有必须买的就随便看看
     * @return 想要购买的商品种类
     */
    @Override
    public Category chooseCategory() {
        // 有一次机会看需要买的东西
        if(guangLeft+1>=guangLeft){
            return shouldBuy;
        } else{
            return getRandomCategory();
        }
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {
        return 0;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft<=0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        monetSpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy(){ return shouldBuy;}
    @Override
    public double getMoneySpent() {
        return monetSpent;
    }
}
