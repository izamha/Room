package com.therays.room.data.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.therays.room.R
import com.therays.room.model.User
import com.therays.room.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button.setOnClickListener {
            insertDataToDatabase()
        }

     return view
    }

    private fun insertDataToDatabase() {
      val firstName = firstName.text.toString()
      val lastName = secondName.text.toString()
      val age = age.text

        if (inputCheck(firstName, lastName, age)) {
            // Create a user object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            val exists = mUserViewModel.exists(firstName)
            println("////////---------------$exists-------------------/////////")
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added a user!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Nigga you's tripping!", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}