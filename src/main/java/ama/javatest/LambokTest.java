package ama.javatest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LambokTest {

    public static void main(String... args) {
        log.debug((new Person("nobu", "ama")).toString());
    }

}

@Data
@AllArgsConstructor
@ToString
class Person {

    private String lastname;
    private String firstname;
}
