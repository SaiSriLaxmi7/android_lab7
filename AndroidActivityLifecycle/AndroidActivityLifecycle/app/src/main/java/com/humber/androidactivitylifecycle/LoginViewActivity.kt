package com.humber.androidactivitylifecycle

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.humber.androidactivitylifecycle.model.LoginModel

class LoginViewActivity : ComponentActivity(), OnClickListener {

    private var login_view:TextView? = null;
    private var online_view:TextView? = null;
    private var back_btn:Button? = null;
    private var profile_btn:Button? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_view)
        Log.d("LoginViewActivity", "onStart");
        login_view = findViewById(R.id.login_view);
        online_view = findViewById(R.id.onine_view);
        back_btn = findViewById(R.id.back_btn);
        back_btn?.let {button -> button}
        profile_btn = findViewById(R.id.profile_btn);


    }

    override fun onStart() {
        super.onStart()
        Log.d("LoginViewActivity", "onStart");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LoginViewActivity", "onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("LoginViewActivity", "onResume");
        var model:LoginModel? = intent.getParcelableExtra("Login_model");
        login_view?.setText(model?.getLogin());
        var online = when(model?.getOnline()){
            true -> "Online"
            false -> "Offline"
            else -> "Unknown"
        }
        online_view?.setText(online);
    }

    override fun onPause() {
        super.onPause()
        Log.d("LoginViewActivity", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d("LoginViewActivity", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LoginViewActivity", "onStart");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LoginViewActivity", "onSaveInstanceState");
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("LoginViewActivity", "onRestoreStart");
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.back_btn ->{
                val model: LoginModel = LoginModel();
                model.setLogin(login_view?.text.toString())
                val online = when (online_view?.text.toString()){
                    "Online" -> true
                    "Offline" -> false
                    else -> false
                }
                model.setOnline(online);
                val intent:Intent =  Intent(this, MainActivity::class.java);
                intent.putExtra("login_view", model);
                startActivity(intent);
            }
            R.id.profile_btn -> {

            }
        }
    }

}