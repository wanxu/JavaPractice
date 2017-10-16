package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Json Wan on 2017/10/16.
 */
interface PersonInterface{
    void walk();
    void sayHello(String name);
}
class MyInvokationHandler implements InvocationHandler{

    /*
    ִ�ж�̬�����������з���ʱ�����ᱻ�滻��ִ�����µ�invoke����
    ���У�
    proxy������̬�������
    method����������ִ�еķ���
    args���������Ŀ�귽��ʱ�����ʵ��
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----����ִ�еķ�����"+method);
        if(args!=null){
            System.out.println("������ִ�и÷���ʱ�����ʵ��Ϊ��");
            for(Object val:args){
                System.out.println(val);
            }
        }else{
            System.out.println("���ø÷���û��ʵ�Σ�");
        }
        return null;
    }
}
public class ProxyTest{
    public static void main(String[] args)throws Exception{
        //����һ��InvocationHandler����
        InvocationHandler handler=new MyInvokationHandler();
        //ʹ��ָ����InvocationHandler������һ����̬�������
        PersonInterface p= (PersonInterface) Proxy.newProxyInstance(PersonInterface.class.getClassLoader(),new Class[]{PersonInterface.class},handler);
        //���ö�̬��������walk()��sayHello()����
        p.walk();
        p.sayHello("wanxu");
    }
}
