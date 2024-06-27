package com.gabriel.suplementos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.suplementos.models.Suplemento;
import com.gabriel.suplementos.repositories.SuplementoRepository;

@RestController
@RequestMapping("/api")
public class SuplementoController {

    @Autowired
    SuplementoRepository suplementoRepository;

    @GetMapping("/criar/{id}")
    public ResponseEntity<Suplemento> criar(@PathVariable Long id) {
       boolean suplemento = suplementoRepository.findById(id).isPresent();

        if (suplemento) {
            Suplemento sup = suplementoRepository.findById(id).get();
            return ResponseEntity.ok().body(sup);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/salvar_suplemento")
    public void salvarSuplemento(@RequestBody Suplemento suplemento) {
        suplementoRepository.save(suplemento);
    }

}
