package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        assertEquals("John", contact.getFirstName());
    }
    
    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    public void testPhoneMustBe10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345", "123 Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testMaxLengthContactId() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Street");
        assertNotNull(contact);
    }


    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
}
