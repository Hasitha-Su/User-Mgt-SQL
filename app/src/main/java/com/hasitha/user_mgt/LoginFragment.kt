package com.hasitha.user_mgt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.hasitha.user_mgt.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.loginBtn)
        loginButton.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val usernameEditText: EditText = view?.findViewById(R.id.username_editText) ?: return
        val passwordEditText: EditText = view?.findViewById(R.id.password_editText) ?: return
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (username.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a username", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a password", Toast.LENGTH_SHORT).show()
            return
        }

        if (username == "admin" && password == "password") {
            findNavController().navigate(R.id.homeFragment)
        } else {
            Toast.makeText(requireContext(), "Incorrect username or password", Toast.LENGTH_SHORT).show()
        }
    }

}