class StringTuple implements Tuple {
  private final String value;
  
  public StringTuple(String value) { 
      this.value = Objects.requireNonNull(value);
  }
  
  @Override
  public String getValue() { return value; }
  
  // toString, hashCode, equals
}