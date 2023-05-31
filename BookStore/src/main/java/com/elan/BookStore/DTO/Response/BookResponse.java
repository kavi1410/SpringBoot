package com.elan.BookStore.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Integer Id;
    private String Name;
    private String Description;
    private Integer YearOfPublication;
    private String BookType;
    private double Price;
    private List<AuthorResponse> Author;
}
