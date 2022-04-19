package com.imasha.locationserver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.imasha.locationserver.databinding.FragmentAddLocationBinding
import com.imasha.locationserver.models.LocationData
import com.imasha.locationserver.viewModels.LocationViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

const val TAG = "AddLocationFragment"

class AddLocationFragment : Fragment() {

    private var _binding: FragmentAddLocationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var locationViewModel: LocationViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddLocationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationViewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        binding.buttonSave.setOnClickListener { saveLocation() }

    }

    private fun saveLocation() {
        val name = binding.editTextLocationName.text.toString()
        val lat = binding.editTextLat.text.toString()
        val long = binding.editTextLat.text.toString()

        if (name.isNullOrEmpty() || lat.isNullOrEmpty() || long.isNullOrEmpty()) {
            Toast.makeText(context, "Some details are missing!", Toast.LENGTH_SHORT).show()
            return
        }

        locationViewModel.addNewLocation(LocationData(null, name, lat.toLong(), long.toLong()))
        Toast.makeText(context, "New location successfully added!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_add_location_to_home)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}