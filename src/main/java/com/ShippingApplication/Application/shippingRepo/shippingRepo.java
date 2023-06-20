package com.ShippingApplication.Application.shippingRepo;

import com.ShippingApplication.Application.Model.ShippingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface shippingRepo extends JpaRepository<ShippingModel, Long> {
}
