package ama.javatest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Java8StreamAPI implements TestIF {

    public static void main(String[] args) {
        new Java8StreamAPI().print("hoge");
        List<TestPerson> list = Arrays.asList(
                TestPerson.getInstance("yue", 4, 12),
                TestPerson.getInstance("atu", 6, 21),
                TestPerson.getInstance("nobu", 36, 58)
        );
        //mapで名前だけのListに変換してリスト化
        //あまり意味が無いか
        log.debug(
                list.stream()
                .map(name -> name.getName())
                .collect(Collectors.toList())
                .toString()
        );
        //name=yueだけを抽出
        log.debug(
                list.stream()
                .filter(person -> person.getName().equals("yue"))
                .collect(Collectors.toList())
                .toString()
        );
        //ageで降順ソート
        log.debug(
                list.stream()
                .sorted((w1, w2) -> w2.getWeight() - w1.getWeight())
                .collect(Collectors.toList())
                .toString()
        );
        //最大年齢
        //1次元配列？っていうのかな年齢だけにしないとmaxが取れない
        log.debug(
                list.stream()
                        .map(person->person.getAge())
                        .max(Comparator.naturalOrder())
                        .toString()
        );

        //こんな事も
        Stream<String> stream1 = Stream.generate(() -> "あ");
        Stream<Integer> stream2 = Stream.iterate(1, i -> ++i);
        stream1.limit(3).forEach(System.out::println);
        stream2.limit(3).forEach(value -> System.out.println(value));
    }
}

@AllArgsConstructor
@ToString
@Data
class TestPerson {

    private String name;
    private int age;
    private int weight;

    static TestPerson getInstance(String name, int age, int weight) {
        return new TestPerson(name, age, weight);
    }
}

interface TestIF {

    default void print(String arg) {
        System.out.println(arg);
    }
}
