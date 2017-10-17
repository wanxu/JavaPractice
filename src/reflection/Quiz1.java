package reflection;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * ��Ŀ������һ�������࣬�ù������ṩһ��eval()������ʵ��JavaScript��eval()�����Ĺ��ܡ������Զ�̬����һ�л���г�����롣����eval("System.out.println(\"aa\")"),�����aa��
 * Created by Json Wan on 2017/10/17.
 */
class MyClassLoader extends ClassLoader {
    public Class<?> loadMyClass(String className, byte[] raw, int off, int len) {
        return defineClass(className, raw, off, len);
    }
}

public class Quiz1 {
    //��ȡһ���ļ�������
    private static byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try (
                FileInputStream fin = new FileInputStream(file);
        ) {
            //һ�ζ�ȡClass�ļ���ȫ������������
            int r = fin.read(raw);
            if (r != len) throw new IOException("�޷���ȡȫ���ļ���" + r + " != " + len);
            return raw;
        }
    }

    public static void eval(String code) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String tempClassName = "TempClazz";
        File tempFile = new File(tempClassName + ".java");
        File classFile = new File(tempClassName + ".class");
        //0.������
        if (classFile.exists()) {
            classFile.delete();
        }
        //1.����һ�����д������
        //1.1д�ļ�ǰ�벿��
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
        bw.write("public class TempClazz{" + "\n");
        bw.write("    public static void main(String[] args){" + "\n");
        bw.write("        System.out.println(args[0]);" + "\n");
        //2.������������main��������
        bw.write("        "+code+"\n");
        //1.2д�ļ���벿��
        bw.write("    }" + "\n");
        bw.write("}" + "\n");
        //3.���ɴ����ļ�
        bw.flush();
        bw.close();
        //4.��Runtime������ļ�����ȡ�ֽ���class�ļ�
        Process process = Runtime.getRuntime().exec("javac TempClazz.java");
        try {
            //�����̶߳��ȴ�����߳����
            process.waitFor();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("������̷���ֵΪ��" + process.exitValue());
        //5.����class�ļ��õ�Class����
        if (!classFile.exists()) {
            System.out.println("������ʱ�ļ�ʧ�ܣ�");
            return;
        }
        Class tempClass = null;
        try {
            //��Class�ļ��Ķ��������ݶ�������
            byte[] raw = getBytes(classFile.getName());
            //����ClassLoader��defineClass����������������ת����Class����
            MyClassLoader classLoader = new MyClassLoader();
            tempClass = classLoader.loadMyClass(tempClassName, raw, 0, raw.length);
        } catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        //6.ɾ����ʱ�ļ���class�ļ�
        //tempFile.delete();
        //classFile.delete();
        //6.�������main����
        Method method = tempClass.getMethod("main",(new String[0]).getClass());
        method.invoke(tempClass.newInstance(),new Object[]{new String[]{"hello"}});
    }

    public static void main(String[] args) throws Exception {
        //System.out.println((new String[0]).getClass().getName());
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("������Ҫִ�еĴ��룺");
            String code=scanner.nextLine();
//            eval("System.out.println(\"Hello World!\");");
            eval(code);
        }
    }
}
