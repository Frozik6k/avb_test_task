package ru.Frozik6k.userservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private float budget;
}
