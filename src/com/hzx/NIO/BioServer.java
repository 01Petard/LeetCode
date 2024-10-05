package com.hzx.NIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName(SERVER_ADDRESS))) {
            System.out.println("启动服务，正在监听: " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("响应客户端连接: " + socket);
                es.submit(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    record ClientHandler(Socket clientSocket) implements Runnable {

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("收到客户端" + clientSocket.getRemoteSocketAddress() + "消息: " + message);
                    out.println("收到客户端" + clientSocket.getRemoteSocketAddress() + "消息: " + message);
                }
            } catch (IOException e) {
                System.err.println("运行时处理客户端信息异常: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("关闭时处理客户端信息异常: " + e.getMessage());
                }
            }
        }
    }

}



