package com.alura.forohub.controller;

import com.alura.forohub.dto.TopicosDto;
import jakarta.transaction.Transactional;
import com.alura.forohub.model.Topicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alura.forohub.repository.TopicosRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicosRepository repository;

    @GetMapping
    public List<Topicos> obtenerTopicos(){
        System.out.println("hola");
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Topicos> obtenerTopico(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Topicos> guardarTopico(@RequestBody Topicos topico){
        repository.save(topico);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    public ResponseEntity<Topicos> actualizarTopico(@RequestBody TopicosDto topicosGuardar){
        Optional<Topicos> topico = repository.findById(topicosGuardar.id());
        if(topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Topicos> deleteTopic(@PathVariable Long id) {
        Optional<Topicos> topico = repository.findById(id);
        if (topico.isPresent()) {
            repository.delete(topico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
