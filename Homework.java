package homework;

import java.lang.String;
import java.sql.CallableStatement;
import java.util.ArrayList;

public class Homework {

    public static void main(String[] args) {
      
        ArrayList<String> list = new ArrayList<String>();
        list.add("SEN119");
        list.add("SEN114");
        list.add("SEN112");
        list.add("SEN263");
        list.add("SEN265");
        Student stu=new Student("B1605.090014","Mert","Tezer","505",list);
        stu.save();
        
        list.clear();
        list.add("SEN233");
        list.add("SEN225");
        list.add("SEN233");
        list.add("SEN264");
        list.add("SEN232");  
        stu = new Student ("B1605.090015","Bahadır","Atak","505",list);
        stu.save();
        
        /*list.clear();
        list2.add("SEN242");
        list2.add("SEN232");
        list2.add("SEN112");
        list2.add("SEN119");
        list2.add("SEN233");*/

    }
    
}
