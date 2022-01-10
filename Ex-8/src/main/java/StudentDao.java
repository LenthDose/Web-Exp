import java.util.List;

public interface StudentDao {

     Student findStudentByStuno(int stuno) throws Exception;

     List<Student> findStudentBySpeciality(String speciality) throws Exception;

      void insertStudent(Student student) throws Exception;

      void updateStudentByStuno(Student student) throws Exception;

      void deleteStudentByStuname(String stuname) throws Exception;
}
