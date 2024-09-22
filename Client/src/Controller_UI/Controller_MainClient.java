package Controller_UI;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_MainClient {
	 private final Image blackImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30.png"));
	 private final Image whiteImage = new Image(getClass().getResourceAsStream("../image/icons8-close-30-white.png"));

	@FXML
	private ImageView closeImageView;
	@FXML
	private Label Money_User;
	@FXML
	private Label Time_User;
	@FXML
	private Label RemainTime_User;
	@FXML
	private Label Price;
	@FXML
	private VBox service_user;
	@FXML
	private VBox combo_user;
	@FXML
	private VBox recharge_user;
	@FXML
	private VBox message_user;
	@FXML
	private VBox lockDevice_user;
	@FXML
	private VBox logOut_user;
	
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
	public void Click_Service() {
		
	}
	@FXML
	public void Click_Combo() {
		
	}
	@FXML
	public void Click_Recharge() {
		try {
			Stage Recharge_Stage = new Stage();
			 Parent root = FXMLLoader.load(getClass().getResource("../application/Recharge_Client.fxml"));
			 Recharge_Stage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
			 Recharge_Stage.setTitle("Hello World");
		        Recharge_Stage.setScene(new Scene(root));
		        Recharge_Stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	
	}
	@FXML
	public void Click_Message() {
		
	}
	@FXML
	public void Click_lockDevice() {
		
	}
	@FXML
	public void Click_Logout() {
		
	}
	
}
