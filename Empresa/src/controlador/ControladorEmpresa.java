/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoEmpresa;
import javax.swing.JOptionPane;
import modelo.Empresa;
import tela.manutencao.ManutencaoEmpresa;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorEmpresa {

    public static void inserir(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        objeto.setRazao_social(man.jtfRazao_social.getText());
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        
        boolean resultado = DaoEmpresa.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setRazao_social(man.jtfRazao_social.getText());
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        
        boolean resultado = DaoEmpresa.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoEmpresa.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    
   public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome Fantasia");
        modelo.addColumn("Razão Social");
        List<Empresa> resultados = DaoEmpresa.consultar();
        for (Empresa objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome_fantasia());
            linha.add(objeto.getRazao_social());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    } 
    
}
