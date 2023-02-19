package com.manage.user.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manage.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
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
