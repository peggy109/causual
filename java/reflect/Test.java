//package tosky.app.testva;
import java.lang.reflect.Constructor;

public class Test{
    private class PrivateInner{
    }
    public class PublicInner{
    }
    private PrivateInner privateInner = new PrivateInner();
    public PublicInner publicInner = new PublicInner();
    public static void main(String[] args){
        try {
        System.out.println("PublicInner.class = "+PublicInner.class);
        //查看class是否有构造函数
        System.out.println("PublicInner.class.getconstructors().length = "+ PublicInner.class.getConstructors().length);
        //获取第一个构造函数
	Constructor c = PublicInner.class.getConstructors()[0];
        System.out.println("PublicInner.class.getConstructors()[0 = ]"+c);
        //用构造函数初始化内部类
        System.out.println("newInstance() = "+c.newInstance(new Test()));
        } catch (Exception e) {
            System.out.println("e:"+e);
        }
    }
}
