import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Matching {
	
	private int i;	
	private String role ="";	
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private PreparedStatement ps4 = null;
	private PreparedStatement ps5 = null;
	private ResultSet rs5 = null;
	private PreparedStatement ps6 = null;
	private String sql="";
	private ArrayList<String> results = new ArrayList<>();
	private ArrayList<String> scoreResults = new ArrayList<>();
	private ArrayList<String> usernameResults = new ArrayList<>();
	
	public Matching (int i, String role) {
		this.i=i;
		this.role=role;	
		
		try {
			conn = DBConnection.ConnDB();
			//Φορτωση των στοιχειων κ qual του user.
			sql = "select * from users join quals where users.id = quals.id and users.id = '"+i+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();					
			
			if (!rs.isClosed()) {
			
			//Φορτωση των στοιχειων κ qual των users του αλλου role.
			sql = "select * from users join quals where users.id = quals.id and role = '"+role+"'";
			ps2 = conn.prepareStatement(sql);
			rs2 = ps2.executeQuery();		
			
			//Δημιουργια κ αρχικοποιηση απαραιτητων αντικειμενων.
			FileManager rd = new FileManager();
			ArrayList<String> column = new ArrayList<>();					
			column = rd.read("quals.txt");
			int x=0;	
			double q=0.0;					
			String SQL = "INSERT INTO MatchingResults(username,score) VALUES(?,?)";
			DecimalFormat df = new DecimalFormat("0.00");
			double pc = 0.0;
								
			//Ευρεση συνολικου αριθμου quals του user.
			sql = "select * from quals where id = '"+i+"'";
			ps3 = conn.prepareStatement(sql);
			rs3 = ps3.executeQuery();
			
			while (rs3.next()) {	
				for (int j=0;j<64;j++) {
				if (rs3.getString(column.get(j)).equals("true"))
					q=q+1.0;	
				}							
			}	
			
			//Matching...
			pc = 100.0/q;
			while (rs2.next()) {					
			x=0;
			for (int j=0; j<64; j++ ) {						
				if (rs.getString(""+column.get(j)+"").equals(""+rs2.getString(column.get(j))+"") 
					&& rs.getString(column.get(j)).equals("true")) {							
						x++;						
				}					
			}										
	       
	        //Προσθηκη σε πινακα για ταξινομηση.	
			q=x*pc;
	        ps4 = conn.prepareStatement(SQL);
	        ps4.setString(1, rs2.getString("username"));
			ps4.setDouble(2, q);						
			ps4.execute();
			ps4.close();					
			}
			
			//Ταξινομηση.
			sql = "select * from MatchingResults order by score desc";				
			ps5 = conn.prepareStatement(sql);
			rs5 = ps5.executeQuery();
			
			//Αποθηκευση αποτελεσματος.					 
			while (rs5.next()) {
				results.add(df.format(rs5.getDouble("score")) + " %  " + rs5.getString("username"));
				usernameResults.add(rs5.getString("username"));
				scoreResults.add(df.format(rs5.getDouble("score")) + " %  ");
				
			}		
			
			//Διαγραφη περιεχομενων του πινακα MatchingResults.
			sql = "delete from MatchingResults";
			ps6 = conn.prepareStatement(sql);
			ps6.execute();			
			
			//Κλεισιμο.
			ps.close();
			rs.close();
			ps2.close();
			rs2.close();	
			ps3.close();
			rs3.close();					
			ps5.close();
			rs5.close();
			ps6.close();
			conn.close();
			}
		else {			
			JOptionPane.showMessageDialog(null, "Please insert qualifications first");
			 }
		}   
		catch (SQLException e1) {					
			e1.printStackTrace();
		}			
	}
	
	public ArrayList<String> getResults() {	
		return results;
	}
	public ArrayList<String> getScoreResults() {
		return scoreResults;
	}
	public ArrayList<String> getUsernameResults() {
		return usernameResults;
	}
}
