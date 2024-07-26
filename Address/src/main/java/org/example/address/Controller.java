package org.example.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class Controller {

    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    Address addAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }


    @GetMapping("/{id}")
    Address getAddress(@PathVariable Long id) {
        return addressRepository.findById(id).get();
    }

    @GetMapping
    List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
