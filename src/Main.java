
public class Main {

	public static void main(String[] args) throws Exception {
		
		ReadCSV readCsv=new ReadCSV();
		readCsv.scanCSV();
		System.out.println("***********************************************");
		readCsv.routesInfo();
		System.out.println("***********************************************");
		readCsv.showDirectFlights("delhi");
		System.out.println("***********************************************");
		readCsv.sortDirectFlights("delhi");
		System.out.println("***********************************************");
		readCsv.showDirectIndirectFlights("London","kolkata");

	}

}
