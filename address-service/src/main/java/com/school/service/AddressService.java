package com.school.service;

import com.school.entity.Address;
import com.school.repository.AddressRepository;
import com.school.request.CreateAddressRequest;
import com.school.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest){
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById(long Id){
        logger.info("Inside getById "+ Id);

        Address address = addressRepository.findById(Id).get();

        return new AddressResponse(address);
    }
}
