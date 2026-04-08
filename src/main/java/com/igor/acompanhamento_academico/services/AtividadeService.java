package com.igor.acompanhamento_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.dtos.atividade.AtividadeRequestDTO;
import com.igor.acompanhamento_academico.dtos.atividade.AtividadeResponseDTO;
import com.igor.acompanhamento_academico.entities.Atividade;
import com.igor.acompanhamento_academico.entities.Matricula;
import com.igor.acompanhamento_academico.repositories.AtividadeRepository;
import com.igor.acompanhamento_academico.repositories.MatriculaRepository;

@Service
public class AtividadeService {

    private final AtividadeRepository respositoryAtividade;
    private final MatriculaRepository repositoryMatricula;

    public AtividadeService(AtividadeRepository repositoryAtividade, MatriculaRepository repositoryMatricula){
        this.respositoryAtividade = repositoryAtividade;
        this.repositoryMatricula = repositoryMatricula;
    }

    public AtividadeResponseDTO cadastrarAtividade(AtividadeRequestDTO dto){
        Matricula matricula = repositoryMatricula.findById(dto.idMatricula()).orElseThrow(() -> new RuntimeException("Erro ao buscar matricula"));

        Atividade newAtividade = new Atividade(dto.titulo(), dto.descricao(), dto.dataEntrega(), dto.nota(), "PENDENTE", matricula);

        Atividade save = respositoryAtividade.save(newAtividade);

        return new AtividadeResponseDTO(save);
    }

    public List<AtividadeResponseDTO> listarTodas(){

        List<AtividadeResponseDTO> listAtividadeDto = respositoryAtividade.findAll().stream().map(n -> new AtividadeResponseDTO(n)).toList();

        return listAtividadeDto;
    }

    public List<AtividadeResponseDTO> listarPendentesPorAluno(Long alunoId) {
        return respositoryAtividade.findByMatricula_Aluno_IdAndStatusOrderByDataEntregaAsc(alunoId, "PENDENTE")
                .stream()
                .map(n -> new AtividadeResponseDTO(n))
                .toList();
    }


}
