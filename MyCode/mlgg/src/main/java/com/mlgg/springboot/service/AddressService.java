package com.mlgg.springboot.service;

import com.mlgg.springboot.entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:26 2019/11/11
 * @see com.mlgg.springboot.service
 */
@Service
public class AddressService {

    public Address findByLastName(String lastName) {
        Address address = new Address();
        address.setLastName(lastName);
        if("yifei".equals(lastName)) {
            address.setFirstName("zhang");
            return address;
        }
        address.setFirstName("firstName");
        return address;
    }
}
