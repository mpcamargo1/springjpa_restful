/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.serviço;


import br.unesp.rc.springjpa.entidade.Fisica;
import br.unesp.rc.springjpa.utilidade.GeradorInstância;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author marcos
 */
@SpringBootTest
public class FisicaServiçoTest {
    
    private Fisica entity;
    
    @Autowired
    private FisicaServiço fs = new FisicaServiço();
    
    //@Disabled
    @Test
    @DisplayName("FisicaServiço.save(Fisica)")
    void testSave() {
        entity = GeradorInstância.getPessoaFisica("222.333.444-55","user1");
        System.out.println(entity);
        Fisica f = fs.save(entity);
        System.out.println("----------------------------------------");
        System.out.println(f);
        System.out.println("----------------------------------------");
        assertEquals(entity, f);
    }
    
    @Disabled
    @Test
    @DisplayName("FisicaServiço.findByCpf(cpf)")
    void testFindByCpf() {
        entity = GeradorInstância.getPessoaFisica("222.333.444-55","user1");
        String cpf = "222.333.444-55";
        Fisica f = fs.findByCpf(cpf);
        System.out.println("----------------------------------------");
        System.out.println(f);
        System.out.println("----------------------------------------");
        assertEquals(entity, f);
    }        
    
    
    @Disabled
    @Test
    public void testDelete() {
    //...
    }
    @Disabled
    @Test
    public void testUpdate() {
    //...
    }
    @Disabled
    @Test
    @DisplayName("FisicaServiço.findAll()")
    public void testFindAll() {
        System.out.println("findAll");
        Fisica expResult = null;
        List<Fisica> result = fs.findAll();
        for (Fisica f : result){
        System.out.println("FISICA: " + f);
        }
        assertNotEquals(expResult, result);
    }
  
    
}
