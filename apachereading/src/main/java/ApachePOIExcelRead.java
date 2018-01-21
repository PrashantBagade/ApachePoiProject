import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class ApachePOIExcelRead { 

    private static final String FILE_NAME = "C:/Users/Pashu/Desktop/serverJars1.xlsx";

    private static final String FILE_NAME1 = "C:/Users/Pashu/Desktop/weblogicJars.xlsx";

    HashMap<String,ArrayList<String>> weblogiccellreord= new HashMap<String, ArrayList<String>>();
    ArrayList<String> cellreocrds=new ArrayList<String>();

    
    public static void main(String[] args) throws Exception {
    	Temp temp=new Temp();
    	Original og=new Original();
        ApachePOIExcelRead obj=new ApachePOIExcelRead();

        
        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        FileInputStream excelOgFile = new FileInputStream(new File(FILE_NAME1));
//        Temp weblogicobj=obj.readfile(excelFile,temp);
        Temp[] webobj=obj.weblogicsheet(excelOgFile, og);
        Writefile wf=new Writefile();
        wf.writeXLSXFile(webobj,excelFile);
     //System.out.println("ds"+o1.getDependinciesWebserver());
    }
    

	private Temp[] weblogicsheet(FileInputStream excelOgFile,Original og) {
		Temp[] weblogicobj=null;
		try {
            Workbook workbook = new XSSFWorkbook(excelOgFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int i=0;
            String firstcell="";
            Row currentRow=iterator.next();
            Short maxcolumn=currentRow.getLastCellNum();
            while (iterator.hasNext()) {
            	//iterator.hasNext();//to skip first column heading(first row)
            	int currentrowindex=currentRow.getRowNum();
                currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Cell currentCell;
                while (cellIterator.hasNext()) {

                   currentCell = cellIterator.next();
                    if (null==currentCell.getStringCellValue() || "".equalsIgnoreCase(currentCell.getStringCellValue())){
                    	System.out.println("Cell is blank or null");
                    	}else
                    	{
                    		if(0==currentCell.getColumnIndex())
                    		{ 
                    			firstcell=currentCell.getStringCellValue();
                    			currentCell=cellIterator.next();
                    		}
                    			while(currentCell.getColumnIndex()<maxcolumn){
                    				cellreocrds.add(currentCell.getStringCellValue());
                    				String columnheadername=currentCell.getSheet().getRow(currentrowindex).getCell(currentCell.getColumnIndex())
                    			    .getRichStringCellValue().toString();
//                    				System.out.println("celvalues : " +currentCell.getStringCellValue());
                    				System.out.println(columnheadername +" "+currentCell.getStringCellValue());
                    				
                    				weblogicobj[currentrowindex]=new Temp();
                    				switch(columnheadername)
                    				{
                    				case "weblogicJars":
                    					weblogicobj[currentrowindex].setWeblogicJar(currentCell.getStringCellValue());
                    				
                    				case "Dependencies":
                    					weblogicobj[currentrowindex].setDependincies(currentCell.getStringCellValue());
                    				
                    				case "tomcat replacement":
                    					weblogicobj[currentrowindex].setTomcatReplacement(currentCell.getStringCellValue());
                    				
                    				case "Is compatible":
                    					weblogicobj[currentrowindex].setIsCompatible(currentCell.getStringCellValue());
                    					
                    				case "Solution":
                    					weblogicobj[currentrowindex].setSolution(currentCell.getStringCellValue());

                    				default:
                    					System.out.println("Invallid Input in switch case");
                    				}
                    				
                    				if (cellIterator.hasNext())
                    				{
                    					currentCell=cellIterator.next();
                    				}
                    				else{
                    					break;
                    				}
                    			}
                    			weblogiccellreord.put(firstcell,cellreocrds);
                    		
                    		
                    		Iterator<Map.Entry<String,ArrayList<String>>> coliterator=weblogiccellreord.entrySet().iterator(); 
                    		
                    		while(coliterator.hasNext())
                    		{
                    			Entry<String,ArrayList<String>> entry=coliterator.next();
                    			System.out.println(entry.getKey() +" "+entry.getValue());
                    		}
                    				
                    			
                    		
                    	}
                    }
            }
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                    	
//                    	 while(i<=maxcolumn)	
//                        {
//                        	if(i==0){
//                        		og.setWebserverJar(currentCell.getStringCellValue());
//                        		i++;
//                        		break;
//                        		}
//                        		
//                        	else if(i==1){
//                        		og.setIsWeblogicJar(currentCell.getStringCellValue());
//                        		System.err.println(og);
//                        		i++;
//                        		break;
//                        	}
//                        	else if(i==2){
//                        		og.setIsEnterpriseJar(" "+((currentCell.getStringCellValue()==null)? " ":currentCell.getStringCellValue()));
//                        		System.err.println(og);
//                        		i++;
//                        		break;
//                        	}
//                        	else if(i==3){
//                        		og.setDependinciesWebserver(currentCell.getStringCellValue());
//                        		i++;
//                        		break;
//                        	}
//                        	else if(i==4){
//                        		og.setTomcatReplacementWebserver(currentCell.getStringCellValue());
//                        		i++;
//                        		break;
//                        	}
//                        	else if(i==5){
//                        		og.setIsCompatibleWebserver(currentCell.getStringCellValue());
//                        		i++;
//                        		break;
//                        	}
//                        	else if(i==6){
//                        		og.setSolutionWebserver(currentCell.getStringCellValue());
//                        		i++;
//                        		break;
//                        	}
//                        	}
//                    }    
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        //System.out.print(currentCell.getNumericCellValue() + "--");
//                    }
//
//                }
//                System.out.println();
//
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
		return weblogicobj;
    }
	
	
	
/*	private Temp readfile(FileInputStream excelFile,Temp temp ) {
		try {
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                   // System.out.println(currentCell.getColumnIndex());
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        //System.out.print(currentCell.getStringCellValue() + "--");
                        for(int i=0;i<5;i++)
                        {
                        	if(i==0)
                        	temp.setWeblogicJar(currentCell.getStringCellValue());
                        	
                        	else if(i==1)
                        	temp.setDependincies(currentCell.getStringCellValue());
                        	
                        	else if(i==2)
                        		temp.setTomcatReplacement(currentCell.getStringCellValue());
                        	
                        	else if(i==3)
                        		temp.setIsCompatible(currentCell.getStringCellValue());
                        	
                        	else if(i==4)
                        		temp.setSolution(currentCell.getStringCellValue());
                        }
                        //checkColumnData(temp);
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        //System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return temp;
	}
*/
}