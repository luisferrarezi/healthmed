package br.com.fiap.healthmed.adapter.repository.medico;

import java.util.List;

import br.com.fiap.healthmed.core.entity.medico.Medico;
import br.com.fiap.healthmed.core.enums.Especializacao;

public interface MedicoRepositoryCustom {
    public List<Medico> findMedico(Especializacao especializacao, String nome);    
}
