package reflection;

import java.lang.reflect.Array;

/**
 * Created by Json Wan on 2017/10/16.
 */
public class CrazyitArray {
    //��Array��newInstance�������а�װ
    @SuppressWarnings("unchecked")
    public static <T> T[] newInstance(Class<T> componentType,int length){
        return (T[]) Array.newInstance(componentType, length);
    }

    public static void main(String[] args) {
        //ʹ��CrazyitArray��newInstance()����һά����
        String[] arr=CrazyitArray.newInstance(String.class,10);
        //ʹ��CrazyitArray��newInstance()������ά����
        //����������£�ֻҪ��������Ԫ�ص�������int[]����
        int[][] intArr=CrazyitArray.newInstance(int[].class,5);
        arr[5]="���Java����";
        //intArr�Ƕ�ά���飬��ʼ��������ĵڶ�������Ԫ��
        //��ά�����Ԫ�ر�����һά����
        intArr[1]=new int[]{23,12};
        System.out.println(arr[5]);
        System.out.println(intArr[1][1]);
    }
}
