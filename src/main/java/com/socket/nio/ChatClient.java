package com.socket.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChatClient implements Runnable{

    private Selector selector;

    private SocketChannel ss;

    /*缓冲区大小*/
    private  int BLOCK = 4096;
    /*接受数据缓冲区*/
    private  ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
    /*发送数据缓冲区*/
    private  ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);


    public static void main(String[] args) {
        try{
           ChatClient chatClient =  new ChatClient();
            //初始化
            chatClient.initChatClient();
            //启动
            new Thread(chatClient).start();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            chatClient.sendMsg();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void sendMsg() throws Exception{
        System.out.println("尬聊开始了，Hi");
        String msg = "尬聊开始了，Hi";
        ss.write(ByteBuffer.wrap(msg.getBytes()));

    }

    private  void initChatClient() throws Exception{
        selector = Selector.open();
        ss = SocketChannel.open();
        ss.connect(new InetSocketAddress(9999));
        ss.configureBlocking(false);
        ss.register(selector, SelectionKey.OP_READ);
        System.out.println("客户端在"+9999+"端口启动成功");
    }


    @Override
    public void run(){
        while (true){
            try{
                if(selector.select()>0){ //准备就绪channle 若没有，阻塞
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while(iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        if(key.isReadable()){
                            readMsg(key);
                        }
                        if(key.isWritable()){
                            writeMsg(key);
                        }
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    /**
     * 读取消息
     * @param key
     */
    private void readMsg(SelectionKey key) throws Exception{

        SocketChannel socketChannel = (SocketChannel) key.channel();

        int lenth = -1;
        receivebuffer.clear();
        socketChannel.read(receivebuffer);

        String msg = new String(receivebuffer.array(),"UTF-8");
        System.out.println("-->客户端接收到的数据:"+msg);
        socketChannel.register(this.selector,SelectionKey.OP_WRITE);
    }

    /**
     * 发送消息
     */

    public void writeMsg(SelectionKey key)throws Exception{
        System.out.println("请输入客户端向服务端发送数据-->:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        sendbuffer.clear();
        socketChannel.write(sendbuffer.wrap(msg.getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

}
