package com.maxprof90.myphonebook.managers;

import com.maxprof90.myphonebook.models.ContactData;

public interface IContactManager {

    ContactData get (int position);
    int size();
    void add (ContactData contactData);
}
