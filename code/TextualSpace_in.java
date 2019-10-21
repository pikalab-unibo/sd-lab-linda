class TextualSpace /* ... */ {
       
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();
  
  // IN
  public CompletableFuture<StringTuple> in(RegexTemplate template){
    CompletableFuture<StringTuple> res = new CompletableFuture<>();
        
    executor.execute(() -> handleIn(template, promise));
    
    return promise;
  }
  %*\framebreak*)
   private synchronized void handleIn(
                       RegexTemplate template, 
                       CompletableFuture<StringTuple> promise) {
                           
    Optional<StringTuple> matching = /*
      find and REMOVE matching tuple,
      if any
    */

    if (matching.isPresent()) {
      promise.complete(matching.get());
    } else {
      pendings.add(
        new PendingRequest(RequestTypes.IN, template, promise)
      );
    }
  }
}