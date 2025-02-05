import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTest {
    public static void main(String args[]){

    Consumer<Integer> consumer = (value) -> {
        if( value%2 == 0)
          System.out.println(value + " odd" );
        else {
            System.out.println(value + " even " );
        }
    };
    consumer.accept(15);

        List<Integer> numbers= new ArrayList<>();
        Predicate<List> predicate= new PredicateImpl<>();
        System.out.println( predicate.test(numbers));
  }
}
class PredicateImpl<T extends List<T>> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        if ( t.size() < 10 ) {
            return false;
        }
        return true;
    }

}