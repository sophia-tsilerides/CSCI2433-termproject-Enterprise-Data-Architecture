package DataLake.Customers;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVWriter;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
       try {
    	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   	File file = new File("/Users/Rahul/Desktop/Database_Systems/Customers.xlsx");
    	   	if(!file.exists()){
        	   	XSSFWorkbook wkb = new XSSFWorkbook();
        	   	XSSFSheet sheet = wkb.createSheet();
        	   	FileOutputStream fos = new FileOutputStream(file);
        	   	wkb.write(fos);
        	   	wkb.close();
        	   	fos.close();
    	   	}
    	   	File insert_statements = new File("/Users/Rahul/Desktop/Database_Systems/Customers.txt");
    	   	if(!insert_statements.exists()){
    	   		insert_statements.createNewFile();
    	   	}
    	   	File file1 = new File("/Users/Rahul/Desktop/Database_Systems/Customers.csv");
    	   	
    	   	if(!file1.exists()){
    	   		FileWriter write_csv = new FileWriter(file1);
    	   		CSVWriter csv_write = new CSVWriter(write_csv);
    	   		csv_write.writeNext(null);
    	   		csv_write.close();
    	   		//FileOutputStream fos1 = new FileOutputStream(file1);
    	   		
    	   	}
    	   	FileInputStream fis = new FileInputStream(file);
    	   	FileInputStream fis1 = new FileInputStream(insert_statements);
    	   	//FileInputStream fis2 = new FileInputStream(file1);
    	   	FileWriter wr_csv = new FileWriter(file1);
    	   	CSVWriter csv_wr = new CSVWriter(wr_csv);
    	   	
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet0");
			Random rdm = new Random();
			ArrayList<String> males = new ArrayList<>(Arrays.asList("Zach", "Alex", "Bruce", "Michael", "Xobile", "Denis", "Mohammed", "Deepak", "X Æ A-Xii", "Roger", "Novak", "Kylian", "Christian", "Lionel", "Mahendra", "Andrew", "Mihir", "Thien", "Heung", "Kim", "Qasim", "Swaminathan"));
			ArrayList<String> females = new ArrayList<>(Arrays.asList("Daisy", "Serena", "Grace", "Phoebe", "Soumya", "Kayla", "Tanya", "Ankita", "Rose", "Maria", "Swetlana", "Fatima", "Ana", "Smriti", "Michelle", "Sana", "Sonia", "Kendra", "Tiara", "Akasuki", "Chu", "Monica"));
			ArrayList<String> last_names = new ArrayList<>(Arrays.asList("Zverev", "Patel", "Tsilerides", "Lee", "Khan", "Murtaza", "Musk", "Singh", "Parker", "Geller", "Bing", "Modric", "Adébáyọ̀", "Couture", "Rodríguez", "Sánchez", "Peña", "Mukherjee", "Basu", "Iyer", "Palkar", "Cumberbatch", "Headley", "Paxton", "Becker"));
			ArrayList<String> gender = new ArrayList<>(Arrays.asList("M", "F", "O"));
			ArrayList<String> lgbtq = new ArrayList<>(Arrays.asList("L", "G", "B", "T", "Q"));
			String middle_initial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			ArrayList<String> street_name = new ArrayList<>(Arrays.asList("Harvard Avenue", "Huntington Avenue", "Smith St.", "Fulton St.", "Arlington Avenue", "Jeremy Boulevard", "Kings Cross", "Churchill St.", "Grove St.", "Oak Tree Road", "Charlotte St.", "Evelyn Avenue", "Elizabeth Boulevard", "Madison Avenue", "Penelope Crescent", "Aubrey Junction", "Lily St.", "Brooklyn Avenue", "Aurora Alley", "Madelyn Bay", "Autumn Cliffs", "Piper Dr.", "Aubree Dr.", "Reagan St.", "Sophie Hills", "Josephine Meadows"));
			@SuppressWarnings("unchecked")
			List<List<String>> address = Arrays.asList(Arrays.asList("Huntsville", "Alabama", "35811"), Arrays.asList("Phoenix", "Arizona", "85023"), 
					Arrays.asList("Los Angeles", "California", "90005"), Arrays.asList("Beverly Hills", "California", "90210"), Arrays.asList("Denver", "Colorado", "80239"), Arrays.asList("Hartford", "Conneticut", "06105"), Arrays.asList("Dover", "Deleware", "19903"), Arrays.asList("Washington", "District of Columbia", "20020"), Arrays.asList("Pensacola", "Florida", "32507"), 
					Arrays.asList("Miami", "Florida", "33124"), Arrays.asList("Orlando", "Florida", "32801"), Arrays.asList("Atlanta", "Georgia", "30301"), Arrays.asList("Honolulu", "Hawaii", "96801"), Arrays.asList("Chicago", "Illinois", "60601"), Arrays.asList("Indianapolis", "Indiana", "46209"), Arrays.asList("Des Moines", "Iowa", "50323"), 
					Arrays.asList("Wichita", "Kansas", "67221"), Arrays.asList("New Orleans", "Lousiana", "70112"), Arrays.asList("Freeport", "Maine", "04034"), Arrays.asList("Baltimore", "Maryland", "21237"), Arrays.asList("Boston", "Massachusetts", "02137"), Arrays.asList("Ann Arbor", "Michigan", "48103"), Arrays.asList("Duluth", "Minnesota", "55808"), 
					Arrays.asList("St. Louis", "Missouri", "63141"), Arrays.asList("Hastings", "Nebraska", "68901"), Arrays.asList("Reno", "Nevada", "89510"), Arrays.asList("Trenton", "New Jersey", "08609"), Arrays.asList("Santa Fe", "New Mexico", "87500"), Arrays.asList("New York", "New York", "10003"), Arrays.asList("Cleveland", "Ohio", "44102"), 
					Arrays.asList("Tulsa", "Oklahoma", "74108"), Arrays.asList("Pitssburgh", "Pennsylvania", "15219"), Arrays.asList("Newport", "Rhode Island", "02841"), Arrays.asList("Nashville", "Tennessee", "37217"), Arrays.asList("Logan", "Utah", "34322"), Arrays.asList("Bellevue", "Washington", "98005"), Arrays.asList("Milwaukee", "Wisconsin", "53224"));
			//List<List<Object>> address = add.stream().collect((Collection<? extends LinkedHashSet<LinkedHashSet<String>>) add);
			//System.out.println(address.get(1).get(0));
			
			ArrayList<Integer> Id = new ArrayList<>();
			for(int i=100001; i<=110001; i++){
				Id.add(i);
			}
			Collections.shuffle(Id);
			/*ArrayList<Double> Ssn = new ArrayList<>();
			for(double i=100000000; i<=999999999; i++){
				Ssn.add(i);
			}
			Collections.shuffle(Ssn);*/
			HashMap<Integer, Integer> SSN = new HashMap<Integer, Integer>();
			SSN.put(0, 100000000);
			
			HashMap<Integer, Double> Phone = new HashMap<Integer, Double>();
			Phone.put(0, 5000000000.00);
			
			ArrayList<String> medical_history = new ArrayList<String>(Arrays.asList("Hypertension", "Cardiovascular", "Diabetes", "Hypertension and Cardivascular", "Cardiovascular and Diabetes", "Diabetes and Hypertension", "Hypertension, Cardiovascular, and Diabetes"));
			ArrayList<String> plans = new ArrayList<String>(Arrays.asList("Basic Coverage Plan", "Lifestyle Plus Coverage Plan", "Peace of Mind Coverage Plan", "Heart Plus Coverage Plan", "Sugar Rush Coverage Plan", "Choice Coverage Plan"));
			
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("CUSTID");
			row.createCell(1).setCellValue("CUSTFIRSTNAME");
			row.createCell(2).setCellValue("CUSTMIDDLEINITIAL");
			row.createCell(3).setCellValue("CUSTLASTNAME");
			row.createCell(4).setCellValue("DOB");
			row.createCell(5).setCellValue("SSN");
			row.createCell(6).setCellValue("STREET");
			row.createCell(7).setCellValue("CITY");
			row.createCell(8).setCellValue("STATE");
			row.createCell(9).setCellValue("ZIPCODE");
			row.createCell(10).setCellValue("GENDER");
			row.createCell(11).setCellValue("EMAILADDRESS");
			row.createCell(12).setCellValue("CONTACTNUMBER");
			row.createCell(13).setCellValue("HEIGHT_IN");
			row.createCell(14).setCellValue("WEIGHT_LBS");
			row.createCell(15).setCellValue("PULSERATE_PER_MIN");
			row.createCell(16).setCellValue("BODY_TEMP_DEG_F");
			row.createCell(17).setCellValue("BP_SYSTOLIC_MM_HG");
			row.createCell(18).setCellValue("BP_DIASTOLIC_MM_HG");
			row.createCell(19).setCellValue("CHOLESTEROL_MG_PER_DL");
			row.createCell(20).setCellValue("BLOODSUGARFASTING_MG_PER_DL");
			row.createCell(21).setCellValue("BLOODSUGARAFTERMEALS_MG_PER_DL");
			row.createCell(22).setCellValue("DIABETES_MELLITUS");
			row.createCell(23).setCellValue("CIRRHOSIS");
			row.createCell(24).setCellValue("PNEUMONIA");
			row.createCell(25).setCellValue("ALZHEIMERS_DISEASE");
			row.createCell(26).setCellValue("HIV_DISEASE");
			row.createCell(27).setCellValue("CARDIOVASCULAR_DISEASE");
			row.createCell(28).setCellValue("HYPERTENSION");
			row.createCell(29).setCellValue("PREVIOUS_PLAN");
			
			String[] head = {"CUSTID", "CUSTFIRSTNAME", "CUSTMIDDLEINITIAL", "CUSTLASTNAME", "DOB", "SSN", "STREET", "CITY", "STATE", "ZIPCODE", 
					"GENDER", "EMAILADDRESS", "CONTACTNUMBER", "HEIGHT_IN", "WEIGHT_LBS", "PULSERATE_PER_MIN", "BODY_TEMP_DEG_F", "BP_SYSTOLIC_MM_HG", 
					"BP_DIASTOLIC_MM_HG", "CHOLESTEROL_MG_PER_DL", "BLOODSUGARFASTING_MG_PER_DL", "BLOODSUGARFASTING_MG_PER_DL", "DIABETES_MELLITUS",
					"CIRRHOSIS", "PNEUMONIA", "ALZHEIMERS_DISEASE", "HIV_DISEASE", "CARDIOVASCULAR_DISEASE", "HYPERTENSION", "PREVIOUS_PLAN"};
			/*String insert_query = "Insert into Customers(CustId, CustFirstName, CustMiddleInitial, CustLastName, DOB, SSN, Street, City, State, ZipCode, Gender, EmailAddress, "
					+ "ContactNumber, Height_in, Weight_lbs, Pulserate_per_min, Body_temp_deg_F, BP_Systolic_mm_Hg, BP_Diastolic_mm_Hg, Cholesterol_mg_per_dl, "
					+ "BloodSugarFasting_mg_per_dl, BloodSugarAfterMeals_mg_per_dl, Diabetes_Mellitus, Cirrhosis, Pneumonia, Alzheimers_Disease, HIV_Disease, "
					+ "Cardiovascular_Disease, Hypertension)";*/
			csv_wr.writeNext(head);
			String insert_query = "Insert into Customers values(";
			PrintWriter writer = new PrintWriter(insert_statements, "UTF-8");
			for(int i=1; i<10001; i++){
				insert_query = "Insert into Customers values(";
				Row rowi = sheet.createRow(i);
				rowi.createCell(0).setCellValue(Id.get(i));
				String sex = gender.get(rdm.nextInt(gender.size()));
				if(sex.equalsIgnoreCase("M")){
					rowi.createCell(1).setCellValue(males.get(rdm.nextInt(males.size())));
					rowi.createCell(10).setCellValue(sex);
				} else if(sex.equalsIgnoreCase("F")){
						rowi.createCell(1).setCellValue(females.get(rdm.nextInt(females.size())));
						rowi.createCell(10).setCellValue(sex);
					} else{
						sex = lgbtq.get(rdm.nextInt(lgbtq.size()));
						if(sex.equalsIgnoreCase("L")){
							rowi.createCell(1).setCellValue(females.get(rdm.nextInt(females.size())));
							rowi.createCell(10).setCellValue(sex);
						} else if(sex.equalsIgnoreCase("G")){
								rowi.createCell(1).setCellValue(males.get(rdm.nextInt(males.size())));
								rowi.createCell(10).setCellValue(sex);
							} else{
								Integer random = rdm.nextInt(2);
								if(random == 0){
									rowi.createCell(1).setCellValue(males.get(rdm.nextInt(males.size())));
									rowi.createCell(10).setCellValue(sex);
								} else if(random == 1){
										rowi.createCell(1).setCellValue(females.get(rdm.nextInt(females.size())));
										rowi.createCell(10).setCellValue(sex);
									}
							}
					}
					rowi.createCell(2).setCellValue(Character.toString(middle_initial.charAt(rdm.nextInt(middle_initial.length()))));
					rowi.createCell(3).setCellValue(last_names.get(rdm.nextInt(last_names.size())));
					String dt = Integer.toString(ThreadLocalRandom.current().nextInt(1950, 1995)) + "/" + Integer.toString(ThreadLocalRandom.current().nextInt(1, 13)) + "/" + Integer.toString(ThreadLocalRandom.current().nextInt(1, 29));
					SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
					Date date = dt1.parse(dt);
					
					rowi.createCell(4).setCellValue(dt1.format(date));
					
					Integer ssn = ThreadLocalRandom.current().nextInt(100000001, 1000000000);
					while(SSN.containsValue(ssn)){
						ssn = ThreadLocalRandom.current().nextInt(100000001, 1000000000);
					}
					SSN.put(i, ssn);
					//System.out.println(SSN.get(i));
					//System.out.println(SSN.get(i).toString().substring(0,3) + "-" + SSN.get(i).toString().substring(3, 5) + "-" + SSN.get(i).toString().substring(5, 9));
					rowi.createCell(5).setCellValue(SSN.get(i).toString().substring(0,3) + "-" + SSN.get(i).toString().substring(3, 5) + "-" + SSN.get(i).toString().substring(5, 9));
					rowi.createCell(6).setCellValue(street_name.get(rdm.nextInt(street_name.size())));
					rowi.createCell(7).setCellValue(address.get(rdm.nextInt(address.size())).get(0));
					rowi.createCell(8).setCellValue(address.get(rdm.nextInt(address.size())).get(1));
					rowi.createCell(9).setCellValue(address.get(rdm.nextInt(address.size())).get(2));
					rowi.createCell(11).setCellValue(rowi.getCell(3).getStringCellValue() + "_" + rowi.getCell(1).getStringCellValue() + "@company.com");
					
					Double contact_number = ThreadLocalRandom.current().nextDouble(5000000001.00, 10000000000.00);
					//Integer contact_number2 = ThreadLocalRandom.current().nextInt(50001, 100000);
					while(Phone.containsValue(contact_number)){
						contact_number = ThreadLocalRandom.current().nextDouble(5000000001.00, 10000000000.00);
						//contact_number2 = ThreadLocalRandom.current().nextInt(50001, 100000);
					}
					Phone.put(i, contact_number);
					//System.out.println(Phone.get(i));
					rowi.createCell(12).setCellValue(Phone.get(i).toString().substring(2, 5) + "-" + Phone.get(i).toString().substring(5, 8) + "-" + Phone.get(i).toString().substring(8, 12));
					BigDecimal height = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(50.00, 85.00));
					rowi.createCell(13).setCellValue(height.setScale(2, RoundingMode.HALF_UP).doubleValue());
					
					BigDecimal weight = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(100.00, 301.00));
					rowi.createCell(14).setCellValue(weight.setScale(2, RoundingMode.HALF_UP).doubleValue());
					
					rowi.createCell(15).setCellValue(ThreadLocalRandom.current().nextInt(55, 91));
					rowi.createCell(16).setCellValue(ThreadLocalRandom.current().nextInt(95, 105));
					rowi.createCell(23).setCellValue("No");
					rowi.createCell(24).setCellValue("No");
					rowi.createCell(25).setCellValue("No");
					rowi.createCell(26).setCellValue("No");
					if(rdm.nextInt(2) == 0){
						rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(116, 123));
						rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(78, 82));
						rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(125, 201));
						rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(80, 101));
						rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(100, 141));
						rowi.createCell(22).setCellValue("No");
						rowi.createCell(27).setCellValue("No");
						rowi.createCell(28).setCellValue("No");
						rowi.createCell(29).setCellValue(plans.get(rdm.nextInt(plans.size())));
					}else{
						if(medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Hypertension")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(100, 121));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(125, 201));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(80, 101));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(100, 141));
							rowi.createCell(22).setCellValue("No");
							rowi.createCell(27).setCellValue("No");
							rowi.createCell(28).setCellValue("Yes");
							rowi.createCell(29).setCellValue(plans.get(2));
						}else if(medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Cardiovascular")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(116, 123));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(78, 82));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(240, 401));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(80, 110));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(120, 161));
							rowi.createCell(22).setCellValue("No");
							rowi.createCell(27).setCellValue("Yes");
							rowi.createCell(28).setCellValue("No");
							rowi.createCell(29).setCellValue(plans.get(3));
						}else if(medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Diabetes")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(116, 123));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(78, 82));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(125, 201));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(90, 131));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(22).setCellValue("Yes");
							rowi.createCell(27).setCellValue("No");
							rowi.createCell(28).setCellValue("No");
							rowi.createCell(29).setCellValue(plans.get(4));
						}else if(medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Hypertension and Cardiovascular")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(100, 121));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(240, 401));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(80, 101));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(100, 141));
							rowi.createCell(22).setCellValue("Yes");
							rowi.createCell(27).setCellValue("Yes");
							rowi.createCell(28).setCellValue("No");
							if(rdm.nextInt(2) == 0){
								rowi.createCell(29).setCellValue(plans.get(5));
							}else{
								rowi.createCell(29).setCellValue(plans.get(1));
							}
							
						}else if (medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Cardiovascular and Diabetes")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(116, 123));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(78, 82));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(240, 401));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(90, 131));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(22).setCellValue("No");
							rowi.createCell(27).setCellValue("Yes");
							rowi.createCell(28).setCellValue("Yes");
							if(rdm.nextInt(2) == 0){
								rowi.createCell(29).setCellValue(plans.get(5));
							}else{
								rowi.createCell(29).setCellValue(plans.get(1));
							}
						}else if (medical_history.get(rdm.nextInt(medical_history.size())).equalsIgnoreCase("Diabetes and Hypertension")){
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(100, 121));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(125, 201));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(90, 131));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(22).setCellValue("Yes");
							rowi.createCell(27).setCellValue("No");
							rowi.createCell(28).setCellValue("Yes");
							if(rdm.nextInt(2) == 0){
								rowi.createCell(29).setCellValue(plans.get(5));
							}else{
								rowi.createCell(29).setCellValue(plans.get(1));
							}
						}else{
							rowi.createCell(17).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(18).setCellValue(ThreadLocalRandom.current().nextInt(100, 121));
							rowi.createCell(19).setCellValue(ThreadLocalRandom.current().nextInt(240, 401));
							rowi.createCell(20).setCellValue(ThreadLocalRandom.current().nextInt(90, 131));
							rowi.createCell(21).setCellValue(ThreadLocalRandom.current().nextInt(140, 201));
							rowi.createCell(22).setCellValue("Yes");
							rowi.createCell(27).setCellValue("Yes");
							rowi.createCell(28).setCellValue("Yes");
							if(rdm.nextInt(2) == 0){
								rowi.createCell(29).setCellValue(plans.get(1));
							}else{
								Integer plan = ThreadLocalRandom.current().nextInt(2,6);
								if(plan == 2){
									rowi.createCell(29).setCellValue(plans.get(2));
								}else if (plan == 3){
									rowi.createCell(29).setCellValue(plans.get(3));
								}else if (plan == 4){
									rowi.createCell(29).setCellValue(plans.get(4));
								}else if (plan == 5){
									rowi.createCell(29).setCellValue(plans.get(5));
								}
							}
							
						}
						
						if(rdm.nextInt(2) == 1){
							rowi.getCell(23).setCellValue("Yes");
						}
						if(rdm.nextInt(2) == 1){
							rowi.getCell(24).setCellValue("Yes");
						}
						if(rdm.nextInt(2) == 1){
							rowi.getCell(25).setCellValue("Yes");
						}
						if(rdm.nextInt(2) == 1){
							rowi.getCell(26).setCellValue("Yes");
						}
					}
					insert_query = insert_query + "'" + String.valueOf(rowi.getCell(0).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(0).getNumericCellValue()).length()-2) + "', " +
							"'" + rowi.getCell(1).getStringCellValue() + "', " +
							"'" + rowi.getCell(2).getStringCellValue() + "', " +
							"'" + rowi.getCell(3).getStringCellValue() + "', " +
							"'" + rowi.getCell(4).getStringCellValue() + "', " +
							"'" + rowi.getCell(5).getStringCellValue() + "', " +
							"'" + rowi.getCell(6).getStringCellValue() + "', " +
							"'" + rowi.getCell(7).getStringCellValue() + "', " +
							"'" + rowi.getCell(8).getStringCellValue() + "', " +
							"'" + rowi.getCell(9).getStringCellValue() + "', " +
							"'" + rowi.getCell(10).getStringCellValue() + "', " +
							"'" + rowi.getCell(11).getStringCellValue() + "', " +
							"'" + rowi.getCell(12).getStringCellValue() + "', " +
							"'" + String.valueOf(rowi.getCell(13).getNumericCellValue()) + "', " +
							"'" + String.valueOf(rowi.getCell(14).getNumericCellValue()) + "', " +
							"'" + String.valueOf(rowi.getCell(15).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(15).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(16).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(16).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(17).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(17).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(18).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(18).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(19).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(19).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(20).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(20).getNumericCellValue()).length()-2) + "', " +
							"'" + String.valueOf(rowi.getCell(21).getNumericCellValue()).substring(0, String.valueOf(rowi.getCell(21).getNumericCellValue()).length()-2) + "', " +
							"'" + rowi.getCell(22).getStringCellValue() + "', " +
							"'" + rowi.getCell(23).getStringCellValue() + "', " +
							"'" + rowi.getCell(24).getStringCellValue() + "', " +
							"'" + rowi.getCell(25).getStringCellValue() + "', " +
							"'" + rowi.getCell(26).getStringCellValue() + "', " +
							"'" + rowi.getCell(27).getStringCellValue() + "', " +
							"'" + rowi.getCell(28).getStringCellValue() + "', " +
							"'" + rowi.getCell(29).getStringCellValue() + "');" ;
					String[] rowdata = {String.valueOf(rowi.getCell(0).getNumericCellValue()), rowi.getCell(1).getStringCellValue(), 
							rowi.getCell(2).getStringCellValue(), rowi.getCell(3).getStringCellValue(),
							rowi.getCell(4).getStringCellValue(), rowi.getCell(5).getStringCellValue(),
							rowi.getCell(6).getStringCellValue(), rowi.getCell(7).getStringCellValue(),
							rowi.getCell(8).getStringCellValue(), rowi.getCell(9).getStringCellValue(),
							rowi.getCell(10).getStringCellValue(), rowi.getCell(11).getStringCellValue(),
							rowi.getCell(12).getStringCellValue(), String.valueOf(rowi.getCell(13).getNumericCellValue()),
							String.valueOf(rowi.getCell(14).getNumericCellValue()), String.valueOf(rowi.getCell(15).getNumericCellValue()),
							String.valueOf(rowi.getCell(16).getNumericCellValue()), String.valueOf(rowi.getCell(17).getNumericCellValue()),
							String.valueOf(rowi.getCell(18).getNumericCellValue()), String.valueOf(rowi.getCell(19).getNumericCellValue()),
							String.valueOf(rowi.getCell(20).getNumericCellValue()), String.valueOf(rowi.getCell(21).getNumericCellValue()),
							rowi.getCell(22).getStringCellValue(), rowi.getCell(23).getStringCellValue(),
							rowi.getCell(24).getStringCellValue(), rowi.getCell(25).getStringCellValue(), 
							rowi.getCell(26).getStringCellValue(), rowi.getCell(27).getStringCellValue(),
							rowi.getCell(28).getStringCellValue(), rowi.getCell(29).getStringCellValue()};
					writer.println(insert_query);
					csv_wr.writeNext(rowdata);
					
			}
			 
			//System.out.println(insert_query);
			FileOutputStream fos = new FileOutputStream(file);
			
			csv_wr.close();
			writer.close();
    	   	workbook.write(fos);
    	   	workbook.close();
    	   	fos.close();			
			
       } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
    }
}
