package com.example.idealweightcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idealweightcalculator.databinding.FragmentFavoriteBinding
import com.example.idealweightcalculator.domain.BodyMass
import com.example.idealweightcalculator.domain.Favorite
import com.example.idealweightcalculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    fun test(): (Favorite)-> Unit = {
//        vm.setFavorite(it.toBodyMass())
        vm.deleteFav(it)
//        vm.getFavorite()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteAdapter(test())
        binding.rvBmi.adapter = adapter
        binding.rvBmi.setHasFixedSize(true)
        adapter.context = context
        vm.getFavorite()
        vm.favorite.observe(viewLifecycleOwner, Observer {
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

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val vm: MainViewModel by lazy { requireParentFragment().getViewModel<MainViewModel>() }
    private lateinit var adapter: FavoriteAdapter
}