package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button btn_Today;
    @FXML private Button btn_View;
    @FXML private Button btn_Setting;

    @FXML private Label lbl_1stIndex;
    @FXML private Label lbl_1stWord;
    @FXML private Label lbl_1stClass;
    @FXML private VBox VBox_1stMean;
    @FXML private VBox VBox_1stSentence;

    @FXML private Label lbl_2ndIndex;
    @FXML private Label lbl_2ndWord;
    @FXML private Label lbl_2ndClass;
    @FXML private VBox VBox_2ndMean;
    @FXML private VBox VBox_2ndSentence;

    @FXML private Label lbl_3rdIndex;
    @FXML private Label lbl_3rdWord;
    @FXML private Label lbl_3rdClass;
    @FXML private VBox VBox_3rdMean;
    @FXML private VBox VBox_3rdSentence;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_1stIndex.setText((IndexIO.firstIndex + 1) + ".");
        lbl_1stWord.setText(WordIO.words.get(IndexIO.firstIndex).getWord());
        lbl_1stClass.setText(WordIO.words.get(IndexIO.firstIndex).getClassification());
        VBox_1stMean.getChildren().add(new Text("뜻: " + WordIO.words.get(IndexIO.firstIndex).getMeaning()));
        VBox_1stSentence.getChildren().add(new Text("예문: " + WordIO.words.get(IndexIO.firstIndex).getSentence()));

        lbl_2ndIndex.setText((IndexIO.secondIndex + 1) + ".");
        lbl_2ndWord.setText(WordIO.words.get(IndexIO.secondIndex).getWord());
        lbl_2ndClass.setText(WordIO.words.get(IndexIO.secondIndex).getClassification());
        VBox_2ndMean.getChildren().add(new Text("뜻: " + WordIO.words.get(IndexIO.secondIndex).getMeaning()));
        VBox_2ndSentence.getChildren().add(new Text("예문: " + WordIO.words.get(IndexIO.secondIndex).getSentence()));

        lbl_3rdIndex.setText((IndexIO.thirdIndex + 1) + ".");
        lbl_3rdWord.setText(WordIO.words.get(IndexIO.thirdIndex).getWord());
        lbl_3rdClass.setText(WordIO.words.get(IndexIO.thirdIndex).getClassification());
        VBox_3rdMean.getChildren().add(new Text("뜻: " + WordIO.words.get(IndexIO.thirdIndex).getMeaning()));
        VBox_3rdSentence.getChildren().add(new Text("예문: " + WordIO.words.get(IndexIO.thirdIndex).getSentence()));
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