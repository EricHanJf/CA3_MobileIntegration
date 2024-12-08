package com.example.ca3_mobileintegration.data.model.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "plants",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"], // User's primary key
            childColumns = ["userId"], // Foreign key in the Plant table
            onDelete = ForeignKey.CASCADE // Deletes plants if the user is deleted
        )
    ]
)
data class Plant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int, // Foreign key linking to User table
    val plantname: String,
    val temperature: Float, // Plant's preferred temperature
    val humidity: Float, // Plant's preferred humidity
    val location: String,
    val waterRequirement: String, // Description of water needs
    val imageUri: String? = null // Optional: Store a URI to the plant's picture
)