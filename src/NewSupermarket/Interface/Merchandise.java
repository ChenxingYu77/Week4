package NewSupermarket.Interface;

import NewSupermarket.Interface.Category;

public interface Merchandise {
    String getName();

    double getSoldPrice();

    double getPurchasePrice();

    int buy(int count);

    void putBack(int count);

    Category getCatgory();

    int getCount();
}
