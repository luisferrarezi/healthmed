package br.com.fiap.healthmed.adapter.repository.medico;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthmed.core.entity.medico.Medico;
import br.com.fiap.healthmed.core.enums.Especializacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class MedicoRepositoryCustomImpl implements MedicoRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medico> findMedico(Especializacao especializacao, String nome) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<Medico> medico = query.from(Medico.class);

        query.select(medico);

        if (especializacao != null){
            predicates.add(cb.equal(medico.get("especializacao"), especializacao.ordinal()));
        }

        if ((nome != null) && !nome.isEmpty()){
            predicates.add(cb.like(medico.get("nome").as(String.class), "%" + nome + "%"));
        }        

        query.where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(query).getResultList();
    }
}
