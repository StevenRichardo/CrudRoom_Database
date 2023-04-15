package com.steven.quiscrud.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "full_name") var fullName: String?,
    @ColumnInfo(name = "nisn") var nisn: String?,
    @ColumnInfo(name = "alamat") var alamat: String?,
    @ColumnInfo(name = "asal_sekolah") var asalSekolah: String?
)