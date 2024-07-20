package br.com.fiap.healthmed.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.healthmed.adapter.controller.MedicoController;
import br.com.fiap.healthmed.adapter.repository.medico.MedicoDto;
import br.com.fiap.healthmed.adapter.repository.medico.MedicoRepository;
import br.com.fiap.healthmed.core.entity.medico.Medico;
import br.com.fiap.healthmed.core.enums.Especializacao;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MedicoService implements MedicoController {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<MedicoDto> consultar(String nome, Especializacao especializacao) {
        List<Medico> listMedico = repository.findMedico(especializacao, nome);

        return listMedico.stream().map(MedicoDto::new).collect(Collectors.toList());
    }

    @Override
    public MedicoDto detalhar(Long idMedico) {
        Medico medico = repository.findById(idMedico).orElseThrow(EntityNotFoundException::new);

        return new MedicoDto(medico);
    }

    @Override
    @Transactional
    public MedicoDto cadastrar(MedicoDto dto) {
        Medico medico = new Medico();
        medico.atualizar(dto);
        repository.save(medico);

        return new MedicoDto(medico);
    }

    @Override
    @Transactional
    public MedicoDto alterar(Long idMedico, MedicoDto dto) {
        Medico medico = repository.findById(idMedico).orElseThrow(EntityNotFoundException::new);
        medico.atualizar(dto);
        repository.save(medico);

        return new MedicoDto(medico);
    }

    @Override
    @Transactional
    public void excluir(Long idMedico) {
        repository.deleteById(idMedico);
    }
}
