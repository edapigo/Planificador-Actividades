package projectopoo1;



import Registro.FXMLRegistroController;
import Usuarios.usuariosAPP;
import VentanaPrincipal.CalendarioInicioController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLLoginController implements Initializable {

    private float xOffset = 0f;
    private float yOffset = 0f;
    @FXML
    public TextField us;
    @FXML
    public PasswordField cot;
    @FXML
    private Button btn1Registro;
    @FXML
    private Button inicio;
    @FXML
    public Label prueba;

    //metodos
    @FXML
    private void Datos(ActionEvent e) {

        if (us.getText().isEmpty()== false && cot.getText().isEmpty() == false) {
            validateLogin();
        }else{
            prueba.setText("Ingresa tu usuario y contraseña");
        }
    }
    @FXML
    private void salir(ActionEvent e){
        System.exit(0);
    }

    @FXML
    private void Registro(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Registro/FXMLRegistro.fxml"));

            Parent root = loader.load();

            FXMLRegistroController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);

            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = (float) event.getSceneX();
                    yOffset = (float) event.getSceneY();
                }
            });
            scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controlador.CerrarVentana());

            Stage myStage = (Stage) this.btn1Registro.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void CalendarioDeEvento() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VentanaPrincipal/CalendarioInicio.fxml"));

            Parent root = loader.load();

            CalendarioInicioController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);

            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = (float) event.getSceneX();
                    yOffset = (float) event.getSceneY();
                }
            });
            scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controlador.CerrarVentana());

            Stage myStage = (Stage) this.inicio.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void validateLogin() {
        usuariosAPP user1 = new usuariosAPP("eduardo", "12345678", "eduardo3@gmail.com");
        if (user1.getUsusario().equals(us.getText()) && user1.getContra().equals(cot.getText())) {
            prueba.setText("iniciando......");
            CalendarioDeEvento();
        }else{
            prueba.setText("Usuario y contrseña incorrecta");
            us.setText("");
            cot.setText("");
        }
    }

    

}