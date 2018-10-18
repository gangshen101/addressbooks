package com.reece.addressbook;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.reece.addressbook.Contact;

public class AddressBook {
    private static final AtomicLong count = new AtomicLong(0);
    private final Long id;
    private final String name;
    private Map<Long, Contact> contacts;
    
    public AddressBook(String name, Map<Long, Contact> contacts) {
        super();
        this.name = name;
        this.contacts = contacts;
        this.id = count.incrementAndGet();
    }
    
    public String getName() {
        return name;
    }

    public Collection<Contact> getAllContacts() {
        return contacts.values();
    }
    
    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }
    
    public void removeContact(Long contactId) {
        contacts.remove(contactId);
    }
    
    public Contact getContact(Long contactId) {
        return contacts.get(contactId);
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        String newLine = "\n";
        StringBuffer sb = new StringBuffer();
        contacts.values().forEach(contact -> {
            sb.append(contact).append(newLine);
        });
        return "AddressBook [contacts=" + sb.substring(0, sb.lastIndexOf(newLine)) + "]";
    }
    
}
