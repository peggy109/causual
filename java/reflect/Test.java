//package tosky.app.testva;
import java.lang.reflect.Constructor;

public class Test{
    private class PrivateInner{
    }
    public class PublicInner{
    }
    private PrivateInner privateInner = new PrivateInner();
    private PublicInner publicInner = new PublicInner();
    void accessToPublicInner() {
        try {
        System.out.println("PublicInner.class = "+Test.PublicInner.class);
        //查看class是否有构造函数
        System.out.println("PublicInner.class.getconstructors().length = "+ Test.PublicInner.class.getConstructors().length);
	for (int i=0;i<Test.PublicInner.class.getConstructors().length;i++) {
        System.out.println("PublicInner.class.getConstructors()["+i+"] = "+Test.PublicInner.class.getConstructors()[i]);
	}
        //获取第一个构造函数
        Constructor c = Test.PublicInner.class.getConstructors()[0];
        System.out.println("PublicInner.class.getConstructors()[0] = "+c);
        //用构造函数初始化内部类
        System.out.println("newInstance() = "+c.newInstance(new Test()));
        } catch (Exception e) {
            System.out.println("e:"+e);
       }
    }
    void accessToPrivateInner() {
        try {
        System.out.println("PrivateInner.class = "+Test.PrivateInner.class);
        //查看class是否有构造函数
        System.out.println("PrivateInner.class.getconstructors().length = "+ Test.PrivateInner.class.getConstructors().length);
        System.out.println("PrivateInner.class.getDeclaredconstructors().length = "+ Test.PrivateInner.class.getDeclaredConstructors().length);
	for (int i=0;i<Test.PrivateInner.class.getDeclaredConstructors().length;i++) {
        System.out.println("PrivateInner.class.getDeclaredConstructors()["+i+"] = "+Test.PrivateInner.class.getDeclaredConstructors()[i]);
	}
        //获取第一个构造函数
        Constructor c = Test.PrivateInner.class.getDeclaredConstructors()[0];
        //用构造函数初始化内部i类
	c.setAccessible(true);
        System.out.println("newInstance() = "+c.newInstance(new Test()));
        } catch (Exception e) {
            System.out.println("e:"+e);
       }
    }
    public static void main(String[] args){
	Test daemon = new Test();
	daemon.accessToPublicInner();
        daemon.accessToPrivateInner();
    }
}
