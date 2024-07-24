package com.turanapps.cnctorna.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.databinding.ProductRecyclerRowBinding
import com.turanapps.cnctorna.model.products.Product

class ProductRecyclerAdapter(private var productList: ArrayList<Product>, private var parentFragmentManager: FragmentManager) : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProductRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            productList[position].apply {

                val bitmap = BitmapFactory.decodeByteArray(this.productImage, 0, this.productImage.size)
                productImageView.setImageBitmap(bitmap)

                productTextView.text = productList[position].productName

            }
        }

        holder.itemView.setOnClickListener {
            productClick(productList[position].productFragment)
        }

    }

    private fun productClick(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }

}