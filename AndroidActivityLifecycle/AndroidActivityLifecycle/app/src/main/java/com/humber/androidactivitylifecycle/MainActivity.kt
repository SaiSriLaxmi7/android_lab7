package com.humber.androidactivitylifecycle

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.humber.androidactivitylifecycle.model.LoginModel

class MainActivity : ComponentActivity(), View.OnClickListener {

    private var txtLogin: EditText? = null
    private var txtpassword: EditText? = null
    private var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val txtLogin:EditText = findViewById(R.id.login);
        val txtpassword:EditText=findViewById(R.id.password);
        val btnLogin:Button= findViewById(R.id.btn_login);
        Log.d("mainActivity","OnCreate");
        btnLogin?.let { button: Button -> button.setOnClickListener(this)  }
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("mainActivity","OnRestart");
    }
    override fun onStart() {
        super.onStart()
        Log.d("mainActivity","onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("mainActivity","onResume");
        val login_model:LoginModel? = intent.getParcelableExtra("login_view");
         txtLogin?.setText(login_model?.getLogin())
    }

    override fun onPause() {
        super.onPause()
        Log.d("mainActivity","onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d("mainActivity","onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mainActivity","onDestroy");
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("mainActivity","onConfigurationChanged");
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("mainActivity","onSaveInstanceState");
        outState.putString("login",txtLogin?.text.toString());
        outState.putString("Password",txtpassword?.text.toString());
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("mainActivity","onRestoreInstanceStace");
        var login = savedInstanceState?.getString("login");
        var password = savedInstanceState?.getString("password");
        txtLogin?.setText(login);
        txtpassword?.setText(password)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_login ->{

                val loginModel:LoginModel = LoginModel();
                loginModel.setLogin(txtLogin?.text.toString());
                loginModel.setOnline(false);
               var intent: Intent = Intent(this, LoginViewActivity::class.java);
                intent.putExtra("Login_model", loginModel);
                startActivity(intent);
            }
        }


    }
}