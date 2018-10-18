package com.reece.addressbook;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class AddressBooksServiceImpl implements AddressBooksService {
    private static final String CONTACTS_OUTPUT_PREFIX = "Contacts are : ";
    private Map<Long, AddressBook> addressBooks;
    
    public AddressBooksServiceImpl(Map<Long, AddressBook> addressBooks) {
        super();
        this.addressBooks = addressBooks;
    }

    @Override
    public void addContact(Long addressBookId, Contact contact) {
        if (addressBooks.containsKey(addressBookId)) {
            addressBooks.get(addressBookId).addContact(contact);
        }
    }

    @Override
    public void removeContact(Long addressBookId, Long contactId) {
        if (addressBooks.containsKey(addressBookId)) {
            addressBooks.get(addressBookId).removeContact(contactId);
        }
    }

    @Override
    public Collection<Contact> getAllContactsInAddressBook(Long addressBookId) {
        return addressBooks.containsKey(addressBookId) ? addressBooks.get(addressBookId).getAllContacts() : null;
    }

    @Override
    public Contact getContactInAddressBook(Long addressBookId, Long contactId) {
        return addressBooks.containsKey(addressBookId) ? addressBooks.get(addressBookId).getContact(contactId) : null;
    }

    @Override
    public void printContactsInAddressBook(Long addressBookId) {
        if (!addressBooks.containsKey(addressBookId)) {
            return;
        }
        System.out.println(CONTACTS_OUTPUT_PREFIX);
        addressBooks.get(addressBookId).getAllContacts().forEach(contact -> {
            System.out.println(contact);
        });
    }

    @Override
    public void addAddressBook(AddressBook addressBook) {
        addressBooks.put(addressBook.getId(), addressBook);
    }

    @Override
    public void removeAddressBook(Long addressBookId) {
        addressBooks.remove(addressBookId);       
    }

    @Override
    public void printUniqueContactsInAllAddressBooks() {
        System.out.println(CONTACTS_OUTPUT_PREFIX);
        getUniqueContactsInAllAddressBooks().forEach(contact -> {
            System.out.println(contact);
        });
    }

    @Override
    public Collection<AddressBook> getAllAddressBooks() {
        return addressBooks.values();
    }

    @Override
    public AddressBook getAddressBook(Long addressBookId) {
        return addressBooks.get(addressBookId);
    }

    @Override
    public Collection<Contact> getUniqueContactsInAllAddressBooks() {
        Set<Contact> uniqueContacts = new HashSet<Contact>();
        addressBooks.values().forEach(addressBook -> {
            uniqueContacts.addAll(addressBook.getAllContacts());
        });
        return uniqueContacts;
    }

}
