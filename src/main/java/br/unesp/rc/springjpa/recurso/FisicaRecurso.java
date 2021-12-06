/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.recurso;

import br.unesp.rc.springjpa.dto.FisicaDTO;
import br.unesp.rc.springjpa.dto.assembler.FisicaAssembler;
import br.unesp.rc.springjpa.entidade.Fisica;
import br.unesp.rc.springjpa.entidade.mapeador.FisicaMapeador;
import br.unesp.rc.springjpa.serviço.FisicaServiço;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marcos
 */
@RestController
@RequestMapping("/entidade/v1")
public class FisicaRecurso {
    
    @Autowired
    private FisicaServiço fisicaServiço;
    
    @GetMapping("/")
    public List<Fisica> getAllFisica(){
            return fisicaServiço.findAll();
    }
    
    @GetMapping("/{cpf}")
     public Fisica getFisicaByCpf(@PathVariable(value = "cpf") String cpf) {
        Fisica fisica = fisicaServiço.findByCpf(cpf);
        return fisica;
      }
     
     
     @DeleteMapping("/{cpf}")
     public boolean delete(@PathVariable(value = "cpf") String cpf){
         boolean delete = false;
         Fisica fisica = fisicaServiço.findByCpf(cpf);
         
         if(fisica != null){
             fisicaServiço.delete(fisica);
             delete = true;
         }
         return delete;
     }
     
     @PostMapping("/")
     public boolean saveFisica(@RequestBody FisicaDTO fisicaDto){
            boolean insercao = false;
            
            Fisica fisica = FisicaAssembler.dtoToEntityModel(fisicaDto);
            Fisica fisicaInsercao = fisicaServiço.save(fisica);
            
            if(fisicaInsercao!= null){
                insercao=true;
            }
            
            return insercao;
     
     }
     
     @PutMapping("/")
     public boolean update(@RequestBody FisicaDTO fisicadto){
         boolean update =false;
         
         Fisica novoFisica = FisicaAssembler.dtoToEntityModel(fisicadto);
         Fisica fisicaAtualizacao = fisicaServiço.findByCpf(novoFisica.getCpf());
         
         FisicaMapeador.update(fisicaAtualizacao, novoFisica);
         
         Fisica fisicaAtualizado = fisicaServiço.update(fisicaAtualizacao);
         
         System.out.println(fisicaAtualizacao.getNome());
         
         if(fisicaAtualizado!=null){
             update=true;
         }
         
         return update;
         
     }
     
    
    
}
