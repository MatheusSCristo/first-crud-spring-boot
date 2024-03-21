package com.matheus.crud.Request;

import com.matheus.crud.enums.ClothesModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothesRequest {
    @NotNull(message = "O nome não pode ser nulo")
    private String name;
    private String image;
    @NotNull(message= "O preço não pode ser nulo")
    @Positive(message = "Preco invalido")
    private Double price;
    @NotNull(message = "O modelo não pode ser nulo")
    private ClothesModel model;
}
