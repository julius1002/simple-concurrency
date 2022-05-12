package com.concurrency.app.carparkcontrol.functions;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Person p = new Person();
        p.firstName = "Julius";
        p.lastName = "Platon";
        p.street = "Ringstraße 10";
        p.streetNo = 10L;
        p.weight = 100L;
        Function<Person, Long> getWeight = person -> person.weight;

        Function<Long, Integer> getInt = Long::intValue;

        BiFunction<Integer, Integer, Integer> sum = Integer::sum;


        // Composition or pipeing
        System.out.println(Stream.of(p, p, p).map(getWeight.andThen(getInt))
                .reduce(Integer::sum)
                .get());


        // Pure Composition/ function fusion
        System.out.println(Stream.of(p, p, p).map(getInt.compose(getWeight))
                .reduce(Integer::sum)
                .get());

        // Mapping, memory inefficient
        var res = Stream.of(p, p, p)
                .map(getWeight)
                .map(Long::intValue)
                .reduce(Integer::sum)
                .get();

        System.out.println(res);
    }

    static class Person {
        public String firstName;
        public String lastName;
        public String street;
        public Long streetNo;
        public Long weight;
    }
}
