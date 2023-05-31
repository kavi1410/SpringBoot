package com.elan.RestController.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorModel {
     private int ErrorCode;
     private List<String> ErrorMessage;
     private List<String> Details;
     private LocalDateTime Date;
}
