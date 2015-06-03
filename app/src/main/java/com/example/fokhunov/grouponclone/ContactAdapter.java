package com.example.fokhunov.grouponclone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Coupon> couponList;
    OnItemClickListener mItemClickListener;

    public ContactAdapter(List<Coupon> list) {couponList = list;}

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Coupon c = couponList.get(i);
        contactViewHolder.mText.setText(c.text);

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        protected TextView mText;

        public ContactViewHolder(View v) {
            super(v);
            mText = (TextView) v.findViewById(R.id.mText_view);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null){
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }
}