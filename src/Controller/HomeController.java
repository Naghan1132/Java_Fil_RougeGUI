package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML private Button morpionB;

    @FXML
    private void onClick(ActionEvent e) {
        if (e.getSource().equals(morpionB)) {
            System.out.println("cliked");
        }
    }
}
