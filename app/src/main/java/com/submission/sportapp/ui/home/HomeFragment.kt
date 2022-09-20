package com.submission.sportapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.sportapp.R
import com.submission.sportapp.core.data.Resource
import com.submission.sportapp.core.ui.SportsAdapter
import com.submission.sportapp.databinding.FragmentHomeBinding
import com.submission.sportapp.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val sportsAdapter = SportsAdapter()
            sportsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                    startActivity(intent)
            }

            homeViewModel.sports.observe(viewLifecycleOwner, { sports ->
                if(sports != null) {
                    when (sports) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            sportsAdapter.setData(sports.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = sports.message ?: getString(R.string.error)
                        }
                    }
                }
            })

            with(binding.rvSports){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = sportsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}