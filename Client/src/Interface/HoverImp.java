package Interface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HoverImp implements Hover{

	@Override
	public void hoverHbox(MouseEvent e) {
		 HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.RED);		
	}

	@Override
	public void exitedHBox(MouseEvent e) {
		 HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.WHITE);
		
	}

	@Override
	public void createColorTransition(Button button, FontAwesomeIcon icon, Color targetColor) {
		 Timeline timeline = new Timeline();

		    int frames = 10; 
		    for (int i = 0; i <= frames; i++) {
		        final double fraction = i / (double) frames; 
		        KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.05), event -> {
		       
		            Color currentTextColor = (Color) button.getTextFill();
		            Color newTextColor = interpolateColor(currentTextColor, targetColor, fraction);
		            button.setTextFill(newTextColor);

		            Color currentIconColor = (Color) icon.getFill();
		            Color newIconColor = interpolateColor(currentIconColor, targetColor, fraction);
		            icon.setFill(newIconColor);
		        });
		        timeline.getKeyFrames().add(keyFrame);
		    }
		    timeline.play();		
	}

	@Override
	public Color interpolateColor(Color startColor, Color endColor, double fraction) {
		 double red = startColor.getRed() + (endColor.getRed() - startColor.getRed()) * fraction;
		    double green = startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * fraction;
		    double blue = startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * fraction;
		    return Color.color(red, green, blue);
	}

}
