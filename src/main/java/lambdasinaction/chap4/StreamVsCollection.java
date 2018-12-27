package lambdasinaction.chap4;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.collect(toList());
//        s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);

        t();
    }

    static class Reward {
        private String name;
        private long value;
        private int type;

        Reward(String name,long value, int type) {
            this.name = name;
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return "{'name':" + name + ",'value':" + value + ",'type':" + type + "}";
        }
    }

    public static void t(){


        Supplier<Reward> supplier1 = () -> new Reward("金币5",5L,1);
        Supplier<Reward> supplier2 = () -> new Reward("优惠券",10000L,2);

        List<Reward> list1 = Stream.generate(supplier1).limit(5).collect(toList());
        List<Reward> list2 = Stream.generate(supplier2).limit(5).collect(toList());

        System.out.println(list1);
        System.out.println(list2);
        System.out.println();

    }

    public static void groupBy() {
        Reward reward = new Reward("jin",5L,1);
        Reward reward2 = new Reward("jin",5L,1);
        Reward reward3 = new Reward("jin",5L,1);
        Reward reward4 = new Reward("jin",5L,1);
        Reward reward5 = new Reward("jin",5L,1);
        Reward reward6 = new Reward("jin",5L,1);
    }
}