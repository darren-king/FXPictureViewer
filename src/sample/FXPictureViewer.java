package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class FXPictureViewer extends Application{

    //Declare components at class scope


    MenuBar mBar;
    Menu File;
    MenuItem Open;

    ImageView imgV;

    Label lblFilePath;


    @Override
    public void init(){

        //Instantiate the components

        mBar = new MenuBar();
        File = new Menu("File");
        Open = new MenuItem("Open");

        Open.setOnAction(actionEvent -> openFile());

        File.getItems().add(Open);
        mBar.getMenus().add(File);


        imgV = new ImageView();
        imgV.setFitWidth(300);
        imgV.setFitHeight(300);

        lblFilePath = new Label();

    } //end of init



    public void openFile(){

            Stage secondaryStage = new Stage();

            FileChooser fc = new FileChooser();
            fc.setTitle("Select Image");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg"));

            java.io.File myPictureFile = fc.showOpenDialog(secondaryStage);

            Image img = new Image(myPictureFile.toURI().toString());

            lblFilePath.setText(myPictureFile.getAbsolutePath());

            imgV.setImage(img);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        // Create a stage

        primaryStage = new Stage();
        primaryStage.setTitle("FX Picture Viewer");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);


        // Create a layout - a VBox should suffice

        HBox hb = new HBox();
        hb.getChildren().add(imgV);
        hb.setAlignment(Pos.CENTER);


        VBox vb = new VBox();
        vb.getChildren().addAll(mBar, hb, lblFilePath);
        vb.setSpacing(10);

        //Create a scene

        Scene sc = new Scene(vb);


        //Set the scene on the stage

        primaryStage.setScene(sc);


        // Showtime!

        primaryStage.show();





    } // end of start


    public static void main(String args[]){
        launch(args);
    }


    public void exit(){
        Platform.exit();
    }







}