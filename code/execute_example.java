public void executeExample() throws /* ... */  {
    ExecutorService ex = Executors.newCachedThreadPool();
    ex.execute(new Runnable() {
      
      @Override
      public void run() {
        System.out.println("Hello");
      }
    });
    
    System.out.println("This may be printed before 'Hello'");
    
    ex.shutdown();
    ex.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
  }