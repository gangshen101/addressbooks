package com.reece.addressbook;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBooksServiceImplTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String GARY = "Gary";
    private static final String ERIC = "Eric";
    private static final String MELBOURNE = "Melbourne";
    private static final String SYDNEY = "Sydney";
    
    private Contact gary;
    private Contact eric;
    private AddressBook melbourneAddressBook;
    private AddressBook sydneyAddressBook;
    private AddressBooksServiceImpl addressBooksService;
    
    private void initializeContacts() {
        gary= new Contact(GARY, new HashMap<Long, PhoneNumber>());
        gary.addPhoneNumber(new PhoneNumber(PhoneNumberType.MOBILE, "0432981899"));
        eric= new Contact(ERIC, new HashMap<Long, PhoneNumber>());
        eric.addPhoneNumber(new PhoneNumber(PhoneNumberType.OFFICE, "0380900166"));
    }
    
    private void initializeAddressBooks() {
        melbourneAddressBook = new AddressBook(MELBOURNE, new HashMap<Long, Contact>());
        sydneyAddressBook = new AddressBook(SYDNEY, new HashMap<Long, Contact>());
    }
    
    private void initializeAddressBooksService() {
        addressBooksService = new AddressBooksServiceImpl(new HashMap<Long, AddressBook>());
        addressBooksService.addAddressBook(melbourneAddressBook);
        addressBooksService.addAddressBook(sydneyAddressBook);
    }
    
    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @Before
    public void initialize() {
        initializeContacts();
        initializeAddressBooks();
        initializeAddressBooksService();
        setUpStreams();
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @Test
    public void testAddContact() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        assertEquals(addressBooksService.getContactInAddressBook(melbourneAddressBook.getId(), gary.getId()).getName(), GARY);
    }
    
    @Test
    public void testRemoveContact() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        addressBooksService.removeContact(melbourneAddressBook.getId(), gary.getId());
        assertNull(addressBooksService.getContactInAddressBook(melbourneAddressBook.getId(), gary.getId()));
    }
    
    @Test
    public void testGetAllContactsInAddressBook() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        addressBooksService.addContact(melbourneAddressBook.getId(), eric);
        Collection<Contact> contacts = addressBooksService.getAllContactsInAddressBook(melbourneAddressBook.getId());
        assertTrue(contacts.contains(gary) && contacts.contains(eric));
    }
    
    @Test
    public void testGetContactInAddressBook() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        assertEquals(addressBooksService.getContactInAddressBook(melbourneAddressBook.getId(), gary.getId()).getName(), GARY);
        assertNull(addressBooksService.getContactInAddressBook(melbourneAddressBook.getId(), eric.getId()));
    }
    
    @Test
    public void testPrintContactsInAddressBook() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        addressBooksService.addContact(melbourneAddressBook.getId(), eric);
        addressBooksService.printContactsInAddressBook(melbourneAddressBook.getId());
        assertTrue(outContent.toString().contains(gary.toString()) && outContent.toString().contains(eric.toString()));
    }
    
    @Test
    public void testAddAddressBook() {
        AddressBook brisbaneAddressBook = new AddressBook("Brisbane", new HashMap<Long, Contact>());
        addressBooksService.addAddressBook(brisbaneAddressBook);
        assertEquals(addressBooksService.getAddressBook(brisbaneAddressBook.getId()).getName(), "Brisbane");
    }
    
    @Test
    public void testRemoveAddressBook() {
        addressBooksService.removeAddressBook(melbourneAddressBook.getId());
        assertNull(addressBooksService.getAddressBook(melbourneAddressBook.getId()));
    }
    
    @Test
    public void testPrintUniqueContactsInAllAddressBooks() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        addressBooksService.addContact(melbourneAddressBook.getId(), eric);
        addressBooksService.addContact(sydneyAddressBook.getId(), eric);
        addressBooksService.printUniqueContactsInAllAddressBooks();
        assertTrue(outContent.toString().contains(gary.toString()) && outContent.toString().split(ERIC, -1).length - 1 == 1);
    }
    
    @Test
    public void testGetAllAddressBooks() {
        assertEquals(addressBooksService.getAllAddressBooks().size(), 2);
    }
    
    @Test
    public void testGetAddressBook() {
        assertEquals(addressBooksService.getAddressBook(melbourneAddressBook.getId()).getName(), MELBOURNE);    
    }
    
    @Test
    public void testGetUniqueContactsInAllAddressBooks() {
        addressBooksService.addContact(melbourneAddressBook.getId(), gary);
        addressBooksService.addContact(melbourneAddressBook.getId(), eric);
        addressBooksService.addContact(sydneyAddressBook.getId(), eric);
        assertEquals(addressBooksService.getUniqueContactsInAllAddressBooks().size(), 2);
    }
}
