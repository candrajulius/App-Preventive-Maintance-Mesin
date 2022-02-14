package com.candra.preventivemaintancemesin.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.candra.preventivemaintancemesin.R
import com.candra.preventivemaintancemesin.adapter.ViewPagerAdapter
import com.candra.preventivemaintancemesin.databinding.ActivityMainBinding
import com.candra.preventivemaintancemesin.fragment.*
import com.google.android.material.tabs.TabLayoutMediator
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createListFragment()

        checkPermission()

    }

    private fun showDialogPermissionGranted() {
        AlertDialog.Builder(this)
            .setMessage("Aplikasi ini mebutuhkan fitur perizinan internal system android anda.." +
                    "Jika fitur ini tidak anda aktifkan. Anda tidak bisa menggunakan aplikasi ini" +
                    "Silahkan periksa Setting anda")
            .setTitle("Peringatan")
            .setIcon(R.mipmap.ic_launcher_foreground)
            .setPositiveButton("Go To Settings"){_,_ ->

                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package",packageName,null)
                    intent.data = uri
                    startActivity(intent)
                }catch (e: ActivityNotFoundException){
                    e.printStackTrace()
                    Log.d("MainActvity", "showDialogPermissionGranted: " + e.message.toString())
                }

            }

            .setNegativeButton("CANCEL"){dialog,_ ->
                dialog.dismiss()
                exitProcess(0)
            }.show()
    }

    private fun checkPermission(){
        Dexter.withContext(this@MainActivity)
            .withPermissions(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ).withListener(object: MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    if (p0?.areAllPermissionsGranted() == true){
                        Toast.makeText(this@MainActivity,"permission diizinkan", Toast.LENGTH_SHORT).show()
                    }else{
                        showDialogPermissionGranted()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    p1?.continuePermissionRequest()
                }

            }).onSameThread().check()
    }


    private fun createListFragment(){
        val tabLayout = binding.tabLayout
        val viewPager2 = binding.viewPager2


        val listFragment = arrayListOf(
            MilAFragment(),
            MilBFragment(),
            MilCFragment(),
            MilDFragment(),
            Crumb(),
            MilEFragment(),
            MilFFragment(),
            MilGFragment()
        )

        viewPager2.adapter = ViewPagerAdapter(listFragment,supportFragmentManager,lifecycle = lifecycle)

        TabLayoutMediator(tabLayout,viewPager2){
            tab,position ->
            when(position){
                0 -> {
                    tab.text = resources.getString(R.string.mailing_a)
                }
                1 -> {
                    tab.text = resources.getString(R.string.mailing_b)
                }
                2 -> {
                    tab.text = resources.getString(R.string.mailing_c)
                }
                3 -> {
                    tab.text = resources.getString(R.string.mailing_d)
                }
                4 -> {
                    tab.text = resources.getString(R.string.crumb)
                }
                5 -> {
                    tab.text = resources.getString(R.string.mailing_e)
                }
                6 -> {
                    tab.text = resources.getString(R.string.mailing_f)
                }
                7 -> {
                    tab.text = resources.getString(R.string.mailing_g)
                }
            }
        }.attach()

    }
}