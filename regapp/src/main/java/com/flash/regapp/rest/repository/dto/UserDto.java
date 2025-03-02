package com.flash.regapp.rest.repository.dto;

import lombok.*;
import org.mapstruct.Mapping;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto{
    @Serial
    private static final long serialVersionUID = 1L;

    public String username;
    public String surname;
    public String password;
    public String email;
    public String passwordResetCode;

}
