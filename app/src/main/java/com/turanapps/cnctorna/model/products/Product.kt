package com.turanapps.cnctorna.model.products

import androidx.fragment.app.Fragment

open class Product(
    var productName: String = "",
    var productImage: ByteArray = byteArrayOf(),
    var productDetails: String = "",
    var productFragment: Fragment
)
