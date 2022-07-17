package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class viewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras(){
        val extras = intent.extras
        val name = extras?.getString("NAME", "")
        var email= extras?.getString("EMAIL","")
        var add= extras?.getString("ADDRESS","")
        var num=extras?.getString("NUM","")
        var image= binding.ivcontact


        Toast.makeText(this,"$name: $email",Toast.LENGTH_LONG).show()
        binding.tvname.text=name
        binding.tvnumber.text=num
        binding.tvemail.text=email
        binding.tvaddress.text=add
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)

    }
}