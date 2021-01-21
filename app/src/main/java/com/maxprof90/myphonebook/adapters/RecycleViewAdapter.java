package com.maxprof90.myphonebook.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.models.ContactData;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ContactViewHolder> {

    Context mContext;
    List<ContactData> mData;
    Dialog dialog;

    public RecycleViewAdapter(Context mContext, List<ContactData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);
        final ContactViewHolder viewHolder = new ContactViewHolder(view);

        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.detail_contact);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView contactName_detail = dialog.findViewById(R.id.contactName_detail);
                TextView contactPhone_detail = dialog.findViewById(R.id.contactPhone_detail);
                ImageView contactAvatar_detail = dialog.findViewById(R.id.contactAvatar_detail);

                contactName_detail.setText(mData.get(viewHolder.getAdapterPosition()).getName());
                contactPhone_detail.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
                contactAvatar_detail.setImageResource(mData.get(viewHolder.getAdapterPosition()).getAvatar());


                Toast.makeText(mContext, "Detail contact " + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                dialog.show();

            }

        });

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

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img_avatar;
        private LinearLayout item_contact;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.showName_item);
            tv_phone = itemView.findViewById(R.id.showPhone_item);
            img_avatar = itemView.findViewById(R.id.image_contact_item);
            item_contact = itemView.findViewById(R.id.item_contact_id);
        }
    }
}
