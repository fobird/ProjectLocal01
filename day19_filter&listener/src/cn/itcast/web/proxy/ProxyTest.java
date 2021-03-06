package cn.itcast.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author superLin
 * @date 2021-04-29 9:33
 */
public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        /*
        lenovo.sale(8000);
        lenovo.show();*/

        //2.动态代理增强lenovo对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer obj = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                参数：
                    1. proxy:代理对象
                    2. method：代理对象调用的方法，被封装为的对象
                    3. args:代理对象调用的方法时，传递的实际参数
         */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断是否是sale方法
                        if (method.getName().equals("sale")) {
                            //1.增强参数
                            double money = (Double) args[0] * 0.85;
                            System.out.println("專場接送");
                            //使用真实对象调用该方法
                            String obj = (String) method.invoke(lenovo, money);
                            System.out.println("送貨上門");
                            //2.增强返回值
                            return obj + "+鼠标垫";
                        } else {
                            Object obj = method.invoke(lenovo, args);
                            return obj;
                        }
                       /* System.out.println("method.getName() = " + method.getName());
                        System.out.println("args = " + args);*/

                    }
                });
        //obj.show();
        String result = obj.sale(1000);
        System.out.println("result = " + result);

    }
}
