package com.example.snoh.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snoh.database.TheProject
import com.example.snoh.database.TheProjectDatabase
import com.example.snoh.databinding.FragmentHomeBinding
import com.example.snoh.recycleveiwadapter.adapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    lateinit var db : TheProjectDatabase
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })

//        db = TheProjectDatabase.getDatabase(this)
//
//        GlobalScope.launch{
//            db.theproject_DAO().insertdata(TheProject(1,"aman jindoiya"))
//        }
        val adapter = adapter()
        val recycleview  = _binding!!.recycleview
        recycleview.adapter = adapter
        recycleview.layoutManager = LinearLayoutManager(requireContext())

        homeViewModel.readalldata.observe(viewLifecycleOwner, Observer{ theproject->
            adapter.setdata(theproject)
        })

        val button = binding.addme
        button.setOnClickListener{

            var name_text : String = "Aman jinodiya"
            homeViewModel.addData(TheProject(0,name_text))
            Toast.makeText(requireContext(),"Added succesfully ",Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}