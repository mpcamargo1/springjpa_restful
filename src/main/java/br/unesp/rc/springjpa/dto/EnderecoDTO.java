/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author marcos
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EnderecoDTO {
    
        private String rua;
        private int numero;
        private String bairro;
        private String cep;
        private String cidade;
        private String estado;
        
        public EnderecoDTO() {
       
        }
        
        public EnderecoDTO(String rua, int numero, String bairro,
        String cep, String cidade, String estado) {
                this.rua = rua;
                this.numero = numero;
                this.bairro = bairro;
                this.cep = cep;
                this.cidade = cidade;
                this.estado = estado;
        }
    
}