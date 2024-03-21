package com.matheus.crud.Controller;

import com.matheus.crud.Domain.Clothes;
import com.matheus.crud.Request.ClothesRequest;
import com.matheus.crud.Service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("clothes")
@RestController("clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping
    public ResponseEntity<List<Clothes>> findAll(){
        List<Clothes> list = clothesService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Clothes> findById(@PathVariable String Id){
        Clothes clothes= clothesService.findById(Id);
        return ResponseEntity.ok().body(clothes);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Validated ClothesRequest data){
        System.out.println(data);
        clothesService.createClothing(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clothes> update(@RequestBody @Validated ClothesRequest data,@PathVariable String id){
        Clothes clothes= clothesService.updateClothing(data,id);
        return ResponseEntity.ok().body(clothes);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> delete(@PathVariable String Id){
        clothesService.deleteClothing(Id);
        return ResponseEntity.ok("Entity deleted");
    }
}
