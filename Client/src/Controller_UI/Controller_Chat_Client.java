package Controller_UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Controller_Chat_Client extends Controller_Form {
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@FXML
	private ListView<String> messageList;
	@FXML
	private TextArea messageField;
	@FXML
	private Button buttonSendMessage;
	@FXML
	public void sendClicked() {
		String message = messageField.getText();
	    if (!message.isEmpty()) {
            String currentTime = LocalDateTime.now().format(timeFormatter);

//	        sendMessageToServer(message);   gửi tin nhắn đến server
            messageList.getItems().add("Bạn [" + currentTime + "]: " + message);
	        messageField.clear();  // Xóa nội dung trường nhập sau khi gửi
	    }
	}
}
