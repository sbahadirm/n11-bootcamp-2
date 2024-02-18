package com.bahadirmemis.n11bootcamp2.request;

/**
 * @author bahadirmemis
 */
public record CustomerUpdatePasswordRequest(String oldPass, String newPass, String newPass2) {

}
