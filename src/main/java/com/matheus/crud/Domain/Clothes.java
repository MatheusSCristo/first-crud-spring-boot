package com.matheus.crud.Domain;

import com.matheus.crud.Request.ClothesRequest;
import com.matheus.crud.enums.ClothesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clothes")
public class Clothes {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    private String name;
    private Double price;
    private String image;
    private ClothesModel model;


    public Clothes(ClothesRequest clothesRequest){
        this.image= clothesRequest.getImage();
        this.name= clothesRequest.getName();
        this.price= clothesRequest.getPrice();
        this.model=clothesRequest.getModel();

    }
}
