package com.localservices.servicemanagement.repositories;

import com.localservices.servicemanagement.models.Category;
import com.localservices.servicemanagement.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceModelRepository extends JpaRepository<ServiceModel, UUID> {

    Optional<ServiceModel> findByServiceNameAndBusiness_NameAndCategoryIs(
            String serviceName, String business_name, Category category
    );

    List<ServiceModel> findByServiceNameContaining(String name);

    List<ServiceModel> findByCategoryIn(List<Category> categories);

}