package controller;

import model.Observer;
import model.ServidorModel;
import view.ViewTemperatura;

public class TempController implements Observer {

    private ViewTemperatura view;
    private ServidorModel model;

    public TempController(ViewTemperatura view, ServidorModel model) {
        this.setView(view);
        this.model = model;

        this.model.addObserver(this);

    }

    public void pegarDados() {
        if (this.getModel().getCidadeSelecionada() != null) {
            this.getView().setCidade(this.getModel().getCidadeSelecionada().toString());
            this.getView().setTemperatura(this.getModel().getCidadeSelecionada().getTemp() + "º");
        }else{
            this.getView().setCidade("");
            this.getView().setTemperatura("");
            
        }
    }

    public ViewTemperatura getView() {
        return view;
    }

    public void setView(ViewTemperatura view) {
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
