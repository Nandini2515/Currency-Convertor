package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Currency Converter");

        TextField textField = new TextField("");
        ComboBox<String> recent = new ComboBox();
        recent.getItems().addAll("US Dollar","Taiwan Dollar","Japan Yen","Euro","Renminbi");
        Button exchange = new Button("<->");
        ComboBox<String> after = new ComboBox();
        after.getItems().addAll("Taiwan Dollar","US Dollar","Japan Yen","Euro","Renminbi");
        Button change = new Button("Convert");
        Text result = new Text("");

        HBox a = new HBox();
        a.getChildren().addAll(recent,exchange,after);
        VBox out = new VBox(10);
        out.setPadding(new Insets(30,30,30,30));
        out.getChildren().addAll(textField,a,change,result);

        Scene sc = new Scene(out,300,300);
        stage.setScene(sc);
        stage.show();


        exchange.setOnAction(e -> {
            String now_currency = recent.getValue();
            String after_currency = after.getValue();
            recent.setValue(after_currency);
            after.setValue(now_currency);
        });


        change.setOnAction(e -> {
            float money = Float.parseFloat(textField.getText());
            float ans = 0;
            String now_currency = recent.getValue();
            String after_currency = after.getValue();



            if(now_currency.equals("Taiwan Dollar")){
                money = (float) ((1/29.42) * money);
            }
            else if(now_currency.equals("Japan Yen")){
                money = (float) ((1/124.819687) * money);
            }
            else if(now_currency.equals("Euro")){
                money = (float) ((1/0.913381) * money);
            }
            else if(now_currency.equals("Renminbi")){
                money = (float) ((1/6.347357) * money);
            }


            if(after_currency.equals("Taiwan Dollar")){
                ans = (float) (money * 29.42);
            }
            else if(after_currency.equals("Japan Yen")){
                ans = (float) (money * 124.819687);
            }
            else if(after_currency.equals("Euro")){
                ans = (float) (money * 0.913381);
            }
            else if(after_currency.equals("Renminbi")){
                ans = (float) (money * 6.347357);
            }
            else if(after_currency.equals("US Dollar")){
                ans = money;
            }
            result.setText(textField.getText() + now_currency + " = " + ans + after_currency);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}