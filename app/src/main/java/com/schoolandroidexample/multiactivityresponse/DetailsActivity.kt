package com.schoolandroidexample.multiactivityresponse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.schoolandroidexample.multiactivityresponse.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra(
            MainActivity.KEY_DATA)

        binding.tvData.text = data

        binding.btnAccept.setOnClickListener {
            val intentResult = Intent()
            intentResult.putExtra(
                MainActivity.KEY_RES, "accept")

            setResult(Activity.RESULT_OK, intentResult)

            finish()
        }

        binding.btnDecline.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Toast.makeText(this,
            "You can not exit",
            Toast.LENGTH_LONG).show()
    }
}
