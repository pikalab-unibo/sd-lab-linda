interface Future<X> {

  // checks whether the future has been completed (non-blocking)
  boolean isDone();

  // blocks until result is ready, then returns it
  X get() throws InterruptedException, ExecutionException;
  
  // blocks until result is ready or timeout occurs
  X get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        
  // other methods
}