/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class LoginForm extends Application {
    protected Stage mystage = null;
    @Override
    public void start(Stage primaryStage) {
        //1. add label Login Form/Occupies 2 columns
        GridPane gp = new GridPane();
        Label lblTitle = new Label("Login Form");
        gp.add(lblTitle, 0, 0, 2, 1);
        
        //2. second row, add uname and textbox
        Label lblUsr = new Label("User Name");
        TextField tfUser = new TextField();
        tfUser.setId("tfUser");
        gp.add(lblUsr, 0, 1);
        gp.add(tfUser, 1, 1);
        
        //3. third row, add password
        Label lblPwd = new Label("Password");
        PasswordField pf = new PasswordField();
        pf.setId("pf");
        gp.add(lblPwd, 0, 2);
        gp.add(pf, 1, 2);
        
        //4. add Button
        Button btn = new Button();
        btn.setId("btnLogin");
        btn.setText("Login");
        gp.add(btn, 1, 3);
        
        //5. add handler
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String uname = tfUser.getText();
                String pwd = pf.getText();
                Alert al = new Alert(AlertType.INFORMATION);
                al.setContentText(uname + " log in using pwd: " + pwd);
                al.showAndWait();
            }
        });
        
                
        Scene scene = new Scene(gp, 300, 250);
        scene.getStylesheets().add(
                loginform.LoginForm.class.getResource("newCascadeStyleSheet.css").toExternalForm()
        );
        
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.mystage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
