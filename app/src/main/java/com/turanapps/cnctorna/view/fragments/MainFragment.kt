package com.turanapps.cnctorna.view.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.MachineRecyclerAdapter
import com.turanapps.cnctorna.adapter.ProductRecyclerAdapter
import com.turanapps.cnctorna.adapter.ServiceRecyclerAdapter
import com.turanapps.cnctorna.adapter.SolutionPartnerRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentMainBinding
import com.turanapps.cnctorna.model.Service
import com.turanapps.cnctorna.model.institutional.Machine
import com.turanapps.cnctorna.model.institutional.SolutionPartner
import com.turanapps.cnctorna.model.products.Product
import com.turanapps.cnctorna.view.fragments.products.MetalFragment
import com.turanapps.cnctorna.view.fragments.products.PlasticFragment
import java.io.ByteArrayOutputStream

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var serviceAdapter: ServiceRecyclerAdapter
    private lateinit var machineAdapter: MachineRecyclerAdapter
    private lateinit var productAdapter: ProductRecyclerAdapter
    private lateinit var solutionPartnerAdapter: SolutionPartnerRecyclerAdapter

    private lateinit var serviceArrayList: ArrayList<Service>
    private lateinit var machineArrayList: ArrayList<Machine>
    private lateinit var productArrayList: ArrayList<Product>
    private lateinit var solutionPartnerArrayList: ArrayList<SolutionPartner>

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

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

        machineArrayList = arrayListOf(
            Machine(machineName = getString(R.string.first_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_hummer_t_42cl)),
            Machine(machineName = getString(R.string.second_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_arion_imt_42_ycs)),
            Machine(machineName = getString(R.string.third_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_star_sv_32)),
            Machine(machineName = getString(R.string.fourth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_cincom_l32)),
            Machine(machineName = getString(R.string.fifth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_maxtech_gtx_6)),
            Machine(machineName = getString(R.string.sixth_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_capstan_lathe)),
            Machine(machineName = getString(R.string.seventh_machine), machineImage = drawableToByteArray(requireContext(), R.drawable.machine_thread_rolling))
        )

        productArrayList = arrayListOf(
            Product(productName = getString(R.string.metal), productFragment = MetalFragment()),
            Product(productName = getString(R.string.plastic), productFragment = PlasticFragment())
        )

        solutionPartnerArrayList = arrayListOf(
            SolutionPartner(solutionPartnerName = "deneme", solutionPartnerImage = drawableToByteArray(requireContext(), R.drawable.working)),
            SolutionPartner(solutionPartnerName = "deneme", solutionPartnerImage = drawableToByteArray(requireContext(), R.drawable.working))
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync { map ->
            googleMap = map
            MapsInitializer.initialize(requireActivity())
            val istanbul = LatLng(41.069716727588, 28.802674000000007)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(istanbul, 15f))
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.uiSettings.isZoomControlsEnabled = false
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceAdapter = ServiceRecyclerAdapter(requireContext(), requireView(), serviceArrayList)
        binding.servicesRecyclerView.adapter = serviceAdapter
        binding.servicesRecyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext, LinearLayoutManager.HORIZONTAL, false)

        machineAdapter = MachineRecyclerAdapter(requireContext(), requireView(), machineArrayList)
        binding.machineParkRecyclerView.adapter = machineAdapter
        binding.machineParkRecyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext, LinearLayoutManager.HORIZONTAL, false)

        productAdapter = ProductRecyclerAdapter(productArrayList, parentFragmentManager)
        binding.productsRecyclerView.adapter = productAdapter
        binding.productsRecyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext, LinearLayoutManager.HORIZONTAL, false)

        solutionPartnerAdapter = SolutionPartnerRecyclerAdapter(requireContext(), requireView(), solutionPartnerArrayList)
        binding.solutionPartnersRecyclerView.adapter = solutionPartnerAdapter
        binding.solutionPartnersRecyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext, LinearLayoutManager.HORIZONTAL, false)



        communicationBannerButtonClick()

    }

    private fun communicationBannerButtonClick(){
        binding.communicationBannerButton.setOnClickListener {

            val phoneNumber: String = getString(R.string.phone_number)
            val callIntent: Intent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse(phoneNumber))
            startActivity(callIntent)

        }
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

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}