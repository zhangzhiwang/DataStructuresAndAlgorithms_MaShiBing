package junior;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Test extends Thread {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add("a_" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture> cfList = Collections.synchronizedList(new ArrayList<>());
        list.stream().forEach(e -> {
            CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(Thread.currentThread().getName() + " -> e:" + e);
            }, executorService);
            cfList.add(completableFuture);
        });

        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[0])).join();

        System.out.println("ok");

//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        executorService.execute();
    }

//    public void run() {
//
//    }
}
