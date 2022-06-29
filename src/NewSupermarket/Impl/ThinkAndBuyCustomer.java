package NewSupermarket.Impl;

import NewSupermarket.Interface.Card;
import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.HasCard;
import NewSupermarket.Interface.Merchandise;

public class ThinkAndBuyCustomer extends AbsCustomer implements HasCard {
    private Card card = VIPCard.Level0;

    public  ThinkAndBuyCustomer(String custId, Category shouldBuy){ super(custId,shouldBuy);}

    public int buyMerchandise(Merchandise merchandise){
        Category category = merchandise.getCatgory();
        // 需要买的就买一个
        if(category == getShouldBuy()){
            return 1;
        }

        double soldPrice = merchandise.getSoldPrice();

        double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;
        if(soldPrice<avgPrice){
            return 1;
        } else {
            return 0;
        }
    }

    public void setCard(Card card){this.card = card;}

    @Override
    public Card getCard() {
        return card;
    }
}
