package binar.academy.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import binar.academy.navsample.R
import binar.academy.navsample.databinding.FragmentFirstBinding
import binar.academy.navsample.databinding.FragmentThirdBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FragmentFirstBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
//        val button = view.findViewById<Button>(R.id.first_button)
        binding.firstButton.setOnClickListener {
//            val username = "Yusuf"
            findNavController().navigate(
//                FirstFragmentDirections.actionFirstFragmentToSecondFragment(username)
                R.id.action_firstFragment_to_secondFragment
            )
        }
    }
}