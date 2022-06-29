package NewSupermarket;

import NewSupermarket.Impl.SimpleShopman;
import NewSupermarket.Interface.Customer;
import NewSupermarket.Interface.Shopman;
import NewSupermarket.Interface.Supermarket;
import static NewSupermarket.Util.ShoppingUtil.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        Supermarket supermarket = createSuperMarket();
        Shopman shopman = new SimpleShopman(supermarket);

        boolean open = true;

        while (open){
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？ (YES)");
            open = !input().next().trim().equalsIgnoreCase("no");
        }
        supermarket.dailyReport();
    }
}

class ShoppingTask{
    private Shopman shopman;
    public ShoppingTask(Shopman shopman){this.shopman = shopman;}

    public void executeTask(){
        Customer customer = createCustomer(true);
        shopman.serveCustomer(customer);
    }
}
