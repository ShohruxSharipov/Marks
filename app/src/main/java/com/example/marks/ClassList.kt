package com.example.marks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.marks.Data.AppData
import com.example.marks.databinding.FragmentClassListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClassList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClassList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val appDatabase : AppData by lazy {
        AppData.getInstance(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?)
    : View? {
        val binding = FragmentClassListBinding.inflate(inflater,container,false)
        val list = appDatabase.runStudents().getStudentsByClass(param1.toString())
        var nameList = mutableListOf<String>()
        for (i in list){
            nameList.add(i.name)
        }
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,nameList)
        binding.studentslist.adapter = adapter

        binding.studentslist.setOnItemClickListener(AdapterView.OnItemClickListener(){ adapterView, view, i, l ->
            parentFragmentManager.beginTransaction().replace(com.example.marks.R.id.main,StudentInfo.newInstance(list[i].id,"")).addToBackStack("class").commit()
        })


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ClassList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                ClassList().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}