package com.example.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter (var contactList: List<Contact>):RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var contactViewHolder=ContactViewHolder(binding)
        return contactViewHolder


    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
     var currentContact = contactList.get(position)
        holder.binding.tvName.text =currentContact.name
        holder.binding.tvNumber.text=currentContact.phoneNumber
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvAdress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_24)
            .resize(300,300)
            .centerCrop()
            .into(holder.binding.ivContact)
        val context = holder.itemView.context
        holder.binding.ivContact.setOnClickListener{
            Toast.makeText(context,"you have clicked on ${currentContact.name}'s image", Toast.LENGTH_SHORT).show()
        }
        holder.binding.cvContact.setOnClickListener{
            val intent = Intent(context, viewContactActivity::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("EMAIL", currentContact.email)
            intent.putExtra("NUM",currentContact.phoneNumber)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size

    }
}
class ContactViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

}