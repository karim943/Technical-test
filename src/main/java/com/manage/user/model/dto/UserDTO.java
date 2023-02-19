package com.manage.user.model.dto;

import com.manage.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {

    @NotNull
    private String id;

    @NotNull
    private String username;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String country;

    private String phoneNumber;

    private Gender gender;
}
