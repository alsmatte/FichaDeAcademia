package com.pi.FichaDeAcademia.service;

import com.pi.FichaDeAcademia.data.TreinoEntity;
import com.pi.FichaDeAcademia.data.TreinoRepository;
import com.pi.FichaDeAcademia.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {
    
     @Autowired
    TreinoRepository treinoRepository;

    public TreinoEntity criarTreino(TreinoEntity treino) {

        treino.setId(null);
        treinoRepository.save(treino);
        return treino;
    }

    @Transactional
    public TreinoEntity atualizarTreino(Integer treinoId, TreinoEntity treinoRequest) {
        
        TreinoEntity treino = getTreinoId(treinoId);
        
        treino.setNome(treinoRequest.getNome());
        treino.setTipo(treinoRequest.getTipo());
        treino.setFrequencia(treinoRequest.getFrequencia());
        treino.setDiasSemana(treino.getDiasSemana());

        treinoRepository.save(treino);

        return treino;
    }
    
    public TreinoEntity getTreinoId(Integer treinoId) {
        return treinoRepository.findById(treinoId).orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado " + treinoId));
    }
    
   
    public List<TreinoEntity> listarTodosTreinos() {

        return treinoRepository.findAll();
    }

    public void deletarTreino(Integer treinoId) {

        TreinoEntity treino = getTreinoId(treinoId);
        treinoRepository.deleteById(treino.getId());
    }
 
    
}
