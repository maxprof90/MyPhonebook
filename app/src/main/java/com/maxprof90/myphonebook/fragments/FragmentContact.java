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

import com.maxprof90.myphonebook.managers.ContactManager;
import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.adapters.ContactAdapter;

public class FragmentContact extends Fragment {

    View v;
    RecyclerView recyclerView;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        recyclerView = v.findViewById(R.id.contact_recycleview);
        ContactAdapter contactAdapter = new ContactAdapter(getContext(), ContactManager.getInstance());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(contactAdapter);
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
