package com.example.permissionapp


import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.permissionapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : Activity() {
    lateinit var binding: ActivityMainBinding
    val MY_PERMISSIONS_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupViews()
        setContentView(binding.root)
    }

    private fun setupViews() {
        with(binding) {
            button4.setOnClickListener {
                handlePermission("SEND_SMS")
            }
        }
    }

    private fun handlePermission(permission: String) {
        if (isPermissionGranted(permission)) {
            return
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                //show rationale
                Log.d("Log", "ShowRationale")
                showPermissionReasonAndRequest("We need it", permission, MY_PERMISSIONS_REQUEST)

            } else {
                Log.d("Log", "Just Request Rationale")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(permission),
                    MY_PERMISSIONS_REQUEST
                )
            }
        }

    }

    private fun isPermissionGranted(permission: String): Boolean =
        ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED


    private fun Activity.showPermissionReasonAndRequest(
        message: String,
        permission: String,
        requestCode: Int
    ) {
        // SnackBar
        val snackbar = Snackbar.make(binding.textView1, message, Snackbar.LENGTH_LONG)
        snackbar.setAction(requestCode) {
            ActivityCompat.requestPermissions(
                this@showPermissionReasonAndRequest,
                arrayOf(permission),
                requestCode
            )
        }
        snackbar.show()

    }


}