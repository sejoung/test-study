package io.github.sejoung.best;

public class Parser {
  public String parseLogLine(String input) {
    var sanitizedInput = trimInput(input);
    return sanitizedInput;
  }

  private String trimInput(String input) {
    return input.trim();
  }
}
