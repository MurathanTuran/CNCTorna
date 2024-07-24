package com.turanapps.cnctorna.view.fragments.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.adapter.ProductRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentPlasticBinding
import com.turanapps.cnctorna.model.products.Product

class PlasticFragment : Fragment() {

    private lateinit var binding: FragmentPlasticBinding

    private lateinit var adapter: ProductRecyclerAdapter

    private lateinit var productArrayList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlasticBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("deneme1")
        productArrayList.forEach {
            println(it.productName)
        }


        adapter = ProductRecyclerAdapter(productArrayList, parentFragmentManager)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)

    }

}