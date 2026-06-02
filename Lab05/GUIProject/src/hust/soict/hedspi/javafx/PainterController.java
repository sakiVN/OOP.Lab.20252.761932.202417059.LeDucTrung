package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {

        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {

        Color color;

        // Pen
        if (penButton.isSelected()) {

            color = Color.BLACK;

        }
        // Eraser
        else {

            color = Color.WHITE;
        }

        Circle newCircle = new Circle(
                event.getX(),
                event.getY(),
                4,
                color
        );

        drawingAreaPane
                .getChildren()
                .add(newCircle);
    }
}