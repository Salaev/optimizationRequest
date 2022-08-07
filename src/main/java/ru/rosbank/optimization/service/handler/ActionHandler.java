package ru.rosbank.optimization.service.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rosbank.optimization.client.UserApi;
import ru.rosbank.optimization.models.dto.Action;
import ru.rosbank.optimization.models.dto.OrderDto;

import java.util.Set;

@Component
@AllArgsConstructor
public class ActionHandler {
    private UserApi userApi;

    public Set<Action> getActions(OrderDto order) {
        //логика
        userApi.getSignatureLevels(order.getCounterpartyId());
        //логика
        return Set.of(Action.values());
    }
}
