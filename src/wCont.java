import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class wCont {



    public void startApp(){
        try {
            Parent pane = FXMLLoader.load(
                    getClass().getResource("parameters.fxml"));
            Main.primaryStage.getScene().setRoot(pane);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
