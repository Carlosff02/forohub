package com.alura.forohub.repository;

import com.alura.forohub.model.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicosRepository extends JpaRepository<Topicos, Long> {
}
