package com.ShippingApplication.Application.Service;

import com.ShippingApplication.Application.Model.ShippingModel;
import com.ShippingApplication.Application.shippingRepo.shippingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Shippingservice {

    @Autowired
    shippingRepo repo;
    public List<ShippingModel> getAllBookings() {

        return repo.findAll();
    }
    public void save(ShippingModel shippingModel){
        repo.save(shippingModel);
    }

    public   ShippingModel getShippingModelById(Long id) {
        ShippingModel model= repo.getOne(id);
        return model;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
