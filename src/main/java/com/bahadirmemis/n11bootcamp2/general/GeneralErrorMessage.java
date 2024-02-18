package com.bahadirmemis.n11bootcamp2.general;

/**
 * @author bahadirmemis
 */
public enum GeneralErrorMessage implements BaseErrorMessage {

  ITEM_NOT_FOUND("Item not found!");

  private final String message;

  GeneralErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return message;
  }
}
