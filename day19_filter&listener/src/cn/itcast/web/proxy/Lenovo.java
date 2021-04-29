package cn.itcast.web.proxy;

/**
 * @author superLin
 * @date 2021-04-29 9:31
 */
public class Lenovo implements SaleComputer {
    @Override
    public void show() {
        System.out.println("展示卖了多少电脑");
    }

    @Override
    public String sale(double money) {
        System.out.println("一共花"+money+"卖了电脑");
        return "联想电脑";
    }
}
