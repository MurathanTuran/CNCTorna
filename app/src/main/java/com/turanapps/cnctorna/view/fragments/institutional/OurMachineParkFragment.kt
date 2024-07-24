package com.turanapps.cnctorna.view.fragments.institutional

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.MachineRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentOurMachineParkBinding
import com.turanapps.cnctorna.model.institutional.Machine
import java.io.ByteArrayOutputStream

class OurMachineParkFragment : Fragment() {

    private lateinit var binding: FragmentOurMachineParkBinding

    private lateinit var adapter: MachineRecyclerAdapter

    private lateinit var machineArrayList: ArrayList<Machine>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        machineArrayList = arrayListOf(
            Machine(machineName = getString(R.string.first_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_hummer_t_42cl)),
            Machine(machineName = getString(R.string.second_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_arion_imt_42_ycs)),
            Machine(machineName = getString(R.string.third_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_star_sv_32)),
            Machine(machineName = getString(R.string.fourth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_cincom_l32)),
            Machine(machineName = getString(R.string.fifth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_maxtech_gtx_6)),
            Machine(machineName = getString(R.string.sixth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_capstan_lathe)),
            Machine(machineName = getString(R.string.seventh_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_thread_rolling))
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOurMachineParkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MachineRecyclerAdapter(requireContext(), requireView(), machineArrayList)
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