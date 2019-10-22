class TextualSpace /* ... */ {
       
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();

  // RD
  public CompletableFuture<StringTuple> rd(RegexTemplate template){
    CompletableFuture<StringTuple> res = new CompletableFuture<>();
        
    executor.execute(() -> handleRd(template, promise));
    
    return promise;
  }
  %*\framebreak*)
   private synchronized void handleRd(
                       RegexTemplate template, 
                       CompletableFuture<StringTuple> promise) {
                           
    Optional<StringTuple> matching = tuples.stream()
        .filter(template::matches)
        .findFirst();

    if (matching.isPresent()) {
      promise.complete(matching.get());
    } else {
      pendings.add(
        new PendingRequest(RequestTypes.RD, template, promise)
      );
    }
  }
}