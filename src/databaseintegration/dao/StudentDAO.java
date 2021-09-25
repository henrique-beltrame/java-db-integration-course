package databaseintegration.dao;

import databaseintegration.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Henrique
 */
public class StudentDAO extends GenericDAO<Student, String> {

    @Override
    public void create(Student entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student read(String key) {
        Student student = null;
        
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "SELECT * FROM STUDENT WHERE REGISTRATION = ?"
            );
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {                
                student = new Student(
                        resultSet.getString("REGISTRATION"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("ENTRY_YEAR")
                );
            }
            closeStatement(resultSet.getStatement());
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to retrieve the studet\n");
        }
        
        return student;
    }

    @Override
    public List<Student> readAll() {
        List<Student> students = new ArrayList<>();
        
        try {
            ResultSet resultSet = getStatement().executeQuery(
                    "SELECT * FROM STUDENT"
            );
            
            while (resultSet.next()) {                
                students.add(new Student(
                        resultSet.getString("REGISTRATION"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("ENTRY_YEAR")
                ));
            }
            closeStatement(resultSet.getStatement());
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to retrieve the studets\n");
        }
        
        return students;
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
