package NewSupermarket.Util;

import NewSupermarket.Impl.*;
import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.Customer;
import NewSupermarket.Interface.Merchandise;
import NewSupermarket.Interface.Supermarket;

import java.util.Scanner;

public class ShoppingUtil {

    private static final Scanner sc = new Scanner(System.in);

    public  static Scanner input() {return sc;}

    public static void output(Object obj){
        System.out.println(String.valueOf(obj));
    }

    public static Supermarket createSuperMarket(){
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length*merchandisePerCategory];

        for(Category category:Category.values()){
            for(int i = 0;i<merchandisePerCategory;i++){
                double soldPrice = Math.random()*(category.getHigherPrice()-category.getLowerPrice())+category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal()*merchandisePerCategory+i] = new SimpleMerchandise(category.name()+i,soldPrice,purchasePrice,200,category);
            }
        }

        SimpleSupermarket supermarket = new SimpleSupermarket(all);
        output("请输入超市的名字：");
        String s = sc.next();
        if(s.trim().length()>0){
            supermarket.setName(s.trim());
        }
        return supermarket;
    }

    public static Category getRandomCategory() {
        return Category.values()[(int)(Math.random()*1000)%Category.values().length];
    }

    public static VIPCard getRandomVIPCard(){
        return VIPCard.values()[(int) (Math.random()*1000)%VIPCard.values().length];
    }

    public static Customer createCustomer(boolean auto){
        if(auto){
            String custId = "CUST"+(int)(Math.random()*10000);
            Category shouldBuy = getRandomCategory();
            if(Math.random()<0.5){
                return new SuiYuanCustomer(custId,shouldBuy);
            } else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId,shouldBuy);
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }
        return null;
    }

}
