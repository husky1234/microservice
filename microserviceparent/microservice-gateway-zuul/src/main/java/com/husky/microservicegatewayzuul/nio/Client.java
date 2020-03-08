package com.husky.microservicegatewayzuul.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8089));
        channel.configureBlocking(false);
        FileChannel open = FileChannel.open(Paths.get("D:\\compare.txt"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (open.read(byteBuffer) != -1){
            byteBuffer.flip();
            channel.write(byteBuffer);
            byteBuffer.clear();
        }
        channel.close();
        open.close();
    }
}
