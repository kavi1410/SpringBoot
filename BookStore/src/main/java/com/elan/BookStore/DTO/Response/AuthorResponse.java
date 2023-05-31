package com.elan.BookStore.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Integer Id;
    private String Name;
    private String Gender;
    private String Genre;
}
