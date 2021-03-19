package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import java.net.URISyntaxException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserResourceTest {

    @Test
    void userCreate() throws URISyntaxException {
        UserDaoService service = mock(UserDaoService.class);
        final Date birthdate = new Date();
        User utest = new User(101, "utest", birthdate);
        when(service.save(argThat(new ArgumentMatcher<User>() {
            @Override
            public boolean matches(User user) {
                assertEquals(101, user.getId());
                assertEquals("utest", user.getName());
                assertEquals(birthdate, user.getBirthdate());
                return true;
            }
        }))).thenReturn(utest);

        UserResource userResource = new UserResource(service);

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://xyz.com/users"));

        ResponseEntity<Object> result =
                userResource.createUser(utest, request);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals("http://xyz.com/users/101", result.getHeaders().get("location").get(0));

    }
}