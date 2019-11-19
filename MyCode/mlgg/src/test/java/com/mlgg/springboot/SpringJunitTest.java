package com.mlgg.springboot;

import com.mlgg.springboot.entity.Address;
import com.mlgg.springboot.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:24 2019/11/11
 * @see com.mlgg.springboot
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJunitTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testService() {
        Address yifei = addressService.findByLastName("yifei");
        System.out.println(yifei.getFirstName()+yifei.getLastName());
    }


}
