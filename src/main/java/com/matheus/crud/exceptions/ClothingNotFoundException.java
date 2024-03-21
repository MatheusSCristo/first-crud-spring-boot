package com.matheus.crud.exceptions;

public class ClothingNotFoundException extends RuntimeException{


    public ClothingNotFoundException(String id){
        super("Clothing with id: "+id+" not found");
    }
}
