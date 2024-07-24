package com.turanapps.cnctorna.model.products.metals

import com.turanapps.cnctorna.model.products.Product
import com.turanapps.cnctorna.view.fragments.products.MetalFragment

open class Metal(
    metalName: String = "",
    metalImage: ByteArray = byteArrayOf(),
    metalDetails: String = "",
    metalFragment: MetalFragment = MetalFragment()
): Product(
    metalName,
    metalImage,
    metalDetails,
    metalFragment
)
