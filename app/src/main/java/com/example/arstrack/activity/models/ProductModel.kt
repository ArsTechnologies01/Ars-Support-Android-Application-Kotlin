package com.example.arstrack.activity.models

import java.sql.Blob

class ProductModel(var name: String, var img: Blob, var stock: Int, var description: String)