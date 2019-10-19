public void promise() throws /* ... */ {
  ExecutorService ex = Executors.newCachedThreadPool();
  Random rand = new Random();
  CompletableFuture<Integer> promise = new CompletableFuture<Integer>();
  
  while (!promise.isDone()) {
    ex.execute(() -> {
      int guess = rand.nextInt(100 + 1);
      if (guess == 100) {
        System.out.printf("Guess: %d. FOUND!\n", guess);
        promise.complete(guess);
      } else System.out.printf("Guess: %d.\n", guess);
    });
  }
  
  System.out.println("Result: " + promise.get());
  
  ex.shutdown();
  ex.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
}