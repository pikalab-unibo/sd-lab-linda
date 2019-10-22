class TextualSpace /* ... */ {
       
  private MultiSet<StringTuple> tuples = new HashMultiSet<>();
  private MultiSet<PendingRequest> pendings = new HashMultiSet<>();

  // OUT
  public CompletableFuture<StringTuple> out(StringTuple tuple){
    CompletableFuture<StringTuple> res = new CompletableFuture<>();
        
    executor.execute(() -> handleOut(tuple, promise));
    
    return promise;
  }
  %*\framebreak*)
  private synchronized void handleOut(
                     StringTuple tuple, 
                     CompletableFuture<StringTuple> promise) {
                         
    final Iterator<PendingRequest> i = pendings.iterator();
    /* SUGGESTION: use iterators here */
    
    while (i.hasNext()) {
      final PendingRequest p = i.next();
      if (p.getTemplate().matches(tuple)) {
        /* TODO do something */
        if (p.getRequestType() == RequestTypes.IN) {
          /* TODO do something */
        }
      }
    }
  }
}