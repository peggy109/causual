//package tosky.app.testva;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestOuter{
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
	Class<?> clazzTest = Class.forName("Test");
        System.out.println("Class.forName(Test) = "+clazzTest);
	Field fieldPrivateInner = clazzTest.getDeclaredField("privateInner");
        System.out.println("fieldPrivateInner = "+fieldPrivateInner);
        System.out.println("before setAccessible(true),fieldPrivateInner.getType().getName() = "+fieldPrivateInner.getType().getName());
	fieldPrivateInner.setAccessible(true);
        System.out.println("before setAccessible(true),fieldPrivateInner.getType().getName() = "+fieldPrivateInner.getType().getName());

	Class<?> clazzPrivateInner = Class.forName(fieldPrivateInner.getType().getName());
        System.out.println("Class.orName("+fieldPrivateInner.getType().getName()+") = "+clazzPrivateInner);

        //查看class是否有构造函数
        System.out.println("clazzPrivateInner.getconstructors().length = "+ clazzPrivateInner.getConstructors().length);
        System.out.println("clazzPrivateInner.getDeclaredconstructors().length = "+ clazzPrivateInner.getDeclaredConstructors().length);
	for (int i=0;i<clazzPrivateInner.getDeclaredConstructors().length;i++) {
        System.out.println("clazzPrivateInner.getDeclaredConstructors()["+i+"] = "+clazzPrivateInner.getDeclaredConstructors()[i]);
	}
        //获取第一个构造函数
        Constructor c = clazzPrivateInner.getDeclaredConstructors()[0];
        //用构造函数初始化内部类
	c.setAccessible(true);
        System.out.println("newInstance() = "+c.newInstance(new Test()));
        } catch (Exception e) {
            System.out.println("e:"+e);
       }
    }
    public static void main(String[] args){
	TestOuter daemon = new TestOuter();
	daemon.accessToPublicInner();
        daemon.accessToPrivateInner();
    }
}
