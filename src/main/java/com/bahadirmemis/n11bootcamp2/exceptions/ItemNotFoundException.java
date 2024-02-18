package com.bahadirmemis.n11bootcamp2.exceptions;

import com.bahadirmemis.n11bootcamp2.general.BaseErrorMessage;
import com.bahadirmemis.n11bootcamp2.general.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bahadirmemis
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends N11BusinessException {

  public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
    super(baseErrorMessage);
  }
}
