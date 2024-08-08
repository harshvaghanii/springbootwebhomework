package com.example.codingshuttle.springbootwebhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDTO {
    private Long id;
    @NotEmpty(message = "Required Field Empty : Title")
    private String title;

    @NotNull(message = "Required Field Missing: isActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull(message = "Required Field missing: Created At DateTime")
    @PastOrPresent(message = "The date can be either today's date or a date in the past")
    private LocalDate createdAt;
}
