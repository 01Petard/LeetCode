package com.hzx.Algorithm.树;


import com.hzx.util.node.HuffmanNode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 基于哈夫曼树的消息传递demo
 */
public class HuffmanChatServer {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(PORT));
        System.out.println("Server started, waiting for clients...");

        while (true) {
            SocketChannel client = serverSocket.accept();
            System.out.println("Client connected: " + client.getRemoteAddress());
            new Thread(() -> handleClient(client)).start();
        }
    }

    private static void handleClient(SocketChannel client) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            HuffmanNode<Character> root = null;

            while (true) {
                buffer.clear();
                int bytesRead = client.read(buffer);
                if (bytesRead == -1) break; // Connection closed
                buffer.flip();

                String received = new String(buffer.array(), 0, buffer.limit());

                // If the tree hasn't been received yet, parse it
                if (root == null) {
                    root = HuffmanTree.deserializeHuffmanTree(received);
                    System.out.println("Received Huffman tree.");
                } else {
                    String decodedMessage = HuffmanTree.decode(root, received);
                    System.out.println("Decoded: " + decodedMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
