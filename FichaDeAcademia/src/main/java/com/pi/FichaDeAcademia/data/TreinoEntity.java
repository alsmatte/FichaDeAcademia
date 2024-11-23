package com.pi.FichaDeAcademia.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "Treino")
public class TreinoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //@NotNull(message="Informe o nome do treino")
    //@NotBlank(message="Informe o nome do treino")
    private String nomeTreino;
    
    //@NotNull(message="Informe o tipo de treino (ex: braço, perna, etc)")
    //@NotBlank(message="Informe o tipo de treino (ex: braço, perna, etc)")
    private String tipo;
    
    //@NotBlank(message="Informe quantos dias na semana")
    private int frequencia;
    
    private boolean diasSemana;
    
    private boolean seg, ter, qua, qui, sex, sab, dom;
    
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    private Set<ExercicioEntity> exercicios;
    
}
