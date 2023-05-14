package com.example.marks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.marks.databinding.FragmentRegistrationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Registration.newInstance] factory method to
 * create an instance of this fragment.
 */
class Registration : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        val subjects = mutableListOf("Algebra","Informatics","Ona Tili","Ingiliz tili")
        val clas = mutableListOf<String>("5-01","5-02","5-03","5-04","6-01","6-02")
        binding.spinner.setOnItemClickListener { parent, view, position, id ->
            if (position == 2){
                val a1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,subjects)
                binding.subject.visibility = View.VISIBLE
                binding.subject.adapter = a1
                binding.selectmajr.visibility = View.VISIBLE
            }
            if (position == 3){
                binding.selectmajr.text = "Select Class"
                binding.subject.visibility = View.VISIBLE
                val a1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,clas)
                binding.subject.adapter = a1
                binding.selectmajr.visibility = View.VISIBLE
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Registration.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Registration().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}