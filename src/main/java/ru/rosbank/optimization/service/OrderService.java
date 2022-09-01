package ru.rosbank.optimization.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.rosbank.optimization.models.dto.OrderDto;
import ru.rosbank.optimization.models.dto.Response;
import ru.rosbank.optimization.service.handler.ActionHandler;
import ru.rosbank.optimization.service.handler.SecurityHandler;
import ru.rosbank.optimization.service.handler.SignatureHandler;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService implements OrderServiceApi {
    private SecurityHandler securityHandler;
    private SignatureHandler signatureHandler;
    private ActionHandler actionHandler;

    @Override
    public Response sign(OrderDto orderDto) {
        //логика
        securityHandler.checkPermissions(orderDto);
        //логика
        signatureHandler.signing(orderDto);
        //логика
        var actions = actionHandler.getActions(orderDto);
        //логика
        return Response.builder()
                .actions(actions)
                .build();
    }
}
