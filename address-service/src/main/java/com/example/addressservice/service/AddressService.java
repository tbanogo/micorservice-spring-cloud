package com.example.addressservice.service;

import com.example.addressservice.entity.Address;
import com.example.addressservice.repository.AddressRepository;
import com.example.addressservice.request.CreateAddressRequest;
import com.example.addressservice.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    Logger logger = LoggerFactory.getLogger(AddressService.class);

    public AddressResponse createAddress(CreateAddressRequest request){
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address = addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getAddressById(Long id){
        logger.info("Address Id : " + id);
        Address address = addressRepository.findById(id).get();
        return new AddressResponse(address);
    }
}
