package com.steven.quiscrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.steven.quiscrud.data.entity.AppDatabase
import com.steven.quiscrud.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var fullName: EditText
    private lateinit var nisn: EditText
    private lateinit var alamat: EditText
    private lateinit var asal: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        fullName = findViewById(R.id.full_name)
        nisn = findViewById(R.id.nisn)
        alamat = findViewById(R.id.alamat)
        asal = findViewById(R.id.asal)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id", 0)
            val user = database.userDao().get(id)

            fullName.setText(user.fullName)
            nisn.setText(user.nisn)
            alamat.setText(user.alamat)
            asal.setText(user.asalSekolah)

        }

        btnSave.setOnClickListener {
            if (fullName.text.isNotEmpty() && nisn.text.isNotEmpty() && alamat.text.isNotEmpty() && asal.text.isNotEmpty()) {
                if (intent!=null){
                    // coding edit data
                    database.userDao().update(
                        User(
                            intent.getInt("id", 0),
                            fullName.text.toString(),
                            nisn.text.toString(),
                            alamat.text.toString(),
                            asal.text.toString()
                        )
                    )
                } else {
                    // coding tambah data
                    database.userDao().insertAll(
                        User(
                            null,
                            fullName.text.toString(),
                            nisn.text.toString(),
                            alamat.text.toString(),
                            asal.text.toString()
                        )
                    )
                }

                finish()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data dengan valid",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}