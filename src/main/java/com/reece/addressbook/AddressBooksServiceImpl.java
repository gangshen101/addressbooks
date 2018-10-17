package com.reece.addressbook;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class AddressBooksServiceImpl implements AddressBooksService {
    private ConcurrentHashMap<Long, AddressBook> addressBooks;
    
    public AddressBooksServiceImpl(ConcurrentHashMap<Long, AddressBook> addressBooks) {
        super();
        this.addressBooks = addressBooks;
    }

    @Override
    public void addContact(Long addressBookId, Contact contact) {

    }

    @Override
    public void removeContact(Long addressBookId, Long contactId) {

    }

    @Override
    public Collection<Contact> getAllContactsInAddressBook(Long addressBookId) {
        return new HashSet<Contact>();
    }

    @Override
    public Contact getContactInAddressBook(Long addressBookId, Long contactId) {
        return null;
    }

    @Override
    public void printContactsInAddressBook(Long addressBookId) {

    }

    @Override
    public void addAddressBook(AddressBook addressBook) {

    }

    @Override
    public void removeAddressBook(Long addressBookId) {
 
    }

    @Override
    public void printUniqueContactsInAllAddressBooks() {

    }

    @Override
    public Collection<AddressBook> getAllAddressBooks() {
        return null;
    }

    @Override
    public AddressBook getAddressBook(Long addressBookId) {
        return null;
    }

    @Override
    public Collection<Contact> getUniqueContactsInAllAddressBooks() {
    	return new HashSet<Contact>();
    }

}
