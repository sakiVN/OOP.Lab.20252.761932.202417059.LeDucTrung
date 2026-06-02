package hust.soict.hedspi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Tải cấu hình giao diện từ file FXML
        Parent root = FXMLLoader.load(getClass()
                .getResource("/hust/soict/hedspi/javafx/Painter.fxml"));

        // Tạo Scene (vùng chứa nội dung) từ giao diện đã tải
        Scene scene = new Scene(root);

        // Cấu hình các thông tin hiển thị cho cửa sổ (Stage)
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show(); // Hiển thị cửa sổ lên màn hình
    }

    public static void main(String[] args) {
        // Kích hoạt ứng dụng JavaFX bằng cách gọi phương thức launch
        launch(args);
    }
}