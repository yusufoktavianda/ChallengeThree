package binar.academy.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import binar.academy.navsample.Person
import binar.academy.navsample.R
import binar.academy.navsample.databinding.FragmentFourthBinding
import binar.academy.navsample.databinding.FragmentThirdBinding

class FourthFragment : Fragment() {
    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFourthBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        binding.fourthButton.setOnClickListener {
//            findNavController().popBackStack()
            sendDetailPerson()
        }
    }
    private fun sendDetailPerson(){
            val ageEditText = binding.ageEdittext.text.toString().toInt()
            val addressEditText = binding.addressEdittext.text.toString().trim()
            val jobEditText= binding.jobEdittext.text.toString().trim()
            val profileperson = Person(
                name= namepassing,
                age = ageEditText,
                address = addressEditText,
                job = jobEditText
            )
            findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToThirdFragment(profileperson))

    }
}