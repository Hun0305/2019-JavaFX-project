package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SetController implements Initializable {
    @FXML private Button btn_Today;
    @FXML private Button btn_View;

    @FXML private ComboBox<String> cbClass1;
    @FXML private ComboBox<String> cbClass2;
    @FXML private ComboBox<String> cbClass3;


    @FXML
    // 버
    public void initialize(URL location, ResourceBundle resources) {
        cbClass1.getItems().addAll("무작위 어휘", "고전 어휘", "선택지 어휘");
        cbClass2.getItems().addAll("무작위 어휘", "고전 어휘", "선택지 어휘");
        cbClass3.getItems().addAll("무작위 어휘", "고전 어휘", "선택지 어휘");

        UserSetIO.readUserSet();

        cbClass1.promptTextProperty().setValue(UserSetIO.userset[0]);
        cbClass2.promptTextProperty().setValue(UserSetIO.userset[1]);
        cbClass3.promptTextProperty().setValue(UserSetIO.userset[2]);
    }

    @FXML
    public void handleTodayAction(ActionEvent event) throws IOException {
        Stage stage3 = (Stage) btn_Today.getScene().getWindow();
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/application.fxml"));

        Parent root3 = loader3.load();
        Scene scene3 = new Scene(root3);
        stage3.setScene(scene3);
        stage3.centerOnScreen();
        stage3.show();
    }

    public void handleViewAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_View.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/view.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void handleEnterAction(ActionEvent event) {
        String[] temp = new String[3];
        temp[0] = cbClass1.getValue();
        temp[1] = cbClass2.getValue();
        temp[2] = cbClass3.getValue();

        for (int i = 0; i < 3; i++) {
            if (temp[i] == null)
                temp[i] = UserSetIO.userset[i];
        }

        UserSetIO.writeUserSet(temp);
    }

}
