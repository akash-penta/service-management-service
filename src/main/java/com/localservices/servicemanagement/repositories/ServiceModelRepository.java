package com.localservices.servicemanagement.repositories;

import com.localservices.servicemanagement.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceModelRepository extends JpaRepository<ServiceModel, UUID> {
}