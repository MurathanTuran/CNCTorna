package com.turanapps.cnctorna.model.products.plastics

import com.turanapps.cnctorna.model.products.Product
import com.turanapps.cnctorna.view.fragments.products.PlasticFragment

abstract class Plastic(
    plasticName: String = "",
    plasticImage: ByteArray = byteArrayOf(),
    plasticDetails: String = "",
    plasticFragment: PlasticFragment = PlasticFragment()
): Product(
    plasticName,
    plasticImage,
    plasticDetails,
    plasticFragment
)