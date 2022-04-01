package com.example.idealweightcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idealweightcalculator.databinding.FragmentNestedBinding
import com.example.idealweightcalculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class NestedFragment : Fragment() {

    private var _binding: FragmentNestedBinding? = null
    private val binding get() = _binding!!
    private val vm: MainViewModel by lazy { requireParentFragment().getViewModel<MainViewModel>() }
    private lateinit var adapter: NestedAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNestedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NestedAdapter {
//            Toast.makeText(context,it.name,Toast.LENGTH_SHORT).show()
            vm.setFavorite(it)

/*            if (it.isFavorite == true) {
                vm.setFavorite(it)
                vm.addtoFavorite(it.toFavorite())
            } else{
                vm.setFavorite(it)
            }*/
        }
        binding.rvBmi.adapter = adapter
        binding.rvBmi.setHasFixedSize(true)
        adapter.context = context
        vm.getAllBmi()

        vm.bmi.observe(viewLifecycleOwner, Observer {
            adapter.addData(it)
            adapter.notifyDataSetChanged()

        })

        binding.rvBmi.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL, false
        )


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}