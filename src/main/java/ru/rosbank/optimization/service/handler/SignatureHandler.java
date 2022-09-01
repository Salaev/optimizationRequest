package ru.rosbank.optimization.service.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rosbank.optimization.client.UserApi;
import ru.rosbank.optimization.models.dto.OrderDto;

@Component
@AllArgsConstructor
public class SignatureHandler {
    private UserApi userApi;

    public void signing(OrderDto order) {
        //логика
        userApi.getSignatureLevels(order.getCounterpartyId());
        //логика
    }
}
