import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class ReadCSV {
	List<String[]> routes = new ArrayList<String[]>();

	public void scanCSV() throws Exception {

		try {

			Scanner sc = new Scanner(new File(
					"C:\\Users\\Sourav Rathor\\eclipse-workspace\\JAP_C4_S7_Project_RoutePlanner\\src\\routes.csv"));
			sc.useDelimiter(",");

			while (sc.hasNext()) {
				String data = sc.nextLine();
				String[] lineData = data.split(",");
				routes.add(lineData);

			}

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	public List<String[]> routesInfo() {
		System.out.println("Source "+ " Dest " + " Range "+ " Time " + " Cost ");
		for (int j = 0; j < routes.size(); j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print(routes.get(j)[i]);
				System.out.print(' ');

			}
			System.out.println();
		}
		return routes;
	}
	
	public void showDirectFlights(String fromCity) {
		System.out.println("From "+ " To " + " Distance "+ " Travel Time " + " Airfare ");
		boolean flag=true;
		for(int i=0;i<routes.size();i++) {
			
			if(routes.get(i)[0].compareToIgnoreCase(fromCity)==0) {
				flag=false;
				for(int k=0;k<5;k++) {
					System.out.print(routes.get(i)[k]+" ");
				}
				System.out.println();
			}
		}
		if(flag) {
			System.out.println("No direct flight from that city");
		}
	}
	
	public void sortDirectFlights(String s) {
		System.out.println("From "+ " To " + " Distance "+ " Travel Time " + " Airfare ");
		List<String[]> list = new ArrayList<String[]>();
		for(int i=0;i<routes.size();i++) {
			
			if(routes.get(i)[0].compareToIgnoreCase(s)==0) {
				
				list.add(routes.get(i));
			}
		}
		String[] temp;
for(int i=0;i<list.size()-1;i++) {
	for(int j=0;j<list.size()-i-1;j++) {
			
			if(list.get(j)[1].compareToIgnoreCase(list.get(j+1)[1])>0) {
				
				temp=list.get(j);
				list.remove(j);
				list.add(j+1, temp);
				
			}
		}
}
		
		
		
for(int i=0;i<list.size();i++) {
			
			
				for(int k=0;k<5;k++) {
					System.out.print(list.get(i)[k]+" ");
				}
				System.out.println();
			
		}
		
	}
	
	
	
	public void showDirectIndirectFlights(String s,String d) {
		List<String[]> list = new ArrayList<String[]>();
		for(int i=0;i<routes.size();i++) {
			
			if(routes.get(i)[0].compareToIgnoreCase(s)==0 && routes.get(i)[1].compareToIgnoreCase(d)==0) {
				
				list.add(routes.get(i));
			}
		}
		for(int i=0;i<routes.size();i++) {
			
			if(routes.get(i)[0].compareToIgnoreCase(s)==0 && routes.get(i)[1].compareToIgnoreCase(d)!=0) {
				
				for(int j=0;j<routes.size();j++) {
					
					if(routes.get(i)[1].compareToIgnoreCase(routes.get(j)[0])==0 && routes.get(j)[1].compareToIgnoreCase(d)==0) {
						
						list.add(routes.get(i));
						list.add(routes.get(j));
					}
				}
				
				
			}
		}
		if(list.size()==0)
			System.out.println("no path between "+s+" and "+d);
		else {
			System.out.println("From "+ " To " + " Distance "+ " Travel Time " + " Airfare ");
		for(int i=0;i<list.size();i++) {
			
			
			for(int k=0;k<5;k++) {
				System.out.print(list.get(i)[k]+" ");
			}
			System.out.println();
		
	}
		}
	
		
		
	}

}
