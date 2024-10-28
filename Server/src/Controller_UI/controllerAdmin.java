package Controller_UI;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Controller.Server;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerAdmin {
@FXML
private Label lableTime;
@FXML
private FontAwesomeIcon close;
@FXML
private FontAwesomeIcon minus;
@FXML
private FontAwesomeIcon menu;
@FXML
private FontAwesomeIcon computer;
@FXML
private FontAwesomeIcon history;
@FXML
private FontAwesomeIcon client;
@FXML
private FontAwesomeIcon staff;
@FXML
private FontAwesomeIcon sale;
@FXML
private FontAwesomeIcon revenue;
@FXML
private FontAwesomeIcon bell;
@FXML
private FontAwesomeIcon setting;
@FXML 
private Separator h1;
@FXML 
private Separator h2;
@FXML 
private Separator h3;
@FXML 
private Separator h4;
@FXML 
private Separator h5;
@FXML
private Separator h6;
@FXML 
private Separator h7;

@FXML
private AnchorPane formClient;

@FXML
private AnchorPane formComputer;

@FXML
private AnchorPane formHistory;

@FXML
private AnchorPane formMenu;

@FXML
private AnchorPane formRevenue;

@FXML
private AnchorPane formSale;

@FXML
private AnchorPane formStaff;

@FXML
private AnchorPane chartComputer;

@FXML
private AnchorPane chartGenus;

@FXML
private AnchorPane chartGuest;

@FXML
private AnchorPane chartRevenue;

@FXML
private AnchorPane payment;

@FXML
private ComboBox<String> comboboxSelectChart;

@FXML
private ComboBox<String> comboboxComputerMonth;

@FXML
private ComboBox<String> comboboxGuestMonth;

@FXML
private ComboBox<String> comboboxComputerYear;

@FXML
private ComboBox<String> comboboxGuestYear;

@FXML
private ComboBox<String> comboboxSelectGenus;

@FXML
private ComboBox<String> comboboxSelectRevenue;
private Server server;
public controllerAdmin() {
	this.server = new Server(this);
	new Thread(server).start();
}


@FXML
public void initialize()
{
	 updateTime();
	 setHoverEffect(close);//chức năng đóng cửa sổ
     setHoverEffect(minus);//chức năng thu nhỏ cửa sổ
     setHoverMenu(bell);
     setHoverMenu(setting);
     
     FontAwesomeIcon[] listMenu= {menu,computer,history,client,sale,staff,revenue};
	 Separator[] listRow= {h1,h2,h3,h4,h5,h6,h7};
	 AnchorPane[] listAnchorPane= {formMenu,formComputer,formHistory,formClient,formSale,formStaff,formRevenue};
	 
	 Map<FontAwesomeIcon, Separator> list1=new HashMap<FontAwesomeIcon, Separator>();
	 list1.put(menu, h1);
     list1.put(computer, h2);
     list1.put(history, h3);
     list1.put(client, h4);
     list1.put(sale, h5);
     list1.put(staff, h6);
     list1.put(revenue, h7);
     Map<Separator, AnchorPane> list2=new HashMap<Separator, AnchorPane>();
     list2.put(h1, formMenu);
     list2.put(h2, formComputer);
     list2.put(h3, formHistory);
     list2.put(h4, formClient);
     list2.put(h5, formSale);
     list2.put(h6, formStaff);
     list2.put(h7,formRevenue);
     
     listMenu[0].setFill(Color.web("#c4c8cf"));
     listRow[0].setVisible(true);
     listAnchorPane[0].setVisible(true);
     
     for(int i=1;i<listAnchorPane.length;i++)
     {
    	 listAnchorPane[i].setVisible(false);
     }
     
     for (int i=1;i<listRow.length;i++) { 
         listRow[i].setVisible(false);
     }
     for ( Map.Entry<FontAwesomeIcon, Separator> icon : list1.entrySet()) {
    	 setClickMenu(icon.getKey(),icon.getValue(),listMenu,listRow,list2);
         setHoverMenu(icon.getKey());   
     }
     
    
     comboboxChart(comboboxSelectChart,comboboxComputerMonth,comboboxComputerYear,
    		       comboboxGuestMonth,comboboxGuestYear,comboboxSelectGenus,
    		       comboboxSelectRevenue);
     
     //sự kiện combobox hiện màn hình thống kê
     AnchorPane[] listChart= {chartRevenue,chartGuest,chartGenus,chartComputer,payment};
     listChart[0].setVisible(true);
     comboboxSelectChart.setOnAction(event -> {
    		for(AnchorPane x: listChart)
    		{
    			x.setVisible(false);
    		}
    		String value=comboboxSelectChart.getValue();
    		try {
    			int i=comboboxSelectChart.getItems().indexOf(value);
    			listChart[i].setVisible(true);
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}	
     });
}
private void comboboxChart(ComboBox<String> comboboxSelectChart,ComboBox<String> comboboxComputerMonth,
		                   ComboBox<String> comboboxComputerYear,ComboBox<String> comboboxGuestMonth,
		                   ComboBox<String> comboboxGuestYear,ComboBox<String> comboboxSelectGenus,
		                   ComboBox<String> comboboxSelectRevenue)
{
    
	//Thêm các tùy chọn danh sách thống kê 
        ObservableList<String> chartTypes = FXCollections.observableArrayList(
            "Thống kê thu", "Thông số khách", "Thống kê chi", "Tỉ lệ chọn máy"
        );
        comboboxSelectChart.setItems(chartTypes);
        comboboxSelectChart.setValue("Thống kê thu");
        
        //Thêm tùy chọn danh sách các tháng và năm cho combobox
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        ObservableList<String> months = FXCollections.observableArrayList();
        ObservableList<String> Years = FXCollections.observableArrayList();
        for(int year=2020;year<=currentYear;year++)
        {
        	Years.add("Năm "+year);
        }
        for (int x = 1; x <= 12; x++) {
            months.add("Tháng " + x);
        }
        comboboxComputerMonth.setItems(months);
        comboboxComputerMonth.setValue("Tháng " + currentMonth );
        comboboxGuestMonth.setItems(months);
        comboboxGuestMonth.setValue("Tháng " + currentMonth);
        comboboxComputerYear.setItems(Years);
        comboboxComputerYear.setValue("Năm " + currentYear);
        comboboxGuestYear.setItems(Years);
        comboboxGuestYear.setValue("Năm " + currentYear);
        
        //Thêm tùy chọn ngày, tháng, năm vào combobox
        ObservableList<String> x = FXCollections.observableArrayList(
                "Ngày", "Tháng", "Năm"
            );
        comboboxSelectRevenue.setItems(x);
        comboboxSelectGenus.setItems(x);
}

//cập nhật thời gian
private void updateTime()
{
	Timeline timeline=new Timeline(
		new KeyFrame(Duration.seconds(1),event -> {
			lableTime.setText(java.time.LocalDateTime.now().format(
			java.time.format.DateTimeFormatter.ofPattern("HH:mm  dd-MM-yy")	
			));
		})	
	);
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.play(); 
  }
//đóng cửa sổ 
@FXML
private void handleClose(MouseEvent event) {
	 Stage stage = (Stage) close.getScene().getWindow(); 
     stage.close();  
}
//thu nhỏ cửa sổ
@FXML
private void handleMinus(MouseEvent event) {
    Stage stage = (Stage) minus.getScene().getWindow();
    stage.setIconified(true); 
}
//sự kiện khi di chuột tới
private void setHoverEffect(FontAwesomeIcon icon) {
	icon.setOnMouseEntered(event -> {
    	icon.setFill(Color.WHITE);  
    });
    icon.setOnMouseExited(event -> {
    	icon.setFill(Color.WHITE);
    });
}
//sự kiện khi di chuột tới 
private void setHoverMenu(FontAwesomeIcon icon)
{
	icon.setOnMouseEntered(event -> {
    	icon.setScaleX(1.5);                
        icon.setScaleY(1.5);
    });
    icon.setOnMouseExited(event -> {
    	icon.setScaleX(1);                
        icon.setScaleY(1);
    });
}
//sự kiện khi click chuột 
private void setClickMenu(FontAwesomeIcon icon,Separator separator, FontAwesomeIcon[] lisMenu,Separator[] listRow,Map<Separator, AnchorPane> list2) {
    icon.setOnMouseClicked(event -> {
    	for (FontAwesomeIcon x : lisMenu) {
    		if(x==icon)
    		{
    		    x.setFill(Color.RED); 
    		}
    		else
    		{
    	         x.setFill(Color.WHITE);
    		}
   
        }
    	for (Separator x : listRow) {
    		if(x==separator)
    		{
    			  x.setVisible(true);
    		}
    		else
    		{
    			  x.setVisible(false);
    		}
          
        }
    	for(Map.Entry<Separator, AnchorPane> x: list2.entrySet())
    	{
    		if(x.getKey()==separator)
    		{
    			x.getValue().setVisible(true);
    		}
    		else
    		{
    			x.getValue().setVisible(false);
    		}
    	}
        
    });
}
@FXML
private void showForm(MouseEvent event)
{
	 AnchorPane[] listChart= {chartRevenue,chartGuest,chartGenus,chartComputer};
	 for(AnchorPane chart:listChart)
	 {
		 chart.setVisible(false);
	 }
	 payment.setVisible(true);
}
}

