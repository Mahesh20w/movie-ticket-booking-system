package com.example.movieticketbookingsystem.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T>
{
    private int statusCode;
    private String message;
    private T data;

}
