package com.example.bustracking

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bustracking.databinding.ActivityUpdateScheduleBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateSchedule : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateScheduleBinding

    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_schedule)
        binding = ActivityUpdateScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseReference = FirebaseDatabase.getInstance().getReference("RouteSchedule")

        binding.btnUpdate.setOnClickListener {
            if (binding.etRouteSchedule.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter Schedule First!!", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    databaseReference.setValue(binding.etRouteSchedule.text.toString())
                    Toast.makeText(this, "Schedule Updated", Toast.LENGTH_SHORT).show()
                    finish()
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

}