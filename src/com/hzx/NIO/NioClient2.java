package com.hzx.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClient2 {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6666;

        try (SocketChannel clientChannel = SocketChannel.open()) {
            clientChannel.configureBlocking(false); // 设置为非阻塞模式

            // 尝试连接服务器
            boolean isConnected = clientChannel.connect(new InetSocketAddress(host, port));
            if (!isConnected) {
                // 如果连接没有立即完成，则需要等待连接完成
                System.out.println("正在连接服务端...");
                Selector selector = Selector.open();
                clientChannel.register(selector, SelectionKey.OP_CONNECT);

                // 开始选择循环，等待连接完成
                while (selector.select() > 0) {
                    for (SelectionKey key : selector.selectedKeys()) {
                        if (key.isConnectable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            if (channel.finishConnect()) {
                                System.out.println("已连接服务端 " + host + ":" + port);
                                isConnected = true;
                                break;
                            } else {
                                System.err.println("连接失败");
                                return;
                            }
                        }
                        selector.selectedKeys().remove(key);
                    }
                }
            }

            if (isConnected) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("请输入消息并发送: ");
                    String message = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(message)) {
                        break;
                    }
                    ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                    clientChannel.write(buffer);

                    // 清空缓冲区以便下次写入
                    buffer.clear();
                }
            }

        } catch (IOException e) {
            System.err.println("连接到服务器或发送/接收数据时出错");
            e.printStackTrace();
        }
    }
}