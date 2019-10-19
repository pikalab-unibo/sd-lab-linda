class TextTupleSpace 
   implements TupleSpace<StringTuple, RegexTemplate> {
       
  private String name;  
  private ExecutorService executor;
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();

  public Future<StringTuple> read(RegexTemplate template) {
    CompletableFuture<StringTuple> promise = 
        new CompletableFuture<StringTuple>();
        
    executor.execute(() -> handleRead(template, promise));
    
    return promise;
  }
  %*\framebreak*)
   private void handleRead(RegexTemplate template, 
       CompletableFuture<StringTuple> promise) {
           
    synchronized(this) {
      Optional<StringTuple> matching = tuples.stream()
        .filter(template::matches)
        .findFirst();
      
      if (matching.isPresent()) {
        promise.complete(matching.get());
      } else {
        pendings.add(
          new PendingRequest(RequestTypes.READ, template, promise)
        );
      }
    }
  }
}