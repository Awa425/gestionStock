package com.awainf.gestionstock.handlers;

import java.util.ArrayList;

import java.util.List;

import com.awainf.gestionstock.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorDto {
     private Integer httpCode;

  private ErrorCode code;

  private String message;

  private List<String> errors = new ArrayList<>();
    
}
