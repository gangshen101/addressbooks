package com.reece.addressbook;

import java.util.concurrent.atomic.AtomicLong;

public class PhoneNumber {
    private static final AtomicLong count = new AtomicLong(0);
    private final Long id;
    private final PhoneNumberType type;
    private final String number;
    
    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
        this.id = count.incrementAndGet();
    }
    
    public Long getId() {
        return id;
    }

    public PhoneNumberType getType() {
        return type;
    }
 
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneNumber [type=" + type + ", number=" + number + "]";
    }
    
}
