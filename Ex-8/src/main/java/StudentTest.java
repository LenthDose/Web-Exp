import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentTest {
    StudentDao studentDao = new StudentDaoImpl();
    @Test
    public void testFindStudentByStuno() throws Exception {
        Student student = studentDao.findStudentByStuno(8);
        System.out.println(student);
    }

    @Test
    public void testFindStudentBySpeciality() throws Exception {
        List<Student> students = studentDao.findStudentBySpeciality("软件工程");
        for (Student stu :
                students) {
            System.out.println(stu.getStuname());
        }
    }

    @Test
    public void testInsertStudent() throws Exception {
        Student student = new Student();
        student.setStuname("张大胆");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat1.parse("1996-05-06");
        student.setBirthday(birthday);
        student.setGender("男");
        student.setScore(200);
        student.setSpeciality("软件工程");
        studentDao.insertStudent(student);
    }

    @Test
    public void testUpdateStudentByStuno() throws Exception {
        Student student = studentDao.findStudentByStuno(2);
        student.setStuname("李不怕");
        student.setGender("女");
        student.setSpeciality("人工智能");
        studentDao.updateStudentByStuno(student);
    }

    @Test
    public void testDeleteStudentByStuname() throws Exception {
        studentDao.deleteStudentByStuname("张大胆");
    }
}
