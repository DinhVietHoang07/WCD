package hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.CustomerModel;
import com.t2010a.hellot2010aagain.model.MySqlCustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() { model = new MySqlCustomerModel(); }

    @Test
    void save() {
        model.save(new Customer("T005","Linh","0854789456","Linh.jpg",LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer st :
                list) {
            System.out.println(st.toString());
        }
    }

    @Test
    void findById() {
        Customer student = model.findById("T005");
        assertEquals("Linh", student.getName());
        Customer student1 = model.findById("T005");
        assertEquals("Lam", student1.getName());
    }

    @Test
    void update() {
        Customer student = model.findById("A001");
        student.setName("Dinh Viet Hoang");
        model.update("A001", student);
        Customer newUpdateCustomer = model.findById("A001");
        assertEquals("Dinh Viet Hoang", newUpdateCustomer.getName());
    }

    @Test
    void delete() {
        model.delete("A001");
        Customer student = model.findById("A001");
        assertEquals(null, student);
    }
}
