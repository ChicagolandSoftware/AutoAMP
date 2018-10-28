//Lots of imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;
import java.lang.Runtime;
import java.nio.file.Files;
import java.nio.charset.Charset;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import java.util.Base64;
import java.util.Scanner;
import java.io.PrintWriter;
import javafx.scene.shape.Rectangle;
import java.awt.Desktop; //is it bad to mix JavaD
import java.awt.Desktop.*;
import javafx.event.*;
import java.awt.Toolkit;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
//import org.apache.commons.io.FileUtils;


//Single-class application for simplicity
public class MainFX extends Application {
    //instance variables
    BorderPane bPane = new BorderPane();
    GridPane gPane = new GridPane();
    VBox box = new VBox();
    StackPane sPane = new StackPane();
    Pane confirmPane = new Pane();
    HBox buttonBottomForBorder = new HBox();
    Button encryptButton;
    Button decryptButton;
    //Only pane objects need to be initialized here
    
    public static void main(String[] args) {
        Application.launch(args);
        //entry point, but do stuff in the other methods
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        //this is where the window is built, don't do anything else here
        try {
        buildUI();
        customizeUI();
        registerEvents();
        
        sPane.getChildren().add(bPane); //putting the BorderPane in a stack pane
        Scene scene = new Scene(sPane); //to do pseudo-pop ups by pushing to top of stackpane
        primaryStage.setScene(scene);
        primaryStage.setTitle("Alan's EZcrypt");
        //primaryStage.setResizable(false);
        primaryStage.show();
        } catch (Exception sfsdfgsdfg) {
            System.out.println(sfsdfgsdfg.getMessage());
        }
    }
    
    public void buildUI() {
        encryptButton = new Button("Encrypt");
        decryptButton = new Button("Decrypt");
        //bPane.add(hiding,);
        sPane.setMinWidth(500);
        sPane.setMinHeight(500);
        buttonBottomForBorder.getChildren().add(encryptButton);
        buttonBottomForBorder.getChildren().add(decryptButton);
        bPane.setBottom(buttonBottomForBorder);
        //fileType1 = new Label("Host files: PNG, GIF, or JPG/JPEG only");
        
        
        
        //bPane.setCenter(gPane);


    }
    
    public void customizeUI() {
        //not very useful, could probably merge with the buildUI
        //gPane.setHgap(10);
        //bPane.setPadding(new Insets(0, 0, 10, 0));
        
        
    }
    
    public void registerEvents() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException {
        //setOnAction lambda expressions
        //this is where all the button functionality goes
        //however, the hiding and retrieving buttons call functions that are defined below
        //System.out.println("This is where the button setOnAction or lambdas go");
        encryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Encrypting");
                boolean noPaddingError = true;
                boolean noAlgoError = true;
                boolean noKeyError = true;
                boolean nofileByteArrayIOError = true;
                Cipher encryptionCipher = null;
                try {
                    String myKey = "helloworld"; //replace with getting PasswordField.getText();
                    byte[] myKeyByteArray = myKey.getBytes(); //converts encryption key to byte array
                    SecretKeySpec myKeySpec = new SecretKeySpec(myKeyByteArray, "Blowfish");
                    try {
                        encryptionCipher = Cipher.getInstance("Blowfish");
                    } catch (NoSuchPaddingException padEx) {
                        System.out.println("no such padding exception");
                        noPaddingError = false;
                    }
                    if (noPaddingError) {
                        try {
                            encryptionCipher.init(Cipher.ENCRYPT_MODE, myKeySpec);
                        } catch (InvalidKeyException keyEx) {
                            System.out.println("invalid key exception");
                            noKeyError = false;
                        }
                    }
                } catch (NoSuchAlgorithmException algoEx) {
                    System.out.println("no such encryption algo");
                    noAlgoError = false;
                }
                //
                if (noPaddingError == false || noAlgoError == false || noKeyError == false) {
                    System.out.println("something went wrong");
                } else {
                    //actually doing the file encryption
                    String filename = "example.jpg";
                    //try {
                        
                        File fileToEncrypt = new File(filename);
                    
                    //} catch (IOException fileEx) {
                    //    System.out.println("IO error with filename: " + filename);
                    //}
                    byte[] fileByteArray = null;
                    try {
                    fileByteArray = Files.readAllBytes(fileToEncrypt.toPath());
                    
                    
                    
                    } catch (IOException ioEx) {
                        System.out.println("file IO exception with filename: " + filename);
                        nofileByteArrayIOError = false;
                    }
                    
                    if (nofileByteArrayIOError) {
                        try {
                            byte[] encryptedOutput = encryptionCipher.doFinal(fileByteArray);
                            //now the byte array needs to be converted to a file
                            //TO-DO: CONVERT encryptedOutput TO FILE, THEN WRITE TO DISK
                            //THEN TEST WITH BCRYPT FOR TESTING DECRYPTION
                            //IF IT WORKS, THEN MOVE ON TO THE decryptButton.SetOnAction stuff
                        } catch (IllegalBlockSizeException blockEx) {
                            System.out.println("illegal block size exception");
                        } catch (BadPaddingException badPadEx) {
                            System.out.println("bad padding exception");
                        }
                    } else {
                        System.out.println("wew, you got here by some miracle");
                        
                    }
                }
            }
        });
        decryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Decrypting");
            }
        });
        
    }
    

}