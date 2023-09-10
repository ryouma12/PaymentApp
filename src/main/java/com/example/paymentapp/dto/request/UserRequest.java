package com.example.paymentapp.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {


    private Long id;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String address;
    private Integer telephone;
    private String createdAt;
    private String modifiedAt;
}
