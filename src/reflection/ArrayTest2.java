package reflection;

import java.lang.reflect.Array;

/**
 * Created by Json Wan on 2017/10/16.
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        /*
        ����һ����ά����
        ����ǰ���������ʱ���ģ���ά����Ҳ��һά����
        ������Ԫ���Ƕ�ά�����һά����
        ��˿�����Ϊarr�ǳ���Ϊ3��һά����
         */
        Object arr= Array.newInstance(String.class, 3, 4, 10);
        //��ȡarr������indexΪ2��Ԫ�أ���Ԫ��Ӧ���Ƕ�ά����
        Object arrObj=Array.get(arr,2);
        //ʹ��ArrayΪ��ά���������Ԫ�ظ�ֵ����ά���������Ԫ����һά����
        //���Դ���Array��set()�����ĵ�����������һά����
        Array.set(arrObj,2,new String[]{
                "���Java����",
                "������Java EE��ҵӦ��ʵս"
        });
        //��ȡarrObj������indexΪ3��Ԫ�أ���Ԫ��Ӧ����һά����
        Object anArr=Array.get(arrObj,3);
        Array.set(anArr,8,"���Android����");
        //��arrǿ������ת��Ϊ��ά����
        String[][][] cast=(String[][][])arr;
        //��ȡcast��ά������ָ��Ԫ�ص�ֵ
        System.out.println(cast[2][3][8]);
        System.out.println(cast[2][2][0]);
        System.out.println(cast[2][2][1]);
    }
}
