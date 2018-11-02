package model;

import java.util.ArrayList;

public class ServidorModel {

    private ArrayList<Observer> observers = new ArrayList<>();
    private Cidade cidadeSelecionada ;
    private ArrayList<Cidade> cidades;

    public ServidorModel() {

        this.cidadeSelecionada = new Cidade();
        this.cidades = new ArrayList();

    }
    
    public Cidade buscarCidade(String nome){
        
        for (Cidade cidade : cidades) {
            if(cidade.toString().equals(nome)){                
                return cidade;
            }
        }
        return null;
    }
  
    public boolean isCadastrada(String nome){
        
        for (Cidade cidade : cidades) {
            if(cidade.getNome().equals(nome)){                
                return true;
            }
        }
        return false;
    }
  
    
    
    
    public ArrayList<String> listaCidades(){
        
        ArrayList<String> lista = new ArrayList();
        lista.add(" ");
        String nome;
        for (Cidade cidade : cidades) {         
            nome = cidade.getNome() + " " + cidade.getEstado();
            lista.add(nome);
        }
        return lista;
    }
    
    public void mudarClima(String clima){
       
        this.getCidadeSelecionada().setClima(clima);
        this.notificar();
    }
    public void addObserver(Observer obs){
        
        this.observers.add(obs);

    }
    
    public void diminuirTemp(){
        
       float tempAtual = Float.parseFloat(this.cidadeSelecionada.getTemp());
       tempAtual= (float) (tempAtual - 0.5);
     
       this.getCidadeSelecionada().setTemp(tempAtual+"");
       this.notificar();
        
    }
    
    public void aumentarTemp(){
        
       float tempAtual = Float.parseFloat(this.cidadeSelecionada.getTemp());
       tempAtual= (float) (tempAtual + 0.5);
     
       this.getCidadeSelecionada().setTemp(tempAtual+"");
       this.notificar();
    
    }
    
    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void notificar(){
        
        for (Observer observer : observers) {
            observer.update();
        }
        
    }
    public void addCidade(Cidade cidade) {
       if(cidade!=null){
        this.cidades.add(cidade);
       }

       this.notificar();
    }

    public Cidade getCidadeSelecionada() {       
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(Cidade cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
        this.notificar();
    }

   
}
