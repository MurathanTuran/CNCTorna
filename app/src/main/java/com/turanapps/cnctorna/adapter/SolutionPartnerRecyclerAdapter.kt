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
import com.turanapps.cnctorna.databinding.SolutionPartnerRecyclerRowBinding
import com.turanapps.cnctorna.model.institutional.SolutionPartner

class SolutionPartnerRecyclerAdapter(private val context: Context, private val parentView: View, private var solutionPartnerList: ArrayList<SolutionPartner>) : RecyclerView.Adapter<SolutionPartnerRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: SolutionPartnerRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SolutionPartnerRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return solutionPartnerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            solutionPartnerList[position].apply {

                val bitmap = BitmapFactory.decodeByteArray(this.solutionPartnerImage, 0, this.solutionPartnerImage.size)
                solutionPartnerImageView.setImageBitmap(bitmap)

                solutionPartnerTextView.text = solutionPartnerList[position].solutionPartnerName

            }
        }

        holder.itemView.setOnClickListener {
            val popupView = LayoutInflater.from(context).inflate(R.layout.popup_solution_partner_details, null)
            val popupImageView: ImageView = popupView.findViewById(R.id.popup_solution_partner_image)
            val popupHeaderTextView: TextView = popupView.findViewById(R.id.popup_solution_partner_header)

            popupImageView.setImageBitmap(BitmapFactory.decodeByteArray(solutionPartnerList[position].solutionPartnerImage, 0, solutionPartnerList[position].solutionPartnerImage.size))
            popupHeaderTextView.text = solutionPartnerList[position].solutionPartnerName

            val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow.isFocusable = true
            popupWindow.update()

            popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0)
        }

    }

}