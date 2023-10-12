package service;

import FeignClient.AddressFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import response.AddressResponse;

@Service
public class CommonService {
    @Autowired
    private AddressFeignClient addressFeignClient;
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    int count = 1;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallBackGetById")
    public AddressResponse getById(Long id){
        logger.info("Success : " + id);
        count++;
        return addressFeignClient.getById(id);
    }

    public AddressResponse fallBackGetById(Long id, Throwable th){
        logger.error("Error : " + th);
        return new AddressResponse();
    }
}
