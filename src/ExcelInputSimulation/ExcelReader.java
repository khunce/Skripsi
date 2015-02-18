/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ExcelInputSimulation;
import SimulasiAntrianPasien.Customer;
import SimulasiAntrianPasien.StatisticsGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author robby
 */
public class ExcelReader {
    
    private FileInputStream file;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Iterator<Row> rowIterator;
    private String filepath;
    private String filename;
    private LinkedList<Customer> queuecustomer;
    
    public ExcelReader(String filepath,String filename){
        this.filename=filename;
        this.filepath=filepath;
    }
    
    public void createFile(){
        try {
            this.file=new FileInputStream(new File(this.filepath));
        } catch (FileNotFoundException ex) {

        }
    }
    
    public void readExcel(){
        try {
            this.workbook = new XSSFWorkbook(this.file);
        } catch (IOException ex) {
            
        }
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
                        StatisticsGenerator gen=new StatisticsGenerator();
                        int counterrow=0;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
                                if(counterrow>0){
                                    int i=0;
                                    while (cellIterator.hasNext()) 
                                    {
                                            Customer temp=new Customer();
                                            Cell cell = cellIterator.next();
                                            if(i==0){
                                                temp.setNumber((int)cell.getNumericCellValue());
                                                System.out.print( cell.getNumericCellValue()+ "\t");
                                            }
                                            else if(i==1){
                                                temp.setJenis(cell.getStringCellValue());
                                            }
                                            else if(i==2){
                                                String temprealtime=cell.getStringCellValue();
                                                temp.setArrivaltime(gen.convertToRealTime(temprealtime));
                                                System.out.print(temprealtime+ "\t");
                                            }
                                            else if(i==3){
                                                String temprealtime=cell.getStringCellValue();
                                                temp.setArrivaltime(gen.convertToRealTime(temprealtime));
                                                System.out.print(temprealtime+ "\t");
                                            }
                                            else if(i==4){
                                                String tempboolean=cell.getStringCellValue();
                                                if(tempboolean.equals("Y")){
                                                    temp.setToPoliklinik(true);
                                                }
                                                else{
                                                    temp.setToPoliklinik(false);
                                                }
                                                System.out.print(tempboolean+ "\t");
                                            }
                                            i++;

                                    }
                                }
                                System.out.println("");
                                counterrow++;
                        }
                      
        try {
            file.close();
        } catch (IOException ex) {
            
        }
        
    }

    /**
     * @return the filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath the filepath to set
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
    
}
