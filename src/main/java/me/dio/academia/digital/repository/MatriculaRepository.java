package me.dio.academia.digital.repository;


import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository  extends JpaRepository<Matricula,Long> {

    List<Matricula> findByAlunoBairro(String bairro);
}
