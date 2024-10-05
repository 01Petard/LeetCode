package com.hzx.NIO相关;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8888;

        try (SocketChannel clientChannel = SocketChannel.open()) {
            clientChannel.configureBlocking(false); // 设置为非阻塞模式

            // 尝试连接服务器
            boolean isConnected = clientChannel.connect(new InetSocketAddress(host, port));
            if (!isConnected) {
                System.out.println("Failed to connect to the server.");
                return;
            }

            System.out.println("Connected to server at " + host + ":" + port);

            // 发送消息给服务器
            String message = "Hello, server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            clientChannel.write(buffer);

            // 读取服务器返回的消息
            buffer.clear();
            int bytesRead = clientChannel.read(buffer);
            if (bytesRead > 0) {
                buffer.flip();
                byte[] response = new byte[buffer.limit()];
                buffer.get(response);
                System.out.println("Received from server: " + new String(response));
            }

        } catch (IOException e) {
            System.err.println("Error connecting to the server or sending/receiving data.");
            e.printStackTrace();
        }
    }
}