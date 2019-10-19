class TextTupleSpace 
     implements TupleSpace<StringTuple, RegexTemplate> {

  private String name;
  private ExecutorService executor;
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();
  
  public TextTupleSpace(String name, ExecutorService executor) {
    this.name = Objects.requireNonNull(name);
    this.executor = Objects.requireNonNull(executor);
  }
  
  public Future<StringTuple> read(RegexTemplate template) {
    // TODO: implement
  }
  
  public Future<StringTuple> take(RegexTemplate template) {
    // TODO: implement
  }
  
  public Future<StringTuple> write(StringTuple tuple) {
    // TODO: implement
  }
  
  public Future<Integer> getSize() {
    // TODO: implement
  }
  
  public Future<MultiSet<? extends T>> get() {
    // (Optional) TODO: implement
  }
  
  public String getName() { return name; } 
  
  
  private enum RequestTypes { READ, TAKE; }
  private static class PendingRequest { /* ... */ }
}