package remote_executing_system;

/**
 * Created by Json Wan on 2018/11/28.
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        //��ȡ��ǰ����������
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte){
        //Ŀ�ģ����������е�protected����defineClass
        return defineClass(null,classByte,0,classByte.length);
    }
}
