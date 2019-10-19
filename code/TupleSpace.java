import java.util.concurrent.Future;
import org.apache.commons.collections4.MultiSet;

interface TupleSpace<T extends Tuple, TT extends Template> {
  
  Future<T> read(TT template);
  Future<T> take(TT template);
  Future<T> write(T tuple);
//       vvvvvvvv collection type provided by Apache 
  Future<MultiSet<? extends T>> get();     // Utility primitive
  Future<Integer> getSize();               // Utility primitive
  
  String getName();   // To discriminate among several tuple spaces
}