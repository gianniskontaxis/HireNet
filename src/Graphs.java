import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graphs extends JFrame {
	
	

	private ArrayList<String> column = new ArrayList<>();
	private ArrayList<Integer> count = new ArrayList<>();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	private int Screen_size_x = (int) size.getWidth();
	private int Screen_size_y = (int) size.getHeight();
	private int Window_Width = Screen_size_x;
	private int Window_Height = Screen_size_y;
	private int Window_X_Location =0;
	private int Window_Y_Location =0;
	
	
	

		
	public Graphs(int i) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Graphs.class.getResource("/Images/logo_icon25x25.png")));
		setTitle("Companies Graph");
		
		
		
		FileManager rd = new FileManager();							
		column = rd.read("quals.txt");
		
		try {
			conn = DBConnection.ConnDB();
			
			for (int j=0;j<64;j++) {
				sql = "select count(*) as paok from quals where id in (select id from users where role = 'company') and `"+column.get(j)+"` = 'true';";

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.next();
				
				int x = Integer.valueOf(rs.getString("paok"));			
				count.add(x);
			
				}
			conn.close();
		}					
		 catch (SQLException e1) {					
			 e1.printStackTrace();
		}
			
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int j=0;j<64;j++) {
			
			dataset.addValue(count.get(j), "Popularity of Qualifications", column.get(j));
		}
		
			
		
		JFreeChart chart = ChartFactory.createBarChart("Statistics For Companies", "Qualifications", "Popularity", dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		this.setContentPane(chartPanel);
		
		
		
		this.setLocation(Window_X_Location,Window_Y_Location);
		this.setSize(Window_Width,Window_Height);
		this.setVisible(true);
		
			
	}
		

	
}
