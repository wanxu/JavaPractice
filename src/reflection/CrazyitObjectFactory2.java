package reflection;

import javax.swing.*;
import java.util.Date;

/**
 * Created by Json Wan on 2017/10/16.
 */
public class CrazyitObjectFactory2 {
    public static <T> T getInstance(Class<T> cls){
        try{
            //����ʹ�ø�Class���󴴽���ʵ��
            return cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //��ȡʵ������������ת��
        Date d= CrazyitObjectFactory2.getInstance(java.util.Date.class);
        JFrame f=CrazyitObjectFactory2.getInstance(javax.swing.JFrame.class);
    }
}
