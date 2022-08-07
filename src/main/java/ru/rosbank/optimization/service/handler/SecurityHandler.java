package ru.rosbank.optimization.service.handler;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import ru.rosbank.optimization.client.UserApi;
import ru.rosbank.optimization.models.dto.OrderDto;

@Component
@AllArgsConstructor
public class SecurityHandler {
    private UserApi userApi;

    public void checkPermissions(OrderDto order) {
        //логика
        userApi.getSignatureLevels(order.getCounterpartyId());
        //логика
    }
}
