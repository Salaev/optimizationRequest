package ru.rosbank.optimization.service;

import ru.rosbank.optimization.models.dto.Action;
import ru.rosbank.optimization.models.dto.OrderDto;
import ru.rosbank.optimization.models.dto.Response;

import java.util.Set;

public interface OrderServiceApi {

    Response sign(OrderDto orderDto);
}
