package com.hzx.Algorithm.树;

import com.hzx.util.node.HuffmanNode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 基于哈夫曼树的消息传递demo
 */
public class HuffmanChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message (or type 'exit' to quit): ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) break;

            // Calculate frequencies and build Huffman tree
            Map<Character, Integer> frequencies = HuffmanTree.calculateFrequencies(message);
            HuffmanNode<Character> root = HuffmanTree.buildHuffmanTree(frequencies);
            Map<Character, String> codes = HuffmanTree.encode(root, "", new HashMap<>());

            // Send serialized Huffman tree
            String serializedTree = HuffmanTree.serializeHuffmanTree(root);
            ByteBuffer buffer = ByteBuffer.wrap(serializedTree.getBytes());
            client.write(buffer);
            System.out.println("Sent Huffman tree.");

            // Encode message and send it
            StringBuilder encodedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                encodedMessage.append(codes.get(ch));
            }

            buffer = ByteBuffer.wrap(encodedMessage.toString().getBytes());
            client.write(buffer);
            System.out.println("Sent: " + encodedMessage.toString());
        }

        client.close();
        scanner.close();
    }
}
