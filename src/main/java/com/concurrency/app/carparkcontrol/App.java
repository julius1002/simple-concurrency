package com.concurrency.app.carparkcontrol;

import com.concurrency.app.carparkcontrol.conditionsync.Arrive;
import com.concurrency.app.carparkcontrol.conditionsync.CarParkControl;
import com.concurrency.app.carparkcontrol.conditionsync.Departure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java Concurrency
 */
public class App {

    public static void main(String[] args) throws IOException {

        CarParkControl cpc = new CarParkControl(2, 4);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        var arrive = new Arrive(cpc);
        var departure = new Departure(cpc);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        while (true) {
            String name = reader.readLine();
            if (name.equals("start")) {
                executor.execute(arrive);
                executor.execute(departure);
            }

            System.out.println(name);
        }
    }
}

