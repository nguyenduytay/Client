package Controller_UI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller_Recharge_Client {
	 private final Image blackImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30.png"));
	 private final Image whiteImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30-white.png"));

	@FXML
	private ImageView closeImageView;
	@FXML 
	public void closeEntered() {
        closeImageView.setImage(whiteImage);  // Đổi sang ảnh trắng khi hover
	}
	@FXML 
	public void closeExited() {
        closeImageView.setImage(blackImage);  // Đổi lại ảnh đen khi rời chuột
	}
	@FXML 
	public void closeClicked() {
		 Stage stage = (Stage)closeImageView.getScene().getWindow();
         stage.close(); // Đóng ứng dụng	
	}
	
}
