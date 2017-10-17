package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Json Wan on 2017/10/16.
 */
public class GenericTest {
    private Map<String,Integer> score;
    public static void main(String[] args)throws Exception{
        Class<GenericTest> clazz=GenericTest.class;
        Field f=clazz.getDeclaredField("score");
        //ֱ��ʹ��getType()ȡ������ֻ����ͨ���͵ĳ�Ա������Ч
        Class<?> a=f.getType();
        //���潫���������java.util.Map
        System.out.println("score�������ǣ�"+a);
        //��ó�Ա����f�ķ�������
        Type gType=f.getGenericType();
        //���gType������ParameterizedType����
        if(gType instanceof ParameterizedType){
            //ǿ������ת��
            ParameterizedType pType=(ParameterizedType)gType;
            //��ȡԭʼ����
            Type rType=pType.getRawType();
            System.out.println("ԭʼ�����ǣ�"+rType);
            //ȡ�÷������͵ķ��Ͳ���
            Type[] tArgs=pType.getActualTypeArguments();
            System.out.println("������Ϣ�ǣ�");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println("��"+i+"�����������ǣ�"+tArgs[i]);
            }
        }else{
            System.out.println("��ȡ�������ͳ���");
        }
    }
}
