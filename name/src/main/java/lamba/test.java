package lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linlang
 * @date 2019/3/11
 */
public class test {

    private static void testThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 ");
            }
        }).start();

        new Thread( () -> System.out.println("In Java8!") ).start();
    }

    private static void testList(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);

    }

    //reduce将列表中的元素累加起来
    //map可以对列表中的每个元素进行某种操作
    private static void testReduce(){
        List<Integer> costBeforeTax =Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream()
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Total : " + bill);



    }

    public static void testfilter(){
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");

        List<String> filtered = G7.stream().filter(x -> x.length()> 2)
                .collect(Collectors.toList());



        System.out.printf("Original List : %s, filtered list : %s %n",
                G7, filtered);



    }


    public static void main(String[] args) {
        testReduce();
    }
}
