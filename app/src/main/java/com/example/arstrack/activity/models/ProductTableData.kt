package com.example.arstrack.activity.models

import java.sql.Blob

class ProductTableData(
    var id: Int,
    var name: String,
    var description: String,
    var categroyId: Int,
    var stock_count: Int,
    var created_at: String,
    var updated_at: String,
    var image: Blob

)