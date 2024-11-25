package com.pi.FichaDeAcademia.controller;

import com.pi.FichaDeAcademia.data.ExercicioEntity;
import com.pi.FichaDeAcademia.data.TreinoEntity;
import com.pi.FichaDeAcademia.service.ExercicioService;
import com.pi.FichaDeAcademia.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @Autowired
    TreinoService treinoService;
    
    @Autowired
    ExercicioService exercicioService;
    
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
    
    //trazer a lista de treinos
    @GetMapping("/treinos")
    public String paginaTreinos(Model model) {
        model.addAttribute("treinos", treinoService.listarTodosTreinos());
        return "listaTreinos";
    }

    //deletar um treino
    @GetMapping("/deletarTreino/{treinoId}")
    public String deletarTreino(@PathVariable(value = "treinoId") Integer treinoId) {
        treinoService.deletarTreino(treinoId);
        return "redirect:/treinos";
    }

    //abrir a tela de cadastro de treino
    @GetMapping("/criarTreinoForm")
    public String criarTreinoForm(Model model) {
        TreinoEntity treino = new TreinoEntity();
        model.addAttribute("treino", treino);
        return "criaTreino";
    }

    //salvar treino
    @PostMapping("/salvarTreino")
    public String salvarTreino(@Valid @ModelAttribute("treino") TreinoEntity treino, BindingResult result,
            @RequestParam Boolean informaDias, @RequestParam(required = false) Boolean segunda,
            @RequestParam(required = false) Boolean terca, @RequestParam(required = false) Boolean quarta,
            @RequestParam(required = false) Boolean quinta, @RequestParam(required = false) Boolean sexta,
            @RequestParam(required = false) Boolean sabado, @RequestParam(required = false) Boolean domingo, Model model) {

        if (result.hasErrors()) {
            return "criaTreino";
        }
        
        treino.setDiasSemana(informaDias != null ? informaDias : false);
        
        if (treino.isDiasSemana()){
            treino.setSeg(segunda != null ? segunda : false);
            treino.setTer(terca != null ? terca : false);
            treino.setQua(quarta != null ? quarta : false);
            treino.setQui(quinta != null ? quinta : false);
            treino.setSex(sexta != null ? sexta : false);
            treino.setSab(sabado != null ? sabado : false);
            treino.setDom(domingo != null ? domingo : false);
            }
        else {
            treino.setSeg(false);
            treino.setTer(false);
            treino.setQua(false);
            treino.setQui(false);
            treino.setSex(false);
            treino.setSab(false);
            treino.setDom(false);
        }

        if (treino.getId() == null) {
            treinoService.criarTreino(treino);
        } else {
            treinoService.atualizarTreino(treino.getId(), treino);
        }

        return "redirect:/treinos";
    }

    //abrir tela de atualização de treino
    @GetMapping("/atualizarTreinoForm/{treinoId}")
    public String atualizarTreinoForm(@PathVariable(value = "treinoId") Integer treinoId, Model model) {

        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        model.addAttribute("treino", treino);
        return "atualizaTreino";
    }
    
    //trazer lista de exercícios
    @GetMapping("/detalhesTreino/{treinoId}")
    public String mostrarDetalhes(@PathVariable(value = "treinoId") Integer treinoId, Model model){
        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        model.addAttribute("treino", treino);
        ExercicioEntity exercicio = new ExercicioEntity();
        model.addAttribute("exercicio", exercicio);
        model.addAttribute("exercicios", exercicioService.getExerciciosPorTreino(treino));
        return "detalhesTreino";
    }
   
    //deletar exercicio
     @GetMapping("/detalhesTreino/{treinoId}/deletarExercicio/{exercicioId}")
    public String deletarExercicio(@PathVariable(value = "treinoId") Integer treinoId, @PathVariable(value = "exercicioId") Integer exercicioId, Model model) {
        model.addAttribute("treinoId", treinoId);
        exercicioService.deletarExercicio(exercicioId);
        return "redirect:/detalhesTreino/" + treinoId;
    }
    
    //abrir a tela de cadastro de exercicio
    @GetMapping("/detalhesTreino/{treinoId}/criarExercicioForm")
    public String criarExercicioForm(@PathVariable(value = "treinoId") Integer treinoId, Model model) {
        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        model.addAttribute("treino", treino);
        ExercicioEntity exercicio = new ExercicioEntity();
        model.addAttribute("exercicio", exercicio);
        model.addAttribute("treinoId", treinoId);
        return "criaExercicio";
    }
    
    //salvar exercicio
    @PostMapping("/detalhesTreino/{treinoId}/salvarExercicio")
    public String salvarExercicio(@Valid @ModelAttribute("exercicio") ExercicioEntity exercicio,
            BindingResult result, @PathVariable(value = "treinoId") Integer treinoId, Model model) {
        
        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        exercicio.setTreino(treino);
        model.addAttribute("treinoId", treinoId);

        if (result.hasErrors()) {
            return "criaExercicio";
        }

        else {
            exercicioService.criarExercicio(exercicio);
        }

        return "redirect:/detalhesTreino/" + treinoId;
    }
    
     @PostMapping("/detalhesTreino/{treinoId}/atualizarExercicio/{exercicioId}")
    public String atualizarExercicio(@Valid @ModelAttribute("exercicio") ExercicioEntity exercicio,
            BindingResult result, @PathVariable(value = "treinoId") Integer treinoId,
            @PathVariable(value = "exercicioId") Integer exercicioId, Model model) {
        
        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        exercicio.setTreino(treino);
        model.addAttribute("treinoId", treinoId);

        if (result.hasErrors()) {
            return "atualizaExercicio";
        
        } else {
            
            exercicioService.atualizarExercicio(exercicioId, treino, exercicio);
        }

        return "redirect:/detalhesTreino/" + treinoId;
    }
    
     //abrir tela de atualização de exercicio
    @GetMapping("/detalhesTreino/{treinoId}/atualizarExercicioForm/{exercicioId}")
    public String atualizarExercicioForm(@PathVariable(value = "treinoId") Integer treinoId,
            @PathVariable(value = "exercicioId") Integer exercicioId, Model model) {

        TreinoEntity treino = treinoService.getTreinoId(treinoId);
        ExercicioEntity exercicio = exercicioService.getExercicioId(exercicioId);
        model.addAttribute("exercicio", exercicio);
        model.addAttribute("treino", treino);
        model.addAttribute("treinoId", treinoId);
        model.addAttribute("exercicioId", exercicioId);
        return "atualizaExercicio";
    }
    
}
