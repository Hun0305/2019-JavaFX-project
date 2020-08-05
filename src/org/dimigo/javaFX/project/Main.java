package org.dimigo.javaFX.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        IndexIO.readIndex();
        WordIO.loadClassicalWords();
        WordIO.loadQuestionWords();
        DateIO.loadDate();
        UserSetIO.readUserSet();
        if(DateIO.checkDate())
            IndexIO.chooseRandom();


        Font.loadFont(getClass().getResourceAsStream("NanumBarunGothic-YetHangul.ttf"), 14);
        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        primaryStage.setTitle("Korean WordMaster");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
