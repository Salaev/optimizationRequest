package ru.rosbank.optimization.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.optimization.models.dto.Action;
import ru.rosbank.optimization.models.dto.OrderDto;
import ru.rosbank.optimization.models.dto.Response;
import ru.rosbank.optimization.service.OrderServiceApi;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    ApplicationContext context;

    private final OrderServiceApi service;

    @PostMapping("/sign")
    public Response signOrder(@RequestBody OrderDto order) {
        try {
            var result = service.sign(order);
            return result;
        } catch (Exception ex) {
            log.error("Exception in controller:", ex);
            throw ex;
        }
    }
}
