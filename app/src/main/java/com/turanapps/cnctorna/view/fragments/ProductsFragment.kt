package com.turanapps.cnctorna.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.ProductRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentProductsBinding
import com.turanapps.cnctorna.model.products.Product
import com.turanapps.cnctorna.view.fragments.products.MetalFragment
import com.turanapps.cnctorna.view.fragments.products.PlasticFragment

class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding

    private lateinit var adapter: ProductRecyclerAdapter

    private lateinit var productArrayList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productArrayList = arrayListOf(
            Product(productName = getString(R.string.metal), productFragment = MetalFragment()),
            Product(productName = getString(R.string.plastic), productFragment = PlasticFragment())
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductRecyclerAdapter(productArrayList, parentFragmentManager)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)

    }

}