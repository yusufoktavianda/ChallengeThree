package binar.academy.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import binar.academy.navsample.Person
import binar.academy.navsample.R
import binar.academy.navsample.databinding.FragmentSecondBinding
import binar.academy.navsample.databinding.FragmentThirdBinding

lateinit var namepassing: String

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSecondBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
//        val button = view.findViewById<Button>(R.id.second_button)
//        usernameTextView.text = arguments.username
        binding.secondButton.setOnClickListener {
            sendPersonToThird()
        }
    }

    private fun sendPersonToThird() {
        val usernameEditText = binding.usernameEdittext.text.toString().trim()
//        val usernameTextView = view?.findViewById<TextView>(R.id.username_edittext)?.text.toString().trim()
        val age = ""
        namepassing = usernameEditText
        val name = Person(
            name = usernameEditText,
            0,
            "",
            ""
        )
        findNavController().navigate(
            SecondFragmentDirections.actionSecondFragmentToThirdFragment(
                name
            )
        )
    }
}