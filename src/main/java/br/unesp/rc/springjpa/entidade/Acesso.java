/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author marcos
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Acesso {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="acesso_usuario",unique=true)
    private String usuario;
    @Column(name="acesso_senha")
    private String senha;
    
    public Acesso(){
        
    }
    
    
}
