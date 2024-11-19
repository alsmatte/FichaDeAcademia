package com.pi.FichaDeAcademia.service;

import com.pi.FichaDeAcademia.data.ExercicioEntity;
import com.pi.FichaDeAcademia.data.ExercicioRepository;
import com.pi.FichaDeAcademia.data.TreinoEntity;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {
    
    @Autowired
    ExercicioRepository exercicioRepository;

    public ExercicioEntity criarAnalise(ExercicioEntity exercicio) {

        exercicio.setId(null);
        exercicioRepository.save(exercicio);
        return exercicio;
    }

    public ExercicioEntity atualizarExercicio(Integer exercicioId, TreinoEntity treino, ExercicioEntity exercicioRequest) {
        
        ExercicioEntity exercicio = getExercicioId(exercicioId);
        
        exercicio.setNome(exercicioRequest.getNome());
        exercicio.setPeso(exercicioRequest.getPeso());
        exercicio.setSeries(exercicioRequest.getSeries());
        exercicio.setRepeticoes(exercicioRequest.getRepeticoes());
        exercicio.setObs(exercicioRequest.getObs());
        exercicio.setTreino(treino);

        exercicioRepository.save(exercicio);

        return exercicio;
    }
    
    
    public ExercicioEntity atualizarExercicio2(Integer exercicioId, ExercicioEntity exercicioRequest) {
        
        ExercicioEntity exercicio = getExercicioId(exercicioId);
        
        exercicio.setNome(exercicioRequest.getNome());
        exercicio.setPeso(exercicioRequest.getPeso());
        exercicio.setSeries(exercicioRequest.getSeries());
        exercicio.setRepeticoes(exercicioRequest.getRepeticoes());
        exercicio.setObs(exercicioRequest.getObs());
        //exercicio.setTreino(treino);

        exercicioRepository.save(exercicio);

        return exercicio;
    }
    
    public ExercicioEntity getExercicioId(Integer exercicioId) {
        return exercicioRepository.findById(exercicioId).orElse(null);
    }
   
    public List<ExercicioEntity> listarTodosExercicios() {

        return exercicioRepository.findAll();
    }

    public void deletarExercicio(Integer exercicioId) {

        ExercicioEntity exercicio = getExercicioId(exercicioId);
        exercicioRepository.deleteById(exercicio.getId());
    }
    
    
    public List<ExercicioEntity> getExerciciosPorTreino(TreinoEntity treino) {
        return exercicioRepository.findByTreino(treino);
    }

    //nao sei se funciona
    @Transactional
    public void deletarExerciciosPorTreinoId(Integer treinoId) {
        exercicioRepository.deletarExerciciosDoTreino(treinoId);
    }

 
    
}
