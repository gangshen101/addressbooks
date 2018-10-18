package com.reece.addressbook;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private static final AtomicLong count = new AtomicLong(0);
    private final Long id;
    private final String name;
    private Map<Long, PhoneNumber> phoneNumbers;

    public Contact(String name, Map<Long, PhoneNumber> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.id = count.incrementAndGet();
    }

    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers.values();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
    }
    
    public void removePhoneNumber(Long phoneNumberId) {
        phoneNumbers.remove(phoneNumberId);
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Contact && name.trim().equals(((Contact)object).getName().trim());       
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    @Override
    public String toString() {
        String newLine = "\n";
        StringBuffer sb = new StringBuffer();
        phoneNumbers.values().forEach(phoneNumber -> {
            sb.append(phoneNumber).append(newLine);
        });
        return "Contact [name=" + name + ", phoneNumbers=" + sb.substring(0, sb.lastIndexOf(newLine)) + "]";
    }
    
}