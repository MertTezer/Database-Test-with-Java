package homework;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String StudentID;
    private String StudentName;
    private String StudetnSurname;
    private String StudentClass;
    private ArrayList<String> Course;
    private dbConnection db = new dbConnection();

    public Student(String StudentID, String StudentName, String StudetnSurname, String StudentClass, ArrayList<String> Course) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.StudetnSurname = StudetnSurname;
        this.StudentClass = StudentClass;
        this.Course = Course;
    }

    public void setCourse(String courseCode) {

        Course.add(courseCode);

    }

    public void save() {
        
        Connection con = db.getConnection();

        try {
            String sql = "insert into student values (?,?,?,?)";
            CallableStatement cs;
            cs = con.prepareCall(sql);
            cs.setString(1, StudentID);
            cs.setString(2, StudentName);
            cs.setString(3, StudetnSurname);
            cs.setString(4, StudentClass);
            cs.execute();

            for (int i = 0; i < Course.size(); i++) {
                sql = "insert into student_course values (?,?)";
                cs = con.prepareCall(sql);
                cs.setString(1, StudentID);
                cs.setString(2, Course.get(i));
                cs.execute();

            }
            System.out.println("Student saved successfully");
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
