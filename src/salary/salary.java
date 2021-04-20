package salary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class salary extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label name = new Label();
        name.setText("Name");
        TextField tf1 = new TextField();
        
        Label age = new Label();
        age.setText("Age");
        TextField tf2 = new TextField();
        
        Label jnDate = new Label();
        jnDate.setText("Joining Date");
        TextField tf3 = new TextField();
        
        ComboBox combo = new ComboBox();
        combo.getItems().add("Manager");
        combo.getItems().add("Executive");
        combo.getItems().add("Officer");
        combo.setPromptText("Select Position");
        
        
        
        Label basic = new Label();
        basic.setText("Basic");
        TextField tf5 = new TextField();
        
        Button calculate = new Button();
        calculate.setText("Calculate");
        
        TextArea ta = new TextArea();        
        
        VBox layout = new VBox();
        layout.getChildren().addAll(name, tf1, age, tf2, jnDate, tf3, combo, basic, tf5, calculate, ta);
        layout.setSpacing(5);
        
        calculate.setOnAction( e -> {
        
            ta.setText("Name : "+tf1.getText());
            ta.setText(ta.getText() + "\nAge : "+tf2.getText());
            ta.setText(ta.getText() + "\nJoining Date : "+tf3.getText());
            
            String value = (String) combo.getValue();
            
            String value2 = tf5.getText();
            int bs = Integer.parseInt(value2);
            
            double hr, medic, tax;
           
            
            if(value == "Manager")
            {
                hr = bs*0.60;
                medic = bs * 0.20;
                tax = bs * 0.10;
            }
            else if ( value == "Executive")
            {
                hr = bs*0.50;
                medic = bs * 0.10;
                tax = bs * 0.05;
            }
            else
            {
                hr = bs*0.40;
                medic = bs * 0.15;
                tax = bs * 0.05;
            }
            
            
            
            ta.setText(ta.getText() + "\nPosition : " + value);
            ta.setText(ta.getText() + "\nBasic : "+tf5.getText());
            ta.setText(ta.getText() + "\nHR : "+hr);
            ta.setText(ta.getText() + "\nMedical : "+medic);
            ta.setText(ta.getText() + "\nTax : "+tax);
            
            double total_salary = bs + hr + medic - tax;
            
            ta.setText(ta.getText() + "\nTotal Salary : "+ total_salary);        
        });
        
        Scene scene = new Scene(layout, 500, 500);
        
        primaryStage.setTitle("Calculating Salary.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
