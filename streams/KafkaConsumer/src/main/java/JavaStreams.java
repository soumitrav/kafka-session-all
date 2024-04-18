import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {

    public static void main(String []args) {
        List.of("My name is soumitra", "is Mohan there").stream()
                //.flatMap(s -> Arrays.asList(s.split(" ")))
                .collect(Collectors.toList()).forEach(System.out :: println);
    }
}
