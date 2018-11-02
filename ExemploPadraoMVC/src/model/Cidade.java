package model;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Random;

public class Cidade {
  
    private String nome;
    private String estado;
    private String clima;
    private String temp;

    public Cidade(){
   
    }
    
    public Cidade(String nome, String estado) {
        
        Random r = new Random();
     
        this.nome = this.tratarNome(nome);
        this.estado = estado.toUpperCase();
        this.clima = "Chuva";   
        this.temp =   10 + r.nextInt(47)+"";   
        
    }
 
    public String getNome() {
        return nome;
    }

    private String tratarNome(String nome){
        
        String saida = nome.toLowerCase();
        saida = StringUtils.capitalize(saida);
       
        return saida;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
   
        this.clima = clima;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return  nome + " " + estado;
    }
    
    
}
