package NewSupermarket.Impl;

import NewSupermarket.Interface.Category;
import NewSupermarket.Interface.Merchandise;
import NewSupermarket.Interface.Supermarket;

import java.util.Map;

public class SimpleSupermarket implements Supermarket {
    private String name = "无名";
    private Merchandise[] all;
    private int[] allCount;
    private double totalMoneyEarn;
    private int customerCount;

    public SimpleSupermarket(Merchandise[] all){
        this.all = all;
        allCount = new int[all.length];
        for (int i = 0; i < all.length; i++) {
            allCount[i] = all[i].getCount();
        }
    }

    @Override
    public Merchandise[] getAllMerchandise() {
        return all;
    }

    @Override
    public Merchandise[] getRandomMerchandiseOfCatgory(Category category) {
        Merchandise[] ret = new Merchandise[5];
        int pos = 0;
        for(Merchandise m:all){
            if(m.getCatgory() == category && Math.random()>0.5 && pos<ret.length-1){
                ret[pos] = m;
                pos++;
            }
        }
        return ret;
    }

    @Override
    public void addEarnedMoney(double moneyEarn) {
        customerCount++;
        this.totalMoneyEarn += moneyEarn;
    }

    @Override
    public void dailyReport() {
        System.out.println("营业额为："+totalMoneyEarn);
        System.out.println("商品售出情况如下：");
        for (int i = 0; i < all.length; i++) {
            if(allCount[i] != all[i].getCount()){
                System.out.println(all[i].getCatgory().name()+"\t"+all[i].getName()
                +"\t"+(allCount[i]-all[i].getCount()));
            }
        }
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}
}
