package com.pi.FichaDeAcademia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data 
@Entity 
@Table(name="Exercicio")
public class ExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    //@NotNull(message = "Informe o peso")
    private double peso;
    
    private int series;
    
    private int repeticoes;
    
    private String obs;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    private TreinoEntity treino;

}
