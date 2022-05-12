package com.concurrency.app.carparkcontrol;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HashMapExample {

    private static Map<String, String> map = new ConcurrentHashMap<>(); // monitor


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);


        executor.execute(() -> {
            while (true) {
                System.out.println("values : " + map.entrySet());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("putting bla");
                map.put("bla", "lol");

            }
        });

        executor.execute(() -> {
            System.out.println("putting xd and bla");
            while (true) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                map.put("bla", "lol");
                map.put("xd", "ldlas");
            }
        });

        executor.execute(() -> {
            while (true) {
                System.out.println("removing xd and bla");

                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.remove("bla");
                map.remove("xd");

            }
        });
    }

}
