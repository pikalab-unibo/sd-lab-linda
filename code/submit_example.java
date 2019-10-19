public void submitExample() throws /* ... */ {
  ExecutorService ex = Executors.newCachedThreadPool();
  Future<Integer> result = ex.submit(new Callable<Integer>() {

    @Override public Integer call() throws Exception {
      return 1 + 2;
    }
    
  });
  
  System.out.println("This may be printed before the result");
  System.out.println("Future result: " + result);
  System.out.println("Is result ready? " + result.isDone());
  System.out.println("result: " + result.get()); // Blocking!
  
  ex.shutdown();
  ex.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
}