package Controller_UI;

import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

public class Mycontroller {
@FXML
private Label lableTime;
@FXML
public void initialize()
{
	updateTime();
}
private void updateTime()
{
	//tạo luồng cập nhật thời gian
	Timeline timeline=new Timeline(
		new KeyFrame(Duration.seconds(1),event -> {
			//cạp nhật lable với ngày giờ hiẹn tại 
			lableTime.setText(java.time.LocalDateTime.now().format(
			java.time.format.DateTimeFormatter.ofPattern("HH:mm  dd-MM-yy")	
			));
		})	
	);
	timeline.setCycleCount(Timeline.INDEFINITE);//lặp vô hạn 
	timeline.play();//bắt đầu hiển thị thời gian liên tục 
  }
}
