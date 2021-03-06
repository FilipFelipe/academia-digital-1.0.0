package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setBairro(form.getBairro());
        aluno.setCpf(form.getCpf());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(aluno) ;
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public List<Aluno> getAll(String dataDeNasicimento) {
        if (dataDeNasicimento == null){
            return repository.findAll();
        }
        LocalDate localDate = LocalDate.parse(dataDeNasicimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return repository.findByDataDeNascimento(localDate);
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = repository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return repository.save(aluno);
    }

    @Override
    public String delete(Long id) {
        Aluno aluno = repository.findById(id).get();
        repository.delete(aluno);
        return "Ok";
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = repository.findById(id).get();
        return aluno.getAvaliacoes();
    }


}
