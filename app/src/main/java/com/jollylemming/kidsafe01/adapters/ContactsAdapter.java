package com.jollylemming.kidsafe01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jollylemming.kidsafe01.R;
import com.jollylemming.kidsafe01.interfaces.OnContactClickListener;
import com.jollylemming.kidsafe01.models.Contact;
import com.jollylemming.kidsafe01.utils.BackgroundGenerator;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsAdapterViewHolder> {
	private Context context;
	private ArrayList<Contact> contacts;
	private OnContactClickListener onContactClickListener;
	
	public ContactsAdapter(ArrayList<Contact> contacts, Context context) {
		this.contacts = contacts;
		this.context = context;
	}
	
	public void setOnContactClickListener(OnContactClickListener onContactClickListener) {
		this.onContactClickListener = onContactClickListener;
	}
	
	@NonNull
	@Override
	public ContactsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_contact, viewGroup, false);
		return new ContactsAdapterViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull ContactsAdapterViewHolder contactsAdapterViewHolder, int i) {
		Contact contact = contacts.get(i);
		contactsAdapterViewHolder.txtContactName.setText(contact.getContactName());
		contactsAdapterViewHolder.txtContactNumber.setText(contact.getContactNumber());
		contactsAdapterViewHolder.txtContactBackground.setText(BackgroundGenerator.getFirstCharacters(contact.getContactName()));
		contactsAdapterViewHolder.txtContactBackground.setBackground(BackgroundGenerator.getBackground(context));
	}
	
	@Override
	public int getItemCount() {
		return contacts.size();
		
	}
	
	public class ContactsAdapterViewHolder extends RecyclerView.ViewHolder {
		private TextView txtContactName;
		private TextView txtContactNumber;
		private ImageButton imgBtnCall;
		private ImageButton imgBtnMessage;
		private TextView txtContactBackground;
		
		public ContactsAdapterViewHolder(@NonNull View itemView) {
			super(itemView);
			txtContactName = itemView.findViewById(R.id.txtContactName);
			txtContactNumber = itemView.findViewById(R.id.txtContactNumber);
			txtContactBackground = itemView.findViewById(R.id.txtContactBackground);
			imgBtnCall = itemView.findViewById(R.id.imgBtnCall);
			imgBtnCall.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onContactClickListener.onCallClick(contacts.get(getAdapterPosition()).getContactNumber());
				}
			});
			
			imgBtnMessage = itemView.findViewById(R.id.imgBtnMessage);
			imgBtnMessage.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onContactClickListener.onMessageClick(contacts.get(getAdapterPosition()).getContactNumber());
				}
			});
			
		}
	}
	
	
}
