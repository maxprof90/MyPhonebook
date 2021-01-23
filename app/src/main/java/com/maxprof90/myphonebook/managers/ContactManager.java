package com.maxprof90.myphonebook.managers;

import com.maxprof90.myphonebook.models.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactManager implements IContactManager {

    private static ContactManager instance;

    private List<ContactData> contactDataList = new ArrayList<>();

    private ContactManager() {

    }

    public static ContactManager getInstance() {

        if (instance == null) {
            instance = new ContactManager();
        }

        return instance;
    }


    @Override
    public ContactData get(int position) {
        return contactDataList.get(position);
    }

    @Override
    public int size() {
        return contactDataList.size();
    }

    @Override
    public void add(ContactData contactData) {
        contactDataList.add(contactData);
    }
}