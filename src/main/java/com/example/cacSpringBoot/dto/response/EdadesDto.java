package com.example.cacSpringBoot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EdadesDto {
    private List<Integer> edades = new ArrayList<>();
}
