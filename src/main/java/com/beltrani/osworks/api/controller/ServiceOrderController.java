package com.beltrani.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import com.beltrani.osworks.domain.model.ServiceOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOrderController {

    @GetMapping("/services")
    public List<ServiceOrder> listServiceOrders(){
        var service1 = new ServiceOrder();
        service1.setId(1L);
        service1.setDescricao("formatação");
        service1.setPreco(85.00);

        var service2 = new ServiceOrder();
        service2.setId(2L);
        service2.setDescricao("limpeza");
        service2.setPreco(22.50);

        return Arrays.asList(service1, service2);
    }
}