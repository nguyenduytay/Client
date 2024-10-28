package Interface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public interface Hover {
	@FXML
	public void hoverHbox(MouseEvent e);
	@FXML
	public void exitedHBox(MouseEvent e);
	public void createColorTransition(Button button, FontAwesomeIcon icon, Color targetColor);
	public Color interpolateColor(Color startColor, Color endColor, double fraction);

}
