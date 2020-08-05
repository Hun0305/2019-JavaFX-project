package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    @FXML private Button btn_Today;
    @FXML private Button btn_View;
    @FXML private Button btn_Setting;

    @FXML private VBox VBox_Word;
    @FXML private VBox VBox_Meaning;
    @FXML private VBox VBox_Sentence;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < WordIO.words.size(); i++) {
            Text text = new Text(WordIO.words.get(i).getIndex()  + ". " + WordIO.words.get(i).getWord());
            Text text2 = new Text(WordIO.words.get(i).getIndex() + ". " + WordIO.words.get(i).getMeaning());
            Text text3 = new Text(WordIO.words.get(i).getIndex() + ". " + WordIO.words.get(i).getSentence());

            if (text != null)
                VBox_Word.getChildren().add(text);

            if (text2 != null)
                VBox_Meaning.getChildren().add(text2);

            if (text2 != null)
                VBox_Sentence.getChildren().add(text3);
        }
    }

    public void handleTodayAction(ActionEvent event) throws IOException {
        Stage stage3 = (Stage) btn_Today.getScene().getWindow();
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/application.fxml"));

        Parent root3 = loader3.load();
        Scene scene3 = new Scene(root3);
        stage3.setScene(scene3);
        stage3.centerOnScreen();
        stage3.show();
    }

    public void handleSettingAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_Setting.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/setting.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
