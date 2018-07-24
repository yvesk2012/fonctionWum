package projet2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class codemain {

	public static void main(String[] args) {
		ArrayList numero=new ArrayList();
		ArrayList urls=new ArrayList();
			
			try {
				Class.forName("org.postgresql.Driver");
			//	System.out.println("Driver O.K.");
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "Yves-M2206";
				Connection conn = DriverManager.getConnection(url, user,passwd);
				
				Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				String query="SELECT url,numero FROM tablo_4 ORDER BY visite";
				ResultSet result = state.executeQuery(query);
				
						
					while(result.next())
						
				{
						urls.add(result.getString("url"));
						numero.add(result.getInt("numero"));
					
				}	
					for(int k=0;k<3000;k++){
					 System.out.println(numero.get(k)+" "+urls.get(k));
							
						}
						// System.out.println(urls.size());
						/*for(int k=0;k<numero.size();k++){
							 System.out.println(numero.get(k));
									
								}*/
				
			     
			 }
						
				 catch (Exception e) {
				e.printStackTrace();
				}


	}

}
