
import model.Cidade;
import model.ServidorModel;
import view.ViewClima;
import view.ViewPainel;
import view.ViewTemperatura;


public class Teste {
    
    static void iniciarViews(ViewTemperatura vTemp, ViewPainel vPainel, ViewClima vClima ){
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               vTemp.setVisible(true);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vPainel.setVisible(true);
            }
        });
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vClima.setVisible(true);
            }
        });
    }
     
    public static void main (String args[]){
  
        ServidorModel serv = new ServidorModel();
      
        serv.addCidade(new Cidade("Russas","CE"));
        serv.addCidade(new Cidade("Jaguaruana","CE"));
        serv.addCidade(new Cidade("Fortaleza","CE"));
        serv.addCidade(new Cidade("Natal","RN"));
       
        ViewTemperatura vTemp=  new ViewTemperatura(serv);
        ViewPainel vPainel = new ViewPainel(serv);
        ViewClima vClima = new ViewClima(serv) ;
        
        Teste.iniciarViews(vTemp, vPainel, vClima);
        
    }
}
