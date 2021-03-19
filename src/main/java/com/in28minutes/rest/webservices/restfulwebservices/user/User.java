package com.in28minutes.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="All details about the user")
public class User {

    private Integer id;

    @Size(min=2, message="Name should have at least 2 characters")
    @ApiModelProperty("Names should have at least 2 characters")
    private String name;

    @Past
    @ApiModelProperty("Birthdate should be in the past")
    private Date birthdate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
