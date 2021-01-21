package com.maxprof90.myphonebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.model.Contact;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ContactViewHolder> {

    Context mContext;
    List<Contact> mData;

    public RecycleViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_phone.setText(mData.get(position).getPhone());
        holder.img_avatar.setImageResource(mData.get(position).getAvatar());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img_avatar;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.showName_item);
            tv_phone = itemView.findViewById(R.id.showPhone_item);
            img_avatar = itemView.findViewById(R.id.image_contact_item);
        }
    }
}
