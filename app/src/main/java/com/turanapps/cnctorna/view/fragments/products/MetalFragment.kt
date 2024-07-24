package com.turanapps.cnctorna.view.fragments.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.ProductRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentMetalBinding
import com.turanapps.cnctorna.model.products.Product
import com.turanapps.cnctorna.model.products.metals.Metal

class MetalFragment : Fragment() {

    private lateinit var binding: FragmentMetalBinding

    private lateinit var adapter: ProductRecyclerAdapter

    private lateinit var metalArrayList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        metalArrayList = arrayListOf(
            Metal(metalName = getString(R.string.titanium)),
            Metal(metalName = getString(R.string.cast_iron)),
            Metal(metalName = getString(R.string.stainless_steel)),
            Metal(metalName = getString(R.string.nickel)),
            Metal(metalName = getString(R.string.steel)),
            Metal(metalName = getString(R.string.aluminum)),
            Metal(metalName = getString(R.string.copper)),
            Metal(metalName = getString(R.string.yellow_metal)),
            Metal(metalName = getString(R.string.bronze))
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMetalBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("deneme1")
        metalArrayList.forEach {
            println(it.productName)
        }


        //inheritance neden hata verdi!!!!!!!

        adapter = ProductRecyclerAdapter(metalArrayList, parentFragmentManager)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)

    }

}