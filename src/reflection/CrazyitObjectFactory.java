package reflection;

import javax.swing.*;
import java.util.Date;

/**
 * Created by Json Wan on 2017/10/16.
 */
public class CrazyitObjectFactory {
    public static Object getInstance(String clsName){
        try{
            //����ָ�����Ӧ��Class����
            Class cls=Class.forName(clsName);
            //����ʹ�ø�Class���󴴽���ʵ��
            return cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Date d=(Date)CrazyitObjectFactory.getInstance("java.util.Date");
        JFrame f=(JFrame)CrazyitObjectFactory.getInstance("java.util.Date");
    }
}
