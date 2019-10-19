public class AsyncCounter2 {
  
  /* same fields and constructor of AsyncCounter1 */
  
  public CompletableFuture<Integer> countUpTo(int max) {
    CompletableFuture<Integer> result = new CompletableFuture<>();
    executor.execute(() -> countUpToImpl(max, result));
    return resultPromise;
  }
  
  private void countUpToImpl(int max, CompletableFuture<Integer> result) {
    value++;
    if (value < max) 
      executor.execute(() -> countUpToImpl(max, result)); // recursion!
    else 
      result.complete(value); // actual completion
  }
  
  public int getValue() { return value; }
}
