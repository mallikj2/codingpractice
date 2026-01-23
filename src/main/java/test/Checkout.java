package test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Checkout {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jerry", "Spike");
        names.stream().map(String::toUpperCase).sorted().forEach(System.out::print);

        Optional<String> opt = Optional.ofNullable(null);
        System.out.println(opt.orElse("fallback"));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println(numbers.stream().reduce(0, Integer::sum));


    }
}
