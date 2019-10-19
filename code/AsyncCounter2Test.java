final ExecutorService ex = Executors.newSingleThreadExecutor();
final AsyncCounter2 x = new AsyncCounter2(ex);

assertEquals(0, x.getValue());

final CompletableFuture<Integer> result =  x.countUpTo(10_000);

assertEquals(Integer.valueOf(10_000), result.get()); // blocking!
assertEquals(10_000, x.getValue());
