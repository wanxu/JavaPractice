package java_basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *ͨ��(Channel)������Դ�ڵ���Ŀ��ڵ�����ӣ���java NIO �и��𻺳����е����ݴ��䣬
 *Channel�����洢���ݣ������Ҫ��������Ͻ��д��䣬ͨ�����൱�����죬���������൱�ڻ�
 *
 *JDK 1.7�е�NIO ��Ը���ͨ���ṩ�˾�̬����open()
 *
 *ͨ��֮������ݴ���
 *transferTo()
 *transferFrom()
 *
 *
 *��ɢ��ۼ�
 *��ɢ��ȡ����ͨ���е����ݷ�ɢ�������������ȥ
 *�ۼ�д��:����������������ݾۼ���ͨ����ȥ
 *
 * @author dxx
 * @version 2017-11-02 ����8:33:05
 */
public class NioChannel {

    //4.��ɢ��ۼ�
    public void run4() throws IOException{
        //1.��ɢ��ȡ
        RandomAccessFile raf1=new RandomAccessFile("1.txt", "rw");
        //��ȡͨ��
        FileChannel channel1 = raf1.getChannel();
        //��������ָ����С�Ļ�����
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //��������������
        ByteBuffer[] bufArr={buf1,buf2};
        //ͨ����ȡ
        channel1.read(bufArr);
        //�л�������Ϊдģʽ
        for (ByteBuffer byteBuffer : bufArr) {
            byteBuffer.flip();
        }
        System.out.println(new String(bufArr[0].array(), 0, bufArr[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(bufArr[1].array(), 0, bufArr[1].limit()));

        //2.�ۼ�д��
        //�ۼ�д�뵽2.txt��
        RandomAccessFile raf2=new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        //������������д��ͨ����
        channel2.write(bufArr);
    }


    //3.ͨ��֮������ݴ��䣬ֱ�ӻ�����
    public void run3() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("e:/01.avi"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("e:/02.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
//      inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
    }

    //2.����ֱ�ӻ���������ļ��ĸ���
    public void run2() throws IOException{
        long start=System.currentTimeMillis();
        //��ȡͨ��
        //��ģʽ
        FileChannel inChannel = FileChannel.open(Paths.get("e:/01.avi"), StandardOpenOption.READ);
        //��дģʽ
        FileChannel outChannel = FileChannel.open(Paths.get("e:/02.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //�ڴ�ӳ���ļ�
        MappedByteBuffer inBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuf = outChannel.map(MapMode.READ_WRITE,0,inChannel.size());

        //�Ի����������ݽ��ж�д����
        byte[] by=new byte[inBuf.limit()];
        inBuf.get(by);
        outBuf.put(by);
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("�ķ�ʱ�䣺"+(end-start));
    }

    //1.����ͨ������ļ��ĸ��ƣ���ֱ�ӻ�������
    public void run() throws IOException{
        long start=System.currentTimeMillis();
        FileInputStream fis=null;
        FileOutputStream fos=null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis=new FileInputStream("e:/01.avi");
            fos=new FileOutputStream("e:/02.avi");
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //����ָ����С�Ļ�����
            ByteBuffer bb = ByteBuffer.allocate(1024);
            //��ͨ���е����ݴ��뻺����,���ʱ��Ļ�������дģʽ
            while(inChannel.read(bb)!=-1){
                //���������л�Ϊ��ģʽ
                bb.flip();
                outChannel.write(bb);
                bb.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fis.close();
            fos.close();
            inChannel.close();
            outChannel.close();
        }
        long end=System.currentTimeMillis();
        System.out.println("�ķ�ʱ�䣺"+(end-start));
    }

    public static void main(String[] args) {
        NioChannel test=new NioChannel();
        try {
            test.run();
            test.run2();
            test.run3();
            test.run4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
