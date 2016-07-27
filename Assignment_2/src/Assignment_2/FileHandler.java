package Assignment_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;



public class FileHandler {
	
	private String path;
	
	int value;
	final int CONTACT_CONTACT_ID_IDX = 0;
	final int CONTACT_SURNAME_IDX = 1;
	final int CONTACT_FIRSTNAME_IDX = 2;
	final int CONTACT_ADR_1_IDX = 3;
	final int CONTACT_ADR_2_IDX = 4;
	final int CONTACT_ADR_3_IDX = 5;
	final int CONTACT_MOBILE_IDX = 6;
	final String COMMA_DELIMITER =", ";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	
	public FileHandler(String file_path){
	
		path = file_path;
		
	}

	
	public HashMap<Integer, Contact> readAddresses() throws IOException{
		
		HashMap<Integer, Contact> adr = new HashMap<Integer,Contact>();
		
		
		BufferedReader fileReader = null;

		try {
			String line = "";
			System.out.println("filename is " + path);
			FileReader fr = new FileReader(path);
			fileReader = new BufferedReader(fr);

			while((line = fileReader.readLine()) != null){
				String[] tokens = line.split(COMMA_DELIMITER);

				if (tokens.length > 0) {
					Contact person = new Contact();
					person.setContact_id(tokens[CONTACT_CONTACT_ID_IDX]);
					person.setFirstname(tokens[CONTACT_SURNAME_IDX]);
					person.setSurname(tokens[CONTACT_FIRSTNAME_IDX]);
					person.setAddress_line_1(tokens[CONTACT_ADR_1_IDX]);
					person.setAddress_line_2(tokens[CONTACT_ADR_2_IDX]);
					person.setAddress_line_3(tokens[CONTACT_ADR_3_IDX]);
					person.setMobile(tokens[CONTACT_MOBILE_IDX]);
					value = person.hashCode();
                    adr.put(value, person);
					
				}
			}

		}

		catch (Exception e){
			System.out.println("Error in CsvFileReader !!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				System.out.println("Closing file");
			} catch (IOException e){
				System.out.println("Error while closing fileReader!!!");
				e.printStackTrace();
			}
		}

		return adr;	
		
		
	}
	
	public void writeCsvFile(String fileName,HashMap<Integer,Contact> addresses){
		FileWriter fileWriter = null;

		try { fileWriter = new FileWriter(fileName);


		for (int key: addresses.keySet()){
			//			fileWriter.append(String.valueOf(addresses.get(key)));
			fileWriter.append(String.valueOf(addresses.get(key).getContact_id()));
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append(addresses.get(key).getFirstname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(addresses.get(key).getSurname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(addresses.get(key).getAddress_line_1());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(addresses.get(key).getAddress_line_2());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(addresses.get(key).getAddress_line_3());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(addresses.get(key).getMobile());		
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
		System.out.println("Csv file was created successfully!");
		}catch (Exception e){
			System.out.println("Error in CsvfileWriter !!!");
			e.printStackTrace();
		}finally{
			try {fileWriter.flush();
			fileWriter.close();
			}catch (IOException e){
				System.out.println("Error while flushing/closing FileWriter !!!");
				e.printStackTrace();
			}
		}

	}

		
	}
	
	
	
	

