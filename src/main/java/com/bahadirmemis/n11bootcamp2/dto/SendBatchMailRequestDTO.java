package com.bahadirmemis.n11bootcamp2.dto;

import java.util.List;

/**
 * @author bahadirmemis
 */
public record SendBatchMailRequestDTO(List<String> receivers, String topic, String mailBody) {

}
