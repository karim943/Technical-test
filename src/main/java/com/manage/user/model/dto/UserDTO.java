package com.manage.user.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String country;

    private String phoneNumber;

    private Gender gender;
}
