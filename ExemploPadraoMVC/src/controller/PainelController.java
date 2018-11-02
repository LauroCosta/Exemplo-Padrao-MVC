package controller;

import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cidade;
import model.Observer;
import model.ServidorModel;
import view.ViewPainel;

public class PainelController implements Observer {

    private ViewPainel view;
    private ServidorModel model;

    public PainelController(ViewPainel view, ServidorModel model) {
        this.setModel(model);
        this.setView(view);
        this.getModel().addObserver(this);

    }

    public void trataEvento(ActionEvent evt) {

        switch (evt.getActionCommand()) {

            case "comboCidade":
                if (this.getView().getCidade().getSelectedItem().equals(" ")) {

                    this.ativaComponente(false);
                    this.model.setCidadeSelecionada(null);
                    this.getView().getCampoTemp().setText(" º");

                } else {

                    this.ativaComponente(true);

                    String cidadeSelecionada = (String) this.getView().getCidade().getSelectedItem();
                    Cidade cidade = this.getModel().buscarCidade(cidadeSelecionada);
                    this.model.setCidadeSelecionada(cidade);
                    float temp = Float.parseFloat(cidade.getTemp());
                    this.getView().getCampoTemp().setText(temp + " º");
                    this.getView().getComboClima().setSelectedItem(cidade.getClima());
                }
                break;

            case "comboClima":

                if (!this.getView().getComboClima().getSelectedItem().equals(" ")) {
                    String clima = (String) this.getView().getComboClima().getSelectedItem();
                    this.getModel().mudarClima(clima);
                } else {
                    String climaAtual = this.getModel().getCidadeSelecionada().getClima();
                    this.getView().getComboClima().setSelectedItem(climaAtual);
                }
                break;

            case "diminuir":

                this.getModel().diminuirTemp();

                break;

            case "aumentar":

                this.getModel().aumentarTemp();
                break;

            case "salvar":

                String nome = this.tratarNome(this.getView().getNomeNovaCidade().getText());
                String estado = this.getView().getSiglaEstado().getText();
                
                
                
                if (nome.length() == 0 || estado.length() == 0) {

                    this.msgErro("Campos obrigatórios");

                } else if (this.getModel().isCadastrada(nome)) {

                    this.msgErro("Cidade já cadastrada");

                } else {

                    this.getModel().addCidade(new Cidade(nome, estado));
                    int tam = this.getModel().getCidades().size() - 1;
                    Cidade ultima = this.getModel().getCidades().get(tam);
                    this.getView().getCidade().addItem(ultima.toString());
                    this.msgErro("Salvo com sucesso!");

                }

                break;

        }
    }

    private void ativaComponente(boolean is) {

        this.getView().getComboClima().setEnabled(is);
        this.getView().getCampoTemp().setEnabled(is);
        this.getView().getBtAumentar().setEnabled(is);
        this.getView().getBtDiminuir().setEnabled(is);
        this.getView().getCampoTemp().setEditable(false);

    }

    private void msgErro(String msg) {

        this.getView().getAviso().setText(msg);
    
    }

    public void povoarCidade() {
        ArrayList nomes = this.getModel().listaCidades();
        for (Object nome : nomes) {
            this.getView().getCidade().addItem((String) nome);
        }

    }

    public ViewPainel getView() {
        return view;
    }

    public void setView(ViewPainel view) {

        if (view != null) {
            this.view = view;
        }
    }

    public ServidorModel getModel() {
        return model;
    }

    public void setModel(ServidorModel model) {
        if (model != null) {
            this.model = model;
        }
    }

    @Override
    public void update() {

        if (this.getModel().getCidadeSelecionada() != null) {
            this.getView().getCampoTemp().setText(this.getModel().getCidadeSelecionada().getTemp() + " º");
        }

        this.getView().getNomeNovaCidade().setText("");
        this.getView().getSiglaEstado().setText("");

    }

        private String tratarNome(String nome){
        
        String saida = nome.toLowerCase();
        saida = StringUtils.capitalize(saida);
       
        return saida;
    }
    
    
}
