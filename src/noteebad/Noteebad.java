/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteebad;
import java.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */
public class Noteebad extends Application {
    
      MenuBar bar;
 //file menu
 Menu file;
 MenuItem newItem1;
 MenuItem newItem2;
 MenuItem newItem3;
 MenuItem newItem4;
 //edit
 Menu edit;
 MenuItem ed1;
 MenuItem ed2;
 MenuItem ed3;
 MenuItem ed4;
 MenuItem ed5;
 MenuItem ed6;
 //help
 Menu help;
 MenuItem h;
 
 TextArea txt;
    @Override
    public void start(Stage primaryStage) {
        
       bar = new MenuBar();
        
        //file menu
        file  = new Menu("file");
        
        newItem1 = new MenuItem("new");
        newItem2 = new MenuItem("open..");
        newItem3 = new MenuItem("save");
        newItem4 = new MenuItem("exit");
        file.getItems().addAll(newItem1,newItem2, newItem3 , newItem4 );
        
        
        //menu edit
        edit = new Menu("edit");
        
        ed1 = new MenuItem("undo");
        ed2 = new MenuItem("cut");
        ed3 = new MenuItem("copy");
        ed4 = new MenuItem("paste");
        ed5 = new MenuItem("delete");
        ed6 = new MenuItem("selectAll");
        edit.getItems().addAll(ed1 , ed2,ed3,ed4,ed5,ed6);
        
        
        //menu Help
        help = new Menu("help");
        h = new MenuItem("help");
        help.getItems().addAll(h);
        
        bar.getMenus().addAll(file, edit , help);
        
        txt = new TextArea(); 
        
        
        
        BorderPane root = new BorderPane(txt);
        root.setTop(bar);
        
        /************file********/
        //new
        newItem1.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               txt.setText(" ");
           }
        });
        //open   reading from file
        newItem2.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               FileInputStream fis=null;
               try {
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   fis = new FileInputStream("C:\\Users\\Nada\\Desktop\\notepad.txt");
                   int size = fis.available();
                   byte[] b = new byte[size];
                   fis.read(b);
                   System.out.println(new String(b));
                   txt.setText(new String(b));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Noteebad.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Noteebad.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               //String str = new String();
              // str = txt.getText();
               //System.out.println(str);
           }
        });
        //save in to file
        newItem3.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               FileOutputStream fos = null;
               try {
                   fos = new FileOutputStream("C:\\Users\\Nada\\Desktop\\notepad.txt");
                   byte [] b = txt.getText().getBytes();
                   fos.write(b);
                   fos.close();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Noteebad.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Noteebad.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        });
        
        //exit
        newItem4.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
              primaryStage.close();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
        });
        
        /*************edit*******/
        //undo
        ed1.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               txt.undo();
           }
        });
        //cut
        ed2.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
              // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              txt.cut();
           }
        });
        //copy
        ed3.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               txt.copy();
           }
        });
        //paste
        ed4.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               txt.paste();
           }
        });
        //delete
       ed5.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               //txt.getSelectedText().
               //txt.deleteText(null);
               txt.setText(txt.getText().replace(txt.getSelectedText(), " "));
           }
       });
       //selectAll
       ed6.setOnAction(new EventHandler<ActionEvent>(){

           @Override
           public void handle(ActionEvent event) {
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               txt.selectAll();
           }
       });
       
       h.setOnAction(new EventHandler<ActionEvent>(
       ) {

           @Override
           public void handle(ActionEvent event) {
               Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("Look, an Information Dialog");
alert.setContentText("I can help you!");

alert.showAndWait();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
       
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
