package binar.academy.navsample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import binar.academy.navsample.Person
import binar.academy.navsample.R
import binar.academy.navsample.databinding.FragmentSecondBinding
import binar.academy.navsample.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private val arguments: ThirdFragmentArgs by navArgs()
    private var age: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentThirdBinding.bind(view)

        super.onViewCreated(view, savedInstanceState)
        val name = arguments.profileperson.name
        val age = arguments.profileperson.age
        val address = arguments.profileperson.address
        val job = arguments.profileperson.job
        val person = arguments.profileperson.toString()

        Log.d("Third",name)
//        Log.d("Third", person.toString())
//        Log.d("Third", personName)
        if ((address != "")) {
            showPerson()
        } else if ((name != "")) {
            showName()
        }else{
            showPerson()
        }
//        showPerson()
//        showName()
        binding.thirdButton.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }
    }
    private fun showName(){
        binding.nameFragmentThird.text = arguments.profileperson.name
    }
    private fun showPerson() {
        val person = arguments.profileperson.toString()
        Log.d("thirdperson",person)
        binding.nameFragmentThird.visibility = View.INVISIBLE
        binding.viewDetailThird.detailThirdLayout.visibility = View.VISIBLE
        binding.viewDetailThird.nameDetailprofileTextview.text = arguments.profileperson.name
        val myage =arguments.profileperson.age
        if (myage % 2 == 0) {
            age = "$myage, bernilai Genap"
        } else if (myage % 2 != 0) {
            age = "$myage, bernilai Ganjil"
        }
        binding.viewDetailThird.ageDetailprofileTextview.text =age
        binding.viewDetailThird.addressDetailprofileTextview.text =arguments.profileperson.address
        binding.viewDetailThird.jobDetailprofileTextview.text =arguments.profileperson.job

    }
}