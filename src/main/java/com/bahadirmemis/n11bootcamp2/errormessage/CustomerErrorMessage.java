package com.bahadirmemis.n11bootcamp2.errormessage;

import com.bahadirmemis.n11bootcamp2.general.BaseErrorMessage;

/**
 * @author bahadirmemis
 */
public enum CustomerErrorMessage implements BaseErrorMessage {

  INVALID_OLD_PASSWORD("Invalid old password!"),
  NEW_PASSWORDS_DID_NOT_MATCH("New passwords did not match");
  ;

  private final String message;

  CustomerErrorMessage(String message) {
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
