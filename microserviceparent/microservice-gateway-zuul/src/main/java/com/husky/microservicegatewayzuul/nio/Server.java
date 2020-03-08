package com.husky.microservicegatewayzuul.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8089));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(selector.select() > 0 ){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    SocketChannel channel = socketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);
                }else if (next.isReadable()){
                    SocketChannel channel = (SocketChannel) next.channel();
                    FileChannel out = FileChannel.open(Paths.get("D:\\1.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (channel.read(byteBuffer) != -1){
                        byteBuffer.flip();
                        out.write(byteBuffer);
                        byteBuffer.clear();
                    }
                }
            }
            iterator.remove();
        }
    }
}
