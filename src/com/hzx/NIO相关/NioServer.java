package com.hzx.NIO相关;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8888; // 监听的端口
        Selector selector = Selector.open(); // 创建多路复用器

        // 创建服务器套接字通道，并绑定到端口
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.socket().bind(new InetSocketAddress(host, port));
            serverChannel.configureBlocking(false); // 设置为非阻塞模式
            serverChannel.register(selector, SelectionKey.OP_ACCEPT); // 注册到多路复用器上

            System.out.println("Server is listening on port " + port);

            while (true) {
                if (selector.select() == 0) { // 没有可处理的事件发生
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()) { // 如果有新的连接请求
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel clientChannel = ssc.accept();
                        clientChannel.configureBlocking(false); // 设置为非阻塞模式
                        clientChannel.register(selector, SelectionKey.OP_READ); // 注册到多路复用器上

                        // 启动新线程处理客户端请求
                        Thread thread = new Thread(() -> {
                            handleClient(clientChannel);
                        });
                        thread.start();
                    }
                    keyIterator.remove(); // 移除已处理的键
                }
            }
        }
    }

    private static void handleClient(SocketChannel clientChannel) {
        // 这里可以编写处理客户端请求的逻辑
        System.out.println("Handling client on thread: " + Thread.currentThread().getName());

        // 示例：简单地关闭连接
        try {
            clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
