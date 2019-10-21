public TextualTupleSpace /* ... */ {
	
  private ExecutorService executor;
  /* other fields */

  public CompletableFuture<OUTPUT> primitive(INPUT arg) {
    CompletableFuture<OUTPUT> result = new CompletableFuture<>();
    executor.execute(() -> handlePrimitive(arg, result))
    return result;
  }

  private synchronized CompletableFuture<OUTPUT> handlePrimitive(
                             INPUT arg,
                             CompletableFuture<OUTPUT> result) {
  	/* TODO actual implementation here */
  }

}