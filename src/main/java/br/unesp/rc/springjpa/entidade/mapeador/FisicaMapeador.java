/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.springjpa.entidade.mapeador;

import br.unesp.rc.springjpa.entidade.Acesso;
import br.unesp.rc.springjpa.entidade.Contato;
import br.unesp.rc.springjpa.entidade.Endereco;
import br.unesp.rc.springjpa.entidade.Fisica;

/**
 *
 * @author marcos
 */
public class FisicaMapeador {
    
    private FisicaMapeador(){
    
    }
    
    public static void update(Fisica fisicaAtualizacao, Fisica novoFisica){
        fisicaAtualizacao.setDataNascimento(novoFisica.getDataNascimento());
        fisicaAtualizacao.setNome(novoFisica.getNome());
        
        Acesso a = fisicaAtualizacao.getAcesso();
        a.setUsuario(novoFisica.getAcesso().getUsuario());
        a.setSenha(novoFisica.getAcesso().getSenha());
        fisicaAtualizacao.setAcesso(a);
        
        Contato c = fisicaAtualizacao.getContato();
        c.setTelefoneResidencial(novoFisica.getContato().getTelefoneResidencial());
        c.setTelefoneComercial(novoFisica.getContato().getTelefoneComercial());
        c.setCelular(novoFisica.getContato().getCelular());
        c.setEmail(novoFisica.getContato().getEmail());
        fisicaAtualizacao.setContato(c);
        
        
        int i = 0;
        for (Endereco e : fisicaAtualizacao.getEndereco()){
            Endereco edto = novoFisica.getEndereco().get(i);
            e.setRua(edto.getRua());
            e.setNumero(edto.getNumero());
            e.setBairro(edto.getBairro());
            e.setCep(edto.getCep());
            e.setCidade(edto.getCidade());
            e.setEstado(edto.getEstado());
            i++;
        }
        
        
    }
    
    
    
}
