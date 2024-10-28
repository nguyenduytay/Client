package Controller_UI;


import Controller.Client;
import Model.UserAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerLogin {
	private Client client;
	public ControllerLogin() {
		client = Client.getInstance();
		
	}
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button login;
	public void dangnhap(ActionEvent e) {
		String username = usernameField.getText();
		String password = passwordField.getText();
		 if (isValidLogin(username, password) != null) {
	          
	        } else {
	        }
	}
	  private UserAccount isValidLogin(String username, String password) {
		  	UserAccount account = null;
		  	String send = "LOGIN_USER " + username + " " + password;
		  	client.sendMessage = send;
		  ///// nhânj dữ liệu
		  	return account;
	  }
}
