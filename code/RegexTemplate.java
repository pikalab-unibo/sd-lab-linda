class RegexTemplate implements Template {
  private final Pattern regex;
  
  public RegexTemplate(final String regex) {
    Objects.requireNonNull(regex);
    this.regex = Pattern.compile(regex, Pattern.MULTILINE);
  }
  
  @Override public boolean matches(final Tuple tuple) {
    if (tuple instanceof StringTuple) {
      StringTuple casted = (StringTuple)tuple;
      return regex.matcher(casted.getValue()).matches();
    }
    return false;
  }
  
  @Override public String toString() {
    return "/" + regex.pattern() + "/";
  }
}
