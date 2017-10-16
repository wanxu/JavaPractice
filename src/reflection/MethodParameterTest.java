package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Created by Json Wan on 2017/10/16.
 */
class Test{
    public void replace(String str,List<String> list){}
}
public class MethodParameterTest {
    public static void main(String[] args) throws Exception{
        //��ȡString����
        Class<Test> clazz=Test.class;
        //��ȡString��Ĵ�����������replace��������
        Method replace=clazz.getMethod("replace",String.class,List.class);
        //��ȡָ�������Ĳ�������
        System.out.println("replace��������������"+replace.getParameterCount());
        //��ȡreplace�����в�����Ϣ
        Parameter[] parameters=replace.getParameters();
        int index=1;
        //�������в���
        for(Parameter p:parameters){
            if(p.isNamePresent()){
                System.out.println("---��"+index++ +"��������Ϣ---");
                System.out.println("��������"+p.getName());
                System.out.println("�β����ͣ�"+p.getType());
                System.out.println("�������ͣ�"+p.getParameterizedType());
            }
        }
    }
}
