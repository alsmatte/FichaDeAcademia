package com.pi.FichaDeAcademia.data;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface TreinoRepository extends JpaRepository<TreinoEntity, Integer> { 

} 
