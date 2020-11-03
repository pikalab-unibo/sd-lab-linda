class RegexTemplate implements Template {
  private final Pattern regex;
  
  public RegexTemplate(String regex) {
    Objects.requireNonNull(regex);
    this.regex = Pattern.compile(regex, Pattern.MULTILINE);
  }
  
  @Override 
  public boolean matches(Tuple tuple) {
    if (tuple instanceof StringTuple) {
      StringTuple casted = (StringTuple)tuple;
      // TODO check if casted.getValue() matches regex
    }
    return false;
  }
  
  // toString, hashCode, equals
}
