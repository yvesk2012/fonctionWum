package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class duree_etvisite {

	public static void main(String[] args) {
		ArrayList numero=new ArrayList();
		ArrayList tmp_sec=new ArrayList();
		ArrayList duree=new ArrayList();
		ArrayList bool=new ArrayList();
		ArrayList visite=new ArrayList();
		
		int res=0;
	     //int[]tab=new int[duree.size()];
	     int cmpt=0;
		 		  		
		try {
			Class.forName("org.postgresql.Driver");
		//	System.out.println("Driver O.K.");
			String url = "jdbc:postgresql://localhost:5432/projet";
			String user = "postgres";
			String passwd = "Yves-M2206";
			Connection conn = DriverManager.getConnection(url, user,passwd);
			
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String query="SELECT session,numero,tmp_seconde FROM tablo_4";
			//String query="SELECT session,numero,tmp_seconde FROM tablo_4 ORDER BY numero,tmp_seconde";
			ResultSet result = state.executeQuery(query);
				while(result.next())
					numero.add(result.getInt("numero"));
					tmp_sec.add(result.getInt("tmp_seconde"));
			}	
					
					for(int h=0;h<numero.size()-1;h++){
						if(numero.get(h).equals(numero.get(h+1))){
						
						duree.add(Math.abs((int)tmp_sec.get(h+1)-(int)tmp_sec.get(h)));	
						bool.add(1);
						
						}						
						
					else{
						    duree.add(-1);
							bool.add(0);					    
						}
						
					}
				   
				
					
					/**************affichage duree sur console**************/
					
					for(int k=0;k<duree.size();k++){
				// System.out.println(duree.get(k));
						
					}//System.out.println(duree.size());
					
   /****************Identification de la visite**********************************/
					
			visite.add(1);
		     for(int j=0;j<duree.size()-1;j++){
				if((int)duree.get(j)>1800||bool.get(j).equals(0)){
					visite.add((int)visite.get(j)+1);
									
					}
				else
					visite.add(visite.get(j));
				
			}
					
    /*******************affichage visite sur console*****************************/
					
		     for(int k=0;k<visite.size();k++){
					//System.out.println(visite.get(k));
				}
		    // System.out.println(visite.size());
		     /**********************Affichage bool sur console***********************************/
		     
		     
		     
		     for(int k=0;k<bool.size();k++){
		    	//System.out.println(bool.get(k));
		     }//System.out.println(bool.size());
		     
		     
		     /*************La moyennes des duree de chaque fin de visite***************/
		     int[]tab=new int[duree.size()];
		     for(int i=0;i<duree.size();i++){
		    	 tab[i]=(int)duree.get(i);		    	
		    	 	
		   		     } //System.out.println(duree.get(3370));	
		   		       //System.out.println(tab[3370]);	   
		    for(int h=0;h<tab.length;h++){
		     if(tab[h]!=-1){
		    	 cmpt=cmpt+1;
		   		 res=res+tab[h];
	    		
	    		 }else{
	    			 tab[h]=99;	
	    			 //res=0;
			    	  //cmpt=0;
			    	  }
		    	
		    	 }		    	
		     
		     
		     for(int l=0;l<tab.length;l++){
		    	 System.out.println(tab[l]);
		     }*/
		     
		    
		     /********************fin du code*********************/
		     
		 }
					
			 catch (Exception e) {
			e.printStackTrace();
			}
		


	}}}


