package com.kubeworks.movieService.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String userId;
    private String email;
    private String password;
    private String fullName;
    private ClaimResponseDto claimResponseDto;
}
