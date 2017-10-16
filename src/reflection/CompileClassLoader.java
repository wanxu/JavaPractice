package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Json Wan on 2017/10/13.
 */
public class CompileClassLoader extends ClassLoader {
    //��ȡһ���ļ�������
    private byte[] getBytes(String fileName) throws IOException{
        File file=new File(fileName);
        long len=file.length();
        byte[] raw=new byte[(int)len];
        try(
                FileInputStream fin=new FileInputStream(file);
                )
        {
            //һ�ζ�ȡClass�ļ���ȫ������������
            int r=fin.read(raw);
            if(r!=len)throw new IOException("�޷���ȡȫ���ļ���"+r+" != "+len);
            return raw;
        }
    }
    //�������ָ��Java�ļ��ķ���
    private boolean compile(String javaFile)throws IOException{
        System.out.println("CompileClassLoader:���ڱ���"+javaFile+"...");
        //����ϵͳ��javac����
        Process p=Runtime.getRuntime().exec("javac "+javaFile);
        try{
            //�����̶߳��ȴ�����߳����
            p.waitFor();
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
        //��ȡjava�̵߳��˳�ֵ
        int ret=p.exitValue();
        //���ر����Ƿ�ɹ�
        return ret==0;
    }
    //��дClassLoader��findClass����
    protected Class<?> findClass(String name)throws ClassNotFoundException{
        Class clazz=null;
        //����·���еĵ㣨.���滻��б�ߣ�/��
        String fileStub=name.replace(".","/");
        String javaFileName=fileStub+".java";
        String classFileName=fileStub+".class";
        File javaFile=new File(javaFileName);
        File classFile=new File(classFileName);
        //��ָ��javaԴ�ļ����ڣ���class�ļ������ڣ�����javaԴ�ļ����޸�ʱ���Class�ļ����޸�ʱ�����ʱ�����±���
        if(javaFile.exists()&&(!classFile.exists())||javaFile.lastModified()>classFile.lastModified()){
            try{
                //�������ʧ�ܣ����߸�Class�ļ�������
                if(!compile(javaFileName)||!classFile.exists()){
                    throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        //���class�ļ����ڣ�ϵͳ���𽫸��ļ�ת����Class����
        if(classFile.exists()){
            try{
                //��Class�ļ��Ķ��������ݶ�������
                byte[] raw=getBytes(classFileName);
                //����ClassLoader��defineClass����������������ת����Class����
                clazz=defineClass(name,raw,0,raw.length);
            }catch(IOException ie){
                ie.printStackTrace();
            }
        }
        //���clazzΪnull����������ʧ�ܣ����׳��쳣
        if(clazz==null){
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }
    //main����
    public static void main(String[] args)throws Exception{
        //������иó���ʱû�в�������û��Ŀ����
        if(args.length<1){
            System.out.println("ȱ��Ŀ���࣬�밴���¸�ʽ����JavaԴ�ļ���");
            System.out.println("java CompileClassLoader ClassName");
        }
        //��һ����������Ҫ���е���
        String progClass=args[0];
        //ʣ�µĲ�����Ϊ����Ŀ����ʱ�Ĳ���
        //����Щ�������Ƶ�һ���µ�������
        String[] progArgs=new String[args.length-1];
        System.arraycopy(args,1,progArgs,0,progArgs.length);
        CompileClassLoader ccl=new CompileClassLoader();
        //������Ҫ���е���
        Class<?> clazz=ccl.loadClass(progClass);
        //��ȡ��Ҫ���е����������
        Method main=clazz.getMethod("main",(new String[0]).getClass());
        Object argsArray[]={progArgs};
        main.invoke(null,argsArray);
    }
}
