package com.shopperapp.ShopperApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Element Does Not Exist")
public class ElementNotFoundException extends EntityNotFoundException {


}
