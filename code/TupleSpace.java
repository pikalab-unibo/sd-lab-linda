interface TupleSpace<T extends Tuple, TT extends Template> {
  
  CompletableFuture<T> rd(TT template);
  CompletableFuture<T> in(TT template);
  CompletableFuture<T> out(T tuple);
 
  CompletableFuture<MultiSet<? extends T>> get(); // Utility prim.
  //                ^^^^^^^^ collection type provided by Apache

  CompletableFuture<Integer> count(); // Utility primitive
  
  String getName(); // To discriminate among several tuple spaces
}