package Controller_UI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Controller_Form {
	 private final Image blackImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30.png"));
	 private final Image whiteImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30-white.png"));
	   // Biến lưu trữ vị trí ban đầu của chuột
	 private double xOffset = 0;
	 private double yOffset = 0;

	 @FXML
	    private AnchorPane anchorPane;

	 @FXML
	  	private HBox HeaderBox;
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
	
	@FXML 
	public void mousePressedHBox(MouseEvent event) {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
	}
		
	@FXML 
	public void mouseDragged(MouseEvent event) {
		  Stage stage = (Stage) anchorPane.getScene().getWindow();
          stage.setX(event.getScreenX() + xOffset);
          stage.setY(event.getScreenY() + yOffset);
	}

   
}
