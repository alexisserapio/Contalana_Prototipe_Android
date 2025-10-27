package com.alexisserapio.contalana_prototipe.a.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexisserapio.contalana_prototipe.a.utils.Constants
import kotlinx.serialization.BinaryFormat
import java.util.Date

@Entity(tableName = Constants.DATABASE_BUSINESS_TABLE)
data class BusinessEntity(
    @ColumnInfo(name = "name")
    var businessName: String
)
