package com.example.marks

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.marks.Data.AppData
import com.example.marks.Data.Entity.Students
import com.example.marks.Data.Entity.Teachers
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
    val appData : AppData by lazy {
        AppData.getInstance(requireContext())
    }

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
        var bol = false
        val subjects = mutableListOf("Algebra","Informatics","Ona Tili","Ingiliz tili")
        val role = mutableListOf("select role","Teacher","Student")
        val clas = mutableListOf<String>("5-01","5-02","5-03","5-04","6-01","6-02")
        binding.spinner.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,role)
        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0){
                    val a1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,subjects)
                    binding.subject.visibility = View.INVISIBLE
                    binding.selectmajr.visibility = View.INVISIBLE
                }
                if (p2 == 1){
                    val a1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,subjects)
                    binding.subject.visibility = View.VISIBLE
                    binding.subject.adapter = a1
                    binding.selectmajr.text = "Select Subject"
                    binding.selectmajr.visibility = View.VISIBLE
                    bol = true
                }
                if (p2 == 2){
                    binding.selectmajr.text = "Select Class"
                    binding.subject.visibility = View.VISIBLE
                    val a1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,clas)
                    binding.subject.adapter = a1
                    binding.selectmajr.visibility = View.VISIBLE
                    bol = true
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.next2.setOnClickListener {

            if (binding.userName.text.isNullOrBlank() || binding.userLog.text.isNullOrBlank() || binding.userPass.text.isNullOrBlank() || bol == false)
                Toast.makeText(requireContext(), "Complate all !!", Toast.LENGTH_SHORT).show()
            else if (binding.spinner.selectedItemPosition == 1){
                var subject = binding.subject.selectedItem.toString()
                appData.runTeachers().addTeacher(Teachers(name = binding.userName.text.toString(), login = binding.userLog.text.toString(), password = binding.userPass.text.toString(), subject = subject))
                parentFragmentManager.beginTransaction().replace(R.id.main, MainFragment()).commit()
            }
            else {
                var subject = binding.subject.selectedItem.toString()
                appData.runStudents().addStudent(Students(name = binding.userName.text.toString(), login = binding.userLog.text.toString(), password = binding.userPass.text.toString(), clas = subject, Student_marks = ""))
                parentFragmentManager.beginTransaction().replace(R.id.main, StudentWindow.newInstance(binding.userLog.text.toString(),binding.userPass.text.toString())).commit()
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