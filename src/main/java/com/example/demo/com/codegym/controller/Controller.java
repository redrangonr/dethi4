package com.example.demo.com.codegym.controller;

import com.example.demo.com.codegym.model.City;
import com.example.demo.com.codegym.service.ICityService;
import com.example.demo.com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;



@RestController
@RequestMapping("/city")
public class Controller {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @GetMapping("/list")
    private ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("city", cityService.findAll());
        return modelAndView;
    }


    @GetMapping()
    public ResponseEntity<Iterable<City>> findAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    private ResponseEntity<City> editCity(@PathVariable Long id,@RequestBody City city){
        Optional<City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    city.setId(id);
            return  new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
public  ResponseEntity<City> deleteCity(@PathVariable Long id){
Optional<City> cityOptional = cityService.findById(id);
if(!cityOptional.isPresent()){
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
cityService.remove(id);
return  new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);

    }
    @PostMapping()
    private ResponseEntity<City> cerateCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }
}