import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession session;
    private static InputStream inputStream;
    private static final String resource = "mybatisConfig.xml";

    @BeforeClass
    public static void init() throws IOException {

    }

    @Override
    public Student findStudentByStuno(int stuno) throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        Student student = session.selectOne("findStudentByStuno", stuno);
        session.close();
        return student;
    }



    @Override
    public List<Student> findStudentBySpeciality(String speciality) throws Exception {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        List<Student> students = session.selectList("findStudentBySpeciality",speciality);
        session.close();
        return students;
    }

    @Override
    public void insertStudent(Student student) throws Exception {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        session.insert("insertStudent", student);
        session.commit();
        session.close();
    }

    @Override
    public void updateStudentByStuno(Student student) throws Exception {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        session.insert("updateStudentByStuno", student);
        session.commit();
        session.close();
    }

    @Override
    public void deleteStudentByStuname(String stuname) throws Exception {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        session.delete("deleteStudentByStuname", stuname);
        session.commit();
        session.close();
    }
}
