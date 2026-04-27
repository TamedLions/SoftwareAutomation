package contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);

        assertNotNull(service.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);
        service.updateFirstName("1", "Jane");

        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);
        service.updateLastName("1", "Smith");

        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);
        service.updatePhone("1", "0987654321");

        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);
        service.updateAddress("1", "New Address");

        assertEquals("New Address", service.getContact("1").getAddress());
    }

    @Test
    public void testDuplicateContactId() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 St");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "456 St");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    public void testUpdateNonExistingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Test");
        });
    }

    @Test
    public void testDeleteNonExistingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }
    
    @Test
    public void testGetContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 St");

        service.addContact(contact);

        Contact retrieved = service.getContact("1");

        assertNotNull(retrieved);
        assertEquals("John", retrieved.getFirstName());
    }
}