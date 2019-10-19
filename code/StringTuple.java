class StringTuple implements Tuple {
  private final String value;
  
  public StringTuple(String value) { this.value = value; }
  
  public String getValue() { return value; }
  
  // @Override public boolean equals(final Object obj) { /*...*/ }
  
  // @Override public int hashCode() { /*...*/ }
  
  @Override public String toString() {
    return "\"" + value + "\"";
  }
}