package com.almseit.composition.presentation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.almseit.composition.R
import com.almseit.composition.databinding.FragmentGameBinding
import com.almseit.composition.domain.entity.GameResult
import com.almseit.composition.domain.entity.Level


class GameFragment : Fragment() {

   private val args by navArgs<GameFragmentArgs>()

    private  val viewModelFactory by lazy {
        GameViewModelFactory(requireActivity().application,args.level)
    }
    private val viewModel by lazy{
        ViewModelProvider(this,viewModelFactory)[GameViewModel::class.java]
    }




    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding = null")




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel()



    }


    private fun observeViewModel(){




        viewModel.gameResult.observe(viewLifecycleOwner){
            launcherGameFinishedFragment(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun launcherGameFinishedFragment(gameResult: GameResult){

        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult)
        )
    }






}