import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;

//maybe add this eventually? driver updates through this program
//https://decentsecurity.com/drivers-through-wsus/
//then the program will need a file server, wake-on-lan server, and WSUS server
//https://www.google.com/search?q=pfsense+windows+updates

//TO-DO: make the buttons call functions that correspond to their names
//define each function

public class MainFX extends Application {
    //instance variables
    BorderPane bPane = new BorderPane();
    GridPane gPane = new GridPane();
    VBox box = new VBox();
    TextArea bottomOutput = new TextArea("testing hello 123");
    Button about;
    Button viewLogs;
    Button configureScheduling;
    Button backupSettings;
    
    Button oneClickRun;
    Button updateAutoAMP;
    Button updateOS;
    Button updatePrograms;
    
    Button briefScan;
    Button thoroughScan;
    Button scanFile;
    Button backUpFiles;
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        buildUI();
        customizeUI();
        registerEvents();
        
        Scene scene = new Scene(bPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AutoAMP Endpoint Management GUI");
        primaryStage.show();
    }
    
    public void buildUI() {
        about = new Button("About");
        about.setMinWidth(130);
        viewLogs = new Button("View Logs");
        viewLogs.setMinWidth(130);
        configureScheduling = new Button("Scheduling");
        configureScheduling.setMinWidth(130);
        backupSettings = new Button("Server Settings");
        backupSettings.setMinWidth(130);
        
        //buttons to instance vars!!!
        oneClickRun = new Button("Run All");
        oneClickRun.setMinWidth(130);
        updateAutoAMP = new Button("Update AutoAMP");
        updateAutoAMP.setMinWidth(130);
        updateOS = new Button("Update OS");
        updateOS.setMinWidth(130);
        updatePrograms = new Button("Update Programs");
        updatePrograms.setMinWidth(130);
        
        
        briefScan = new Button("Brief Scan");
        briefScan.setMinWidth(130);
        thoroughScan = new Button("Thorough Scan");
        thoroughScan.setMinWidth(130);
        scanFile = new Button("Scan File");
        scanFile.setMinWidth(130);
        backUpFiles = new Button("Back Up Files");
        backUpFiles.setMinWidth(130);
        
        gPane.add(about, 0, 0);
        gPane.add(viewLogs, 1, 0);
        gPane.add(configureScheduling, 2, 0);
        gPane.add(backupSettings, 3, 0);
        
        gPane.add(oneClickRun, 0, 1);
        gPane.add(updateAutoAMP, 1, 1);
        gPane.add(updateOS, 2, 1);
        gPane.add(updatePrograms, 3, 1);
        
        gPane.add(briefScan, 0, 2);
        gPane.add(thoroughScan, 1, 2);
        gPane.add(scanFile, 2, 2);
        gPane.add(backUpFiles, 3, 2);
        
        
        
        bPane.setCenter(gPane);
        
        // for (Node node : bottomOutput.lookupAll(".scroll-pane"))
        // {
            // if (node instanceof ScrollPane)
            // {
                // ((ScrollPane) node).setVbarPolicy(ScrollBarPolicy.ALWAYS);
            // }
        // }
        
        
        
        
        
        box.getChildren().add(bottomOutput);
        
        
        bPane.setBottom(box);
        
    }
    

    
    public void customizeUI() {
        gPane.setHgap(10);
        gPane.setVgap(10);
        box.setSpacing(10);
        bPane.setPadding(new Insets(10, 10, 10, 10));
        gPane.setPadding(new Insets(0, 0, 10, 0));
        
        //testing, remove this later
        bottomOutput.appendText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        bottomOutput.appendText("Progress output will be displayed here.\n");
        bottomOutput.appendText("This program is not finished yet.");
    }
    
    public void registerEvents() {
        //setOnAction lambda expressions
        
        
        //test for TextArea
        about.setOnAction(e -> { 
            bottomOutput.appendText("\nmore text");
        });
    }
    
}