package java_basics;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * ����NIO
 *
 * @author dxx
 * @version 2017-11-02 ����9:36:08
 */
public class NioBlock2 {
    //1.����ͨ�ſͻ���
    public void client() throws IOException{
        //��ȡͨ��
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        FileChannel fChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        //����ָ����С�Ļ�����
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //��ȡ�����ļ��������͵��ͻ���
        while(fChannel.read(bb)!=-1){
            //��������ת��Ϊдģʽ
            bb.flip();
            socketChannel.write(bb);
            bb.clear();
        }
        //�����ղ���������������ʱ��ǿ�ƹر�ͨ��(����ʽ����������)
        socketChannel.shutdownOutput();
        //���ܷ������˵ķ���
        int len=0;
        while((len=socketChannel.read(bb))!=-1){
            bb.flip();
            System.out.println(new String(bb.array(),0,len));
            bb.clear();
        }
        //�ر�ͨ��
        socketChannel.close();
        fChannel.close();
    }

    //2.�����
    public void server() throws IOException{
        //��ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel fChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //������
        ssChannel.bind(new InetSocketAddress(8888));
        //��ȡ�ͻ������ӵ�ͨ��
        SocketChannel accept = ssChannel.accept();
        //����ָ����С�Ļ�����
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //��ȡ�����ļ��������͵��ͻ���
        while(accept.read(bb)!=-1){
            //��������ת��Ϊдģʽ
            bb.flip();
            fChannel.write(bb);
            bb.clear();
        }
        //���ͷ������ͻ���
        bb.put("�������ݳɹ�".getBytes());
        bb.flip();
        accept.write(bb);

        //�ر�ͨ��
        ssChannel.close();
        fChannel.close();
    }

    public static void main(String[] args) {
        NioBlock2 test=new NioBlock2();
        try {
            test.server();
            test.client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
