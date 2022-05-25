package hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.InMemoryCustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;
    
    @BeforeEach
    void setUp() { model = new InMemoryCustomerModel();  }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                "T009",
                "Gia Hung",
                "0987585973",
                "Giahung.jpg",
                LocalDateTime.of(2009, 10, 10, 0, 0)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() { System.out.println(model.findAll().size());  }

    @Test
    void findById() {
        Customer customer = model.findById("T001");
        System.out.println(customer.toString());
    }

    @Test
    void update() {
        Customer student = model.findById("T001");
        student.setName("Viet Hoang");
        model.update("T001", new Customer());
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }

    @Test
    void delete() {
        model.delete("T001");
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}
