package hellot2010aagain.entity;

import com.t2010a.hellot2010aagain.entity.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class StudentTest {

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setRollNumber("A001");
        student.setFullName("Viet Hoang");
        student.setEmail("hoang@gmail.com");
        student.setPhone("0854973819");
        student.setDob(LocalDateTime.of(2004, 10, 22, 10, 10));
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setStatus(1);
        System.out.println(student.toString());
    }

}
