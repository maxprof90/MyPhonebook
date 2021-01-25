package com.maxprof90.myphonebook.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.maxprof90.myphonebook.managers.IContactManager;
import com.maxprof90.myphonebook.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    Context mContext;
    IContactManager mData;
    Dialog dialog;

    public ContactAdapter(Context mContext, IContactManager mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);

        final ContactViewHolder viewHolder = new ContactViewHolder(view);
        viewHolder.cardView.setOnClickListener(v -> {

            dialog = new Dialog(mContext);
            dialog.setContentView(R.layout.detail_contact_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            TextView contactNameDetail = dialog.findViewById(R.id.contactName_detail);
            TextView contactLastNameDetail = dialog.findViewById(R.id.contactLastName_detail);
            TextView contactPhoneDetail = dialog.findViewById(R.id.contactPhone_detail);
            ImageView contactAvatarDetail = dialog.findViewById(R.id.contactAvatar_detail);

            contactNameDetail.setText(mData.get(viewHolder.getAdapterPosition()).getName());
            contactLastNameDetail.setText(mData.get(viewHolder.getAdapterPosition()).getLastName());
            contactPhoneDetail.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
            contactAvatarDetail.getDrawable();

            dialog.show();

        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_lastName.setText(mData.get(position).getLastName());
        holder.img_avatar.setImageResource(R.drawable.avatar);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_lastName;
        private final ImageView img_avatar;
        private final CardView cardView;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            tv_name = itemView.findViewById(R.id.showFirstName_item);
            tv_lastName = itemView.findViewById(R.id.showLastName_item);
            img_avatar = itemView.findViewById(R.id.image_contact_avatar);
        }
    }
}
