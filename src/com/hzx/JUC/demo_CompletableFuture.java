package com.hzx.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class demo_CompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return "cf1";
        });

        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return "cf3";
        });

        // cf1 完成后启动 cf2
        CompletableFuture<String> cf2 = cf1.thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return "cf2";
        }));

        // cf2 完成后等待 cf3 完成
        CompletableFuture<Void> combinedFuture = cf2.thenCompose(result -> cf3.thenApply(r -> null));

        // 等待所有任务完成
        combinedFuture.get();

        System.out.println(cf1.get());
        System.out.println(cf2.get());
        System.out.println(cf3.get());

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");

        // 执行后续代码
        System.out.println("All tasks completed.");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> combinedFuture2 = future1.thenCombine(future2, (result1, result2) -> result1 + ", " + result2);
        combinedFuture2.thenAccept(System.out::println);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello").thenCompose(result -> CompletableFuture.supplyAsync(() -> result + ", World"));
        future.thenAccept(System.out::println);


        CompletableFuture<Object> future6 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong");
        }).exceptionally(ex -> "Exception occurred: " + ex.getMessage());
        future6.thenAccept(System.out::println);

        CompletableFuture<Object> future7 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong");
        }).handle((result, ex) -> {
            if (ex != null) {
                return ex.getMessage();
            }
            return result;

        });
        future7.thenAccept(System.out::println);
    }
}