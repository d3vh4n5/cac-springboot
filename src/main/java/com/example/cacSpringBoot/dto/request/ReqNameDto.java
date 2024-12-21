package com.example.cacSpringBoot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqNameDto {
    private String name;
}

//public class ReqNameDto {
//    private String name;
//
//    public ReqNameDto() { }
//
//    public ReqNameDto(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
