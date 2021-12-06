/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.serviço;

import br.unesp.rc.springjpa.entidade.Fisica;
import br.unesp.rc.springjpa.repositório.FisicaRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 *
 * @author marcos
 */
@Component
public class FisicaServiço {
    
    @Autowired
    private FisicaRepositorio repositorio;
    
    public FisicaServiço(){
    
    }
    
    public Fisica save(Fisica entity){
        Fisica persistedEntity = null;
        
        if (repositorio != null){
            persistedEntity = repositorio.save(entity);
        }
        return persistedEntity;
    }
    
    public Fisica findByCpf(String cpf){
        Fisica insertedEntity = null;
        
        if(repositorio != null){
            insertedEntity = repositorio.findByCpf(cpf);
        }
        
        return insertedEntity;
    }
    
    public void delete(Fisica entity){
        if(repositorio != null){
            repositorio.delete(entity);
        }
    }
    
    public Fisica update(Fisica entity){
        Fisica persistedEntity = null;
        
        if(repositorio!=null){
            persistedEntity = repositorio.save(entity);
        }
        return persistedEntity;
    }
    
    public List<Fisica> findAll(){
        List<Fisica> list = null;
        
        if(repositorio != null){
            list = new ArrayList<>();
            list = repositorio.findAll();
        }
        
        return list;
    }
    
}
