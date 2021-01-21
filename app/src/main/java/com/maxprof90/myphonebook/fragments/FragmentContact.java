package com.maxprof90.myphonebook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.adapters.RecycleViewAdapter;
import com.maxprof90.myphonebook.models.ContactData;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

    View v;

    RecyclerView recyclerView;
    List<ContactData> contactList;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        recyclerView = v.findViewById(R.id.contact_recycleview);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(), contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactList = new ArrayList<>();
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
        contactList.add(new ContactData("Вася", "1234567", R.drawable.avatar));
    }
}
