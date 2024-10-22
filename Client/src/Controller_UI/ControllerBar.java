package Controller_UI;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class ControllerBar {
		@FXML
		private AnchorPane mainContainer;
		
		private Node currentContent;

		private Node btnCurrent;
		
	
	    
		/*
		 * @FXML private Slider xpSlider;
		 * 
		 * @FXML private Label xpLabel;
		 */
	    @FXML
	    public void initialize() {
	        currentContent = mainContainer.lookup("#content");  // Giả sử Node hiện tại có id là "content"
	        btnCurrent = mainContainer.lookup("#homeButton");
	    }
	    @FXML
	    public void handleButtonClick(ActionEvent event) {
	        Button clickedButton = (Button) event.getSource(); 
	        clearSelected();
	        btnCurrent = clickedButton;
	        String buttonId = clickedButton.getId();
	        switch(buttonId) {
	        	case "homeButton":
	                loadContent("../application/contentHome.fxml");
	        		break;
	        	case "gamesButton":
	        		loadContent("../application/contentGame.fxml");
	        		break;
	        	default: break;
	        }

	        clickedButton.getStyleClass().add("selected");
	    }
	    private void loadContent(String fxmlFile) {	
	        try {
	            if (currentContent != null) {
	                mainContainer.getChildren().remove(currentContent);
	            }

	            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
	            Node content = loader.load();

	            content.setId("content");

	            mainContainer.getChildren().add(content);
	            currentContent = content;  

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public Node getNodeById(String id) {
	        // Tìm kiếm Node có id là "content"
	        return mainContainer.lookup("#" + id);
	    }
		/*
		 * @FXML public void initialize() { xpSlider.valueProperty().addListener((obs,
		 * oldVal, newVal) -> { int value = newVal.intValue(); int percentage = (int)
		 * Math.round((value - 0) / 2.0); xpLabel.setText(value + "XP"); });
		 * updateLabelPosition((int) xpSlider.getValue());
		 * 
		 * }
		 * 
		 * private void updateLabelPosition(int value) { double percent = value / 200.0;
		 * xpLabel.setLayoutX(50 + (xpSlider.getWidth() - 100) * percent); }
		 */
	    private void clearSelected() {
	    	btnCurrent.getStyleClass().remove("selected");
	    }
	 
}
