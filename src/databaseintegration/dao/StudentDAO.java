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
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "INSERT INTO STUDENT VALUES (?, ?, ?)"
            );
            preparedStatement.setString(1, entity.getRegistration());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setInt(3, entity.getEntryYear());
            preparedStatement.executeUpdate();
            
            closeStatement(preparedStatement);
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to save the studet's data\n");
        }
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
            
            closeStatement(preparedStatement);
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to retrieve the studet's data\n");
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
            System.out.println("\nAn error ocurred while trying to retrieve the studets' data\n");
        }
        
        return students;
    }

    @Override
    public void update(Student entity) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "UPDATE STUDENT SET NAME = ?, ENTRY_YEAR = ? WHERE REGISTRATION = ?"
            );
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getEntryYear());
            preparedStatement.setString(3, entity.getRegistration());
            preparedStatement.executeUpdate();
            
            closeStatement(preparedStatement);
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to update the studet's data\n");
        }
    }

    @Override
    public void delete(String key) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "DELETE FROM STUDENT WHERE REGISTRATION = ?"
            );
            preparedStatement.setString(1, key);
            preparedStatement.executeUpdate();
            
            closeStatement(preparedStatement);
        } catch (Exception e) {
            System.out.println("\nAn error ocurred while trying to delete the studet's data\n");
        }
    }
    
}
