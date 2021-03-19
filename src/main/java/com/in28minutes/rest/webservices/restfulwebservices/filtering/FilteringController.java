package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean() {
        return new SomeBean("val1", "val2", "val3");
    }

//    @GetMapping("/filtering-list")
//    public List<SomeBean> retrieveListOfSomeBean() {
//        SomeBean b1 = new SomeBean("val1", "val2", "val3");
//        SomeBean b2 = new SomeBean("val1", "val2", "val3");
//        SomeBean[] array = {b1,b2};
//        List<SomeBean> list = new Arrays.asList(array);
//        return list;
//    }
}
