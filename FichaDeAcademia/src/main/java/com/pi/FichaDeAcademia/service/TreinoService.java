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
        
        treino.setNomeTreino(treinoRequest.getNomeTreino());
        treino.setTipo(treinoRequest.getTipo());
        treino.setFrequencia(treinoRequest.getFrequencia());
        treino.setDiasSemana(treinoRequest.isDiasSemana());
        treino.setSeg(treinoRequest.isSeg());
        treino.setTer(treinoRequest.isTer());
        treino.setQua(treinoRequest.isQua());
        treino.setQui(treinoRequest.isQui());
        treino.setSex(treinoRequest.isSex());
        treino.setSab(treinoRequest.isSab());
        treino.setDom(treinoRequest.isDom());

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
