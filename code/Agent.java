public abstract class Agent {
  private final Thread thread;
  private volatile boolean running = true;

  public Agent() { this.thread = new Thread(this::run); }

  private void run() {
    try {
      onBegin();
      while (running) loop();
    } catch (InterruptedException ignored) {
      // Silently ignored
    } catch (Exception e) {
      onUncaughtException(e);
    } finally {
      onEnd();
    }
  }
  %*\framebreak*)
  protected abstract void loop() throws Exception;
  protected void onBegin() throws Exception {}
  protected void onEnd() {}
  protected void onUncaughtException(Exception e) { 
    e.printStackTrace(); 
  }

  public void start() { thread.start(); }
  public void stop() { running = false; thread.interrupt(); }
}
