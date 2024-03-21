package com.matheus.crud.Service;

import com.matheus.crud.Domain.Clothes;
import com.matheus.crud.Request.ClothesRequest;
import com.matheus.crud.Repository.ClothesRepository;
import com.matheus.crud.exceptions.ClothingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    public List<Clothes> findAll() {
        List<Clothes> list = clothesRepository.findAll();
        return list;
    }

    public Clothes findById(String id){
        Optional<Clothes> optionalClothes=clothesRepository.findById(id);

        if(optionalClothes.isPresent()){
            return optionalClothes.get();
        }
        else{
            throw new ClothingNotFoundException(id);
        }

    }

    public void createClothing(ClothesRequest data) {

        Clothes clothes = new Clothes(data);
        clothesRepository.save(clothes);
    }


    public Clothes updateClothing(ClothesRequest data,String id) {
        if (id==null) {
            throw new RuntimeException();
        }
        else {
            Optional<Clothes> optionalClothes = clothesRepository.findById(id);
            if (optionalClothes.isPresent()) {
                Clothes clothes = optionalClothes.get();
                clothes.setName(data.getName());
                clothes.setImage(data.getImage());
                clothes.setModel(data.getModel());
                clothes.setPrice(data.getPrice());
                clothesRepository.save(clothes);
                return clothes;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public void deleteClothing(String id){
        clothesRepository.deleteById(id);

    }
}
