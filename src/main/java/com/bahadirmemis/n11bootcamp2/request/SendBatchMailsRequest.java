package com.bahadirmemis.n11bootcamp2.request;

import java.util.List;

/**
 * @author bahadirmemis
 */
public record SendBatchMailsRequest(List<String> receivers, String topic, String mailBody) {

}
