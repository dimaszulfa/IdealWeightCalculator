package com.example.idealweightcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.idealweightcalculator.databinding.FragmentHomeBinding
import com.example.idealweightcalculator.databinding.FragmentResultBinding
import com.example.idealweightcalculator.domain.BodyMass
import org.koin.android.ext.android.inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val body: BodyMass by inject()

/*
    private val args by navArgs<ResultFragmentArgs>()
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root

/*        val dataBMI = args.bmi
        val dataStatus = args.status
        binding.halo.text = dataBMI
        binding.status.text = dataStatus*/

        binding.btnNested.setOnClickListener {
            val toNestedFragment = ResultFragmentDirections.actionResultFragmentToNestedFragment22()
            findNavController(view).navigate(toNestedFragment)
        }


        return view
    }


}