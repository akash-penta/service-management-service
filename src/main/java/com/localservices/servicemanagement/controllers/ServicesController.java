package com.localservices.servicemanagement.controllers;

import com.localservices.servicemanagement.dtos.ServiceRequestDto;
import com.localservices.servicemanagement.dtos.ServiceResponseDto;
import com.localservices.servicemanagement.exceptions.UnableToCreateServiceException;
import com.localservices.servicemanagement.services.ServicesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private ServicesService servicesService;

    public ServicesController(
            ServicesService servicesService
    ) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ServiceResponseDto createService(@RequestBody ServiceRequestDto serviceRequestDto)
            throws UnableToCreateServiceException {
        ServiceResponseDto responseDto = servicesService.createService(
                serviceRequestDto.getServiceName(),
                serviceRequestDto.getDescription(),
                serviceRequestDto.getBusinessName(),
                serviceRequestDto.getCategoryName()
        );
        return responseDto;
    }
}
