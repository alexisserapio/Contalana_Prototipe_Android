package com.alexisserapio.contalana_prototipe.a.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexisserapio.contalana_prototipe.a.utils.Constants
import kotlinx.serialization.BinaryFormat
import java.util.Date

@Entity(tableName = Constants.DATABASE_PRODUCT_TABLE)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    var id: Int = 0,
    @ColumnInfo(name = "product_name")
    var productName: String,
    @ColumnInfo(name = "product_description")
    var productDescription: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "amount")
    var amount: Int,
    @ColumnInfo(name = "price")
    var price: Float,
    @ColumnInfo(name = "supplier")
    var supplier: Int,
    @ColumnInfo(name = "location")
    var string: String,
    @ColumnInfo(name = "added_product_date")
    var addedProductDate: Date,
    @ColumnInfo(name = "branch")
    var branch: String,
    @ColumnInfo(name = "brand")
    var brand: String,
    @ColumnInfo(name = "amount")
    var code: String,
    @ColumnInfo(name = "last_purchase_date")
    var lastPurchaseDate: Date,
    @ColumnInfo(name = "max_price")
    var maxPrice: Float,
    @ColumnInfo(name = "min_price")
    var minPrice: Int,
    @ColumnInfo(name = "image")
    var image: BinaryFormat
)
