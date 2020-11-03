class TextualSpace 
     implements TupleSpace<StringTuple, RegexTemplate> {

  private String name;
  private ExecutorService executor;
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();
  
  public TextualSpace(String name, ExecutorService executor) {
    this.name = Objects.requireNonNull(name);
    this.executor = Objects.requireNonNull(executor);
  }
  
  public CompletableFuture<StringTuple> rd(RegexTemplate tt) {
    // TODO: implement
  }
  
  public CompletableFuture<StringTuple> in(RegexTemplate tt) {
    // TODO: implement
  }
  
  public CompletableFuture<StringTuple> out(StringTuple t) {
    // TODO: implement
  }
  
  public CompletableFuture<Integer> count() {
    // TODO: implement
  }
  
  public CompletableFuture<MultiSet<? extends StringTuple>> get() {
    // TODO: implement
  }
  
  public String getName() { return name; } 
  
}