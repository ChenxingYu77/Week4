package NewSupermarket.Interface;

import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.Merchandise;

public interface Supermarket {
    Merchandise[] getAllMerchandise();

    Merchandise[] getRandomMerchandiseOfCatgory(Category category);

    void addEarnedMoney(double earnedMoney);

    void dailyReport();
}
