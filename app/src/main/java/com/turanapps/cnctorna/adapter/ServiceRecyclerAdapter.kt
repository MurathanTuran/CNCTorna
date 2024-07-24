package com.turanapps.cnctorna.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.databinding.ServiceRecyclerRowBinding
import com.turanapps.cnctorna.model.Service

class ServiceRecyclerAdapter(private val context: Context, private val parentView: View, private var serviceList: ArrayList<Service>) : RecyclerView.Adapter<ServiceRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ServiceRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ServiceRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            serviceList[position].apply {

                val bitmap = BitmapFactory.decodeByteArray(this.serviceImage, 0, this.serviceImage.size)
                serviceImageView.setImageBitmap(bitmap)

                serviceTextView.text = serviceList[position].serviceName

            }
        }

        holder.itemView.setOnClickListener {
            val popupView = LayoutInflater.from(context).inflate(R.layout.popup_service_details, null)
            val popupImageView: ImageView = popupView.findViewById(R.id.popup_service_image)
            val popupHeaderTextView: TextView = popupView.findViewById(R.id.popup_service_header)
            val popupDetailsTextView: TextView = popupView.findViewById(R.id.popup_service_details)

            popupImageView.setImageBitmap(BitmapFactory.decodeByteArray(serviceList[position].serviceImage, 0, serviceList[position].serviceImage.size))
            popupHeaderTextView.text = serviceList[position].serviceName
            popupDetailsTextView.text = serviceList[position].serviceDetails

            val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow.isFocusable = true
            popupWindow.update()

            popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0)
        }

    }

}