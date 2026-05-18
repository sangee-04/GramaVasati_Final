package com.example.gramavasathi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLogin()
    }

    private fun base(title: String) {
        container = LinearLayout(this)
        container.orientation = LinearLayout.VERTICAL
        container.gravity = Gravity.CENTER
        container.setPadding(40, 40, 40, 40)
        container.setBackgroundColor(Color.rgb(232, 245, 233))

        val heading = TextView(this)
        heading.text = title
        heading.textSize = 28f
        heading.setTextColor(Color.rgb(27, 94, 32))
        heading.gravity = Gravity.CENTER
        heading.setPadding(0, 0, 0, 30)

        container.addView(heading)
        setContentView(container)
    }

    private fun input(hint: String): EditText {
        val e = EditText(this)
        e.hint = hint
        e.setPadding(25, 15, 25, 15)
        e.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return e
    }

    private fun btn(text: String): Button {
        val b = Button(this)
        b.text = text
        b.setBackgroundColor(Color.rgb(46, 125, 50))
        b.setTextColor(Color.WHITE)
        return b
    }

    private fun showLogin() {
        base("Grama Vasathi")

        val email = input("Enter Email")
        val password = input("Enter Password")
        val login = btn("Login")
        val register = btn("Create Account")

        container.addView(email)
        container.addView(password)
        container.addView(login)
        container.addView(register)

        login.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                showHome()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        register.setOnClickListener {
            showRegister()
        }
    }

    private fun showRegister() {
        base("Create Account")

        val name = input("Full Name")
        val email = input("Email")
        val password = input("Password")
        val create = btn("Register")

        container.addView(name)
        container.addView(email)
        container.addView(password)
        container.addView(create)

        create.setOnClickListener {
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_LONG).show()
            showLogin()
        }
    }

    private fun showHome() {
        base("Welcome to Grama Vasathi")

        val desc = TextView(this)
        desc.text =
            "Grama Vasathi is a rural hospitality Android application."
        desc.textSize = 17f
        desc.setTextColor(Color.DKGRAY)
        desc.gravity = Gravity.CENTER
        desc.setPadding(10, 10, 10, 30)

        val booking = btn("Accommodation Booking")
        val profile = btn("User Profile")
        val chatbot = btn("Chatbot Support")
        val feedback = btn("Feedback")
        val logout = btn("Logout")

        container.addView(desc)
        container.addView(booking)
        container.addView(profile)
        container.addView(chatbot)
        container.addView(feedback)
        container.addView(logout)

        logout.setOnClickListener {
            showLogin()
        }
    }
}
