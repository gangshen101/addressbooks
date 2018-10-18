package com.reece.addressbook;

import java.util.Collection;

public interface AddressBooksService {
    /**
    * Add a contact into an address book
    * @param Long addressBookId, the address book id
    * @param Contact contact, contact to be added
    */
    public void addContact(Long addressBookId, Contact contact);
    
    /**
    * Remove a contact from an address book
    * @param Long addressBookId, the address book id
    * @param Long contactId, id of contact to be removed
    */
    public void removeContact(Long addressBookId, Long contactId);
    
    /**
    * Get all contacts from an address book
    * @param Long addressBookId, the address book id
    * @return Collection<Contact>, collection of contacts
    */
    public Collection<Contact> getAllContactsInAddressBook(Long addressBookId);
    
    /**
    * Get all unique contacts from all address books
    * @return Collection<Contact>, collection of contacts
    */
    public Collection<Contact> getUniqueContactsInAllAddressBooks();
    
    /**
    * Get a contact from an address book
    * @param Long addressBookId, the address book id
    * @param Long contactId, the contact id
    * @return Contact, the contact
    */
    public Contact getContactInAddressBook(Long addressBookId, Long contactId);
    
    /**
    * Print all contacts in an address book
    * @param Long addressBookId, the address book id
    */
    public void printContactsInAddressBook(Long addressBookId);
    
    /**
    * Add a address book
    * @param AddressBook addressBook, the address book to be added
    */
    public void addAddressBook(AddressBook addressBook);
    
    /**
    * Remove a address book
    * @param Long addressBookId, id of the address book to be removed
    */
    public void removeAddressBook(Long addressBookId);
    
    /**
    * Print all unique contacts in all address books
    */
    public void printUniqueContactsInAllAddressBooks();
    
    /**
    * Get all address books
    * @return Collection<AddressBook>, collection of address books
    */
    public Collection<AddressBook> getAllAddressBooks();
    
    /**
    * Get an address book
    * @param Long addressBookId, the address book id
    * @return AddressBook, the specific address books
    */
    public AddressBook getAddressBook(Long addressBookId);
}
