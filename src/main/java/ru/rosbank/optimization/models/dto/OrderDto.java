package ru.rosbank.optimization.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.core.instrument.Counter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    @JsonProperty("orderId")
    private int orderId;

    @JsonProperty("dateTime")
    private LocalDateTime dateTime;

    @JsonProperty("counterpartyId")
    private long counterpartyId;

    @JsonProperty("amount")
    private BigDecimal amount;

}
