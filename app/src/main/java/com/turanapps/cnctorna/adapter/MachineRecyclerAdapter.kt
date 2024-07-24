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
import com.turanapps.cnctorna.databinding.MachineRecyclerRowBinding
import com.turanapps.cnctorna.model.institutional.Machine

class MachineRecyclerAdapter(private val context: Context, private val parentView: View, private var machineList: ArrayList<Machine>) : RecyclerView.Adapter<MachineRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: MachineRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MachineRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return machineList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            machineList[position].apply {

                val bitmap = BitmapFactory.decodeByteArray(this.machineImage, 0, this.machineImage.size)
                machineImageView.setImageBitmap(bitmap)

                machineTextView.text = machineList[position].machineName

            }
        }

        holder.itemView.setOnClickListener {
            val popupView = LayoutInflater.from(context).inflate(R.layout.popup_machine_details, null)
            val popupImageView: ImageView = popupView.findViewById(R.id.popup_machine_image)
            val popupHeaderTextView: TextView = popupView.findViewById(R.id.popup_machine_header)
            val popupDetailsTextView: TextView = popupView.findViewById(R.id.popup_machine_details)

            popupImageView.setImageBitmap(BitmapFactory.decodeByteArray(machineList[position].machineImage, 0, machineList[position].machineImage.size))
            popupHeaderTextView.text = machineList[position].machineName
            popupDetailsTextView.text = machineList[position].machineDetails

            val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow.isFocusable = true
            popupWindow.update()

            popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0)
        }

    }

}