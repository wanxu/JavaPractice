package java_basics;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * ������NIO
 *
 *һ��ʹ��NIO�������ͨ��
 *1.ͨ����Channel��:��������
 *2.��������Buffer��:�������ݵĴ�ȡ
 *3.ѡ������Selector��:���ڼ��IO���
 *
 * @author dxx
 * @version 2017-11-05 ����10:42:18
 */
public class NioNotBlock {
    //�ͻ���
    public void client() throws IOException{
        //1.��ȡͨ��
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        //2.�л�Ϊ������ģʽ
        sChannel.configureBlocking(false);
        //3.����ָ����С�Ļ�����
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //4.�������ݵ��ͻ���(ʵʱʱ��+����¼��)
        Scanner sc=new Scanner(System.in);
        String[] nameArr={"Kobe","James","Iverson","Duncan","Curry","Harden"};
        Random rand = new Random();
        int i = rand.nextInt(5);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        while(sc.hasNext()){
            String str = sc.next();
            bb.put((nameArr[i]+"  "+date+"\n"+str).getBytes());
            bb.flip();
            sChannel.write(bb);
            bb.clear();
        }
        //5.�ر�ͨ��
        sChannel.close();
    }

    //�����
    public void server() throws IOException{
        //1.��ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.�л�Ϊ������ģʽ
        ssChannel.configureBlocking(false);
        //3.������
        ssChannel.bind(new InetSocketAddress(8888));
        //4.��ȡѡ����
        Selector selector=Selector.open();
        //5.��ͨ��ע�ᵽѡ������,ָ�������������¼���
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.��ѯ��ȡѡ�������Ѿ���׼�����������¼�
        while(selector.select()>0){
            //7.��ȡ��ǰѡ����������ע��ġ�ѡ������Ѿ����ļ����¼�����
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while(it.hasNext()){
                //8.��ȡ׼���������¼�
                SelectionKey sk = it.next();
                //9.�ж���ʲô�¼�׼������
                if(sk.isAcceptable()){
                    //10.���ǽ��վ��������ȡ�ͻ�������
                    SocketChannel clientCh = ssChannel.accept();
                    //11.�л�������ģʽ
                    clientCh.configureBlocking(false);
                    //12.����ͨ��ע�ᵽѡ����
                    clientCh.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //13.��ȡ��ǰѡ�����ϡ�����������ͨ��
                    SocketChannel rChannel=(SocketChannel) sk.channel();
                    //14.��ȡ����
                    ByteBuffer bb = ByteBuffer.allocate(1024);
                    int len=0;
                    while((len=rChannel.read(bb))>0){
                        bb.flip();
                        System.out.println(new String(bb.array(),0,len));
                        bb.clear();
                    }
                }
                //15.ȡ��ѡ��� SelectionKey
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        NioNotBlock test=new NioNotBlock();
        try {
            test.server();
            test.client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
