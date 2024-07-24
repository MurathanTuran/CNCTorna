package com.turanapps.cnctorna.view.fragments.institutional

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.ServiceRecyclerAdapter
import com.turanapps.cnctorna.adapter.SolutionPartnerRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentOurServicesBinding
import com.turanapps.cnctorna.databinding.FragmentSolutionPartnersBinding
import com.turanapps.cnctorna.model.Service
import com.turanapps.cnctorna.model.institutional.SolutionPartner
import java.io.ByteArrayOutputStream

class SolutionPartnersFragment : Fragment() {

    private lateinit var binding: FragmentSolutionPartnersBinding

    private lateinit var adapter: SolutionPartnerRecyclerAdapter

    private lateinit var solutionPartnerArrayList: ArrayList<SolutionPartner>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        solutionPartnerArrayList = arrayListOf(
            SolutionPartner(solutionPartnerName = "deneme", solutionPartnerImage = drawableToByteArray(requireContext(), R.drawable.working)),
            SolutionPartner(solutionPartnerName = "deneme", solutionPartnerImage = drawableToByteArray(requireContext(), R.drawable.working))
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSolutionPartnersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SolutionPartnerRecyclerAdapter(requireContext(), requireView(), solutionPartnerArrayList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)

    }

    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }

    private fun drawableToByteArray(context: Context, drawableId: Int): ByteArray {
        val drawable = ContextCompat.getDrawable(context, drawableId)
        val bitmap = drawableToBitmap(drawable!!)
        return bitmapToByteArray(bitmap)
    }

}