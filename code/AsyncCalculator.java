interface AsyncCalculator {

  CompletableFuture<BigInteger> factorial(BigInteger x);

  static AsyncCalculator newInstance(ExecutorService e) {
    // initialisation
  }
}
