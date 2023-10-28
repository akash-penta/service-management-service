package com.localservices.servicemanagement.services;

import com.localservices.servicemanagement.dtos.ServiceResponseDto;
import com.localservices.servicemanagement.exceptions.UnableToCreateServiceException;

public interface ServicesService {
    ServiceResponseDto createService(
            String serviceName,
            String description,
            String businessName,
            String categoryName
    ) throws UnableToCreateServiceException;
}
