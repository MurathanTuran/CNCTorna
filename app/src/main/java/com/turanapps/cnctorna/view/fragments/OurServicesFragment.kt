package com.turanapps.cnctorna.view.fragments

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
import com.turanapps.cnctorna.adapter.ProductRecyclerAdapter
import com.turanapps.cnctorna.adapter.ServiceRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentOurServicesBinding
import com.turanapps.cnctorna.databinding.FragmentProductsBinding
import com.turanapps.cnctorna.model.Service
import com.turanapps.cnctorna.model.products.Product
import java.io.ByteArrayOutputStream

class OurServicesFragment : Fragment() {

    private lateinit var binding: FragmentOurServicesBinding

    private lateinit var adapter: ServiceRecyclerAdapter

    private lateinit var serviceArrayList: ArrayList<Service>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        serviceArrayList = arrayListOf(
            Service(serviceName = getString(R.string.cnc_automat_sliding_head_cnc), serviceImage = drawableToByteArray(requireContext(), R.drawable.cnc_automat_sliding_head_cnc)),
            Service(serviceName = getString(R.string.cnc_lathe), serviceImage = drawableToByteArray(requireContext(), R.drawable.cnc_lathe)),
            Service(serviceName = getString(R.string.cnc_milling), serviceImage = drawableToByteArray(requireContext(), R.drawable.cnc_milling)),
            Service(serviceName = getString(R.string.thread_rolling), serviceImage = drawableToByteArray(requireContext(), R.drawable.thread_rolling)),
            Service(serviceName = getString(R.string.machine_spare_parts), serviceImage = drawableToByteArray(requireContext(), R.drawable.machine_spare_parts)),
            Service(serviceName = getString(R.string.capstan_lathe), serviceImage = drawableToByteArray(requireContext(), R.drawable.capstan_lathe))
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOurServicesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ServiceRecyclerAdapter(requireContext(), requireView(), serviceArrayList)
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