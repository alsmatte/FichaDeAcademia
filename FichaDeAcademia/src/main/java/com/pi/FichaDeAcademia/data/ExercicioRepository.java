package com.pi.FichaDeAcademia.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; 

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Integer> { 
    
    List<ExercicioEntity> findByTreino(TreinoEntity treino);
    
    ExercicioEntity findByTreinoAndId(TreinoEntity treino, Integer id);

    @Modifying
    @Query(value="DELETE FROM exercicio WHERE treino_id = :id", nativeQuery=true)
    public void deletarExerciciosDoTreino(@Param("id") Integer id);

} 

