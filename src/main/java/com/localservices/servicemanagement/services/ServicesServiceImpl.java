package com.localservices.servicemanagement.services;

import com.localservices.servicemanagement.dtos.ServiceResponseDto;
import com.localservices.servicemanagement.exceptions.UnableToCreateServiceException;
import com.localservices.servicemanagement.models.Business;
import com.localservices.servicemanagement.models.Category;
import com.localservices.servicemanagement.models.ServiceModel;
import com.localservices.servicemanagement.repositories.ServiceModelRepository;
import com.localservices.servicemanagement.repositories.BusinessRepository;
import com.localservices.servicemanagement.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService{

    private final ServiceModelRepository serviceRepository;
    private final BusinessRepository businessRepository;
    private final CategoryRepository categoryRepository;

    public ServicesServiceImpl(
            ServiceModelRepository serviceRepository,
            BusinessRepository businessRepository,
            CategoryRepository categoryRepository
    ) {
        this.serviceRepository = serviceRepository;
        this.businessRepository = businessRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ServiceResponseDto createService(
            String serviceName,
            String description,
            String businessName,
            String categoryName
    ) throws UnableToCreateServiceException {
        if(serviceName.isBlank() || businessName.isBlank()) {
            throw new UnableToCreateServiceException("Service name and Business name are can't be empty");
        }

        Business business = new Business();
        business.setName(businessName);

        Category category = new Category();
        category.setName(categoryName);

        ServiceModel service = new ServiceModel();
        service.setServiceName(serviceName);
        service.setDescription(description);
        service.setBusiness(business);
        service.setCategory(category);

        ServiceModel savedService = serviceRepository.save(service);

        ServiceResponseDto responseDto = new ServiceResponseDto();
        responseDto.setId(savedService.getId());
        responseDto.setServiceName(savedService.getServiceName());
        responseDto.setDescription(savedService.getDescription());
        responseDto.setBusinessName(savedService.getBusiness().getName());
        responseDto.setCategoryName(savedService.getCategory().getName());

        return responseDto;
    }
}
