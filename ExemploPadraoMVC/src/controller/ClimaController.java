package controller;

import javax.swing.ImageIcon;
import model.Observer;
import model.ServidorModel;
import view.ViewClima;

public class ClimaController implements Observer{
    private ViewClima view;
    private ServidorModel model;

    public ClimaController(ViewClima view, ServidorModel model) {
        this.view = view;
        this.model = model;
        this.model.addObserver(this);
   
    }

    public void pegarDados() {
      
        if (this.getModel().getCidadeSelecionada() != null) {
            this.getView().setCidade(this.getModel().getCidadeSelecionada().toString());
            this.getView().setTemperatura(this.getModel().getCidadeSelecionada().getTemp() + "º");
            String clima = this.getModel().getCidadeSelecionada().getClima();
            
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/"+clima+".png"));
            this.getView().getImg().setIcon(icon);
            this.getView().getImg().setVisible(true);
            
        }else{
       
            this.getView().getImg().setIcon(null);
            this.getView().setCidade("");
            this.getView().setTemperatura("");
            
        }
    }
    
    public ViewClima getView() {
        return view;
    }

    public void setView(ViewClima view) {
        this.view = view;
    }

    public ServidorModel getModel() {
        return model;
    }

    public void setModel(ServidorModel model) {
        this.model = model;
    }

    @Override
    public void update() {
        this.pegarDados();
    }    
}
