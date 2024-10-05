package com.hzx.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 6666; // 监听的端口
        Selector selector = Selector.open(); // 创建多路复用器

        // 创建服务器套接字通道，并绑定到端口
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.socket().bind(new InetSocketAddress(host, port));
            serverChannel.configureBlocking(false); // 设置为非阻塞模式
            serverChannel.register(selector, SelectionKey.OP_ACCEPT); // 注册到多路复用器上

            System.out.println("正在监听端口: " + port);

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

                        // 打印连接信息
                        System.out.println("响应新连接: " + clientChannel.getRemoteAddress());

                        // 启动新线程处理客户端请求
                        Thread thread = new Thread(() -> {
                            handleClient(clientChannel, selector);
                        });
                        thread.start();
                    } else if (key.isReadable()) { // 如果有数据可读
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        try {
                            readFromClient(clientChannel);
                        } catch (IOException e) {
                            System.err.println("无法读取客户端信息: " + e.getMessage());
                            closeChannelAndKey(clientChannel, key);
                        }
                    }
                    keyIterator.remove(); // 移除已处理的键
                }
            }
        }
    }

    private static void handleClient(SocketChannel clientChannel, Selector selector) {
        try {
            clientChannel.register(selector, SelectionKey.OP_READ); // 注册到多路复用器上
            while (true) {
                // 读取客户端发送的消息
                try {
                    readFromClient(clientChannel);
                } catch (IOException e) {
                    System.err.println("无法读取客户端信息: " + e.getMessage());
                    closeChannelAndKey(clientChannel, clientChannel.keyFor(selector));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromClient(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);
        if (bytesRead > 0) {
            buffer.flip();
            byte[] messageBytes = new byte[buffer.limit()];
            buffer.get(messageBytes);
            String message = new String(messageBytes).trim();
            System.out.println("收到客户端" + clientChannel.getRemoteAddress() + "消息: " + message);
        } else if (bytesRead == -1) {
            System.out.println("客户端失去连接: " + clientChannel.getRemoteAddress());
            throw new IOException("客户端失去连接");
        }
    }

    private static void closeChannelAndKey(SocketChannel clientChannel, SelectionKey key) throws IOException {
        if (clientChannel != null) {
            try {
                // 获取远程地址，打印断开连接信息
                System.out.println("连接关闭: " + clientChannel.getRemoteAddress());
            } catch (ClosedChannelException e) {
                // 记录日志或采取其他措施
                System.err.println("通道已关闭: " + e.getMessage());
            }

            if (clientChannel.isOpen()) {
                clientChannel.close();
            }
            if (key != null && key.isValid()) {
                key.cancel();
            }
        }
    }
}