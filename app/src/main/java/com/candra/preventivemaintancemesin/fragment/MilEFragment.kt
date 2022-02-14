package com.candra.preventivemaintancemesin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.candra.preventivemaintancemesin.Help
import com.candra.preventivemaintancemesin.R
import com.candra.preventivemaintancemesin.databinding.MailingEBinding

class MilEFragment: Fragment() {

    private lateinit var binding: MailingEBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MailingEBinding.inflate(inflater,container,false)

        allInputCalendar()

        setAllInputOpsiData()

        setAllInputOpsiData()

        setAllValidasiData()

        setExpandleCreeper()

        return binding.root
    }

    private fun allInputCalendar(){
        Help.setCalendar(binding.editTanggalMesin,requireContext())
        Help.setCalendar(binding.editTanggalMesin1,requireContext())
        Help.setCalendar(binding.editTanggalMesin3,requireContext())
        Help.setCalendar(binding.editTanggalMesin4A,requireContext())
        Help.setCalendar(binding.editTanggalMesin4B,requireContext())
        Help.setCalendar(binding.editTanggalMesin5A,requireContext())
        Help.setCalendar(binding.editTanggalMesin5B,requireContext())
        Help.setCalendar(binding.editTanggalMesin5C,requireContext())
        Help.setCalendar(binding.editTanggalMesin5D,requireContext())
    }

    private fun setAllInputOpsiData(){
        allInputEditOpsiCreeper1()
        allInputEditOpsiCreeper2()
        allInputEditOpsiCreeper3()
        allInputEditOpsiCreaper4A()
        allInputEditOpsiCreaper4B()
        allInputEditOpsiCreaper5A()
        allInputEditOpsiCreaper5B()
        allInputEditOpsiCreaper5C()
        allInputEditOpsiCreaper5D()
    }

    private fun setAllValidasiData(){
        binding.cetakPdf.setOnClickListener {
            validationMachineCraeper1()
        }

        binding.cetakPdf1.setOnClickListener {
            validationMachineCreeper2()
        }

        binding.cetakPdf3.setOnClickListener {
            validationMachineCreeper3()
        }

        binding.cetakPdf4A.setOnClickListener {
            validationMachineCreeper4A()
        }

        binding.cetakPdf4B.setOnClickListener {
            validationMachineCreeper4B()
        }

        binding.cetakPdf5A.setOnClickListener {
            validationMachineCreeper5A()
        }

        binding.cetakPdf5B.setOnClickListener {
            validationMachineCreeper5B()
        }

        binding.cetakPdf5C.setOnClickListener {
            validationMachineCreeper5C()
        }

        binding.cetakPdf5D.setOnClickListener {
            validationMachineCreeper5D()
        }
    }

    private fun allInputEditOpsiCreeper1(){
        Help.setAdapterData(binding.editEMotor,requireContext())
        Help.setAdapterData(binding.editGearBox,requireContext())
        Help.setAdapterData(binding.editBearing,requireContext())
        Help.setAdapterData(binding.editKondisiRoll,requireContext())
        Help.setAdapterData(binding.editParentBaut,requireContext())
        Help.setAdapterData(binding.editVBelt,requireContext())
        Help.setAdapterData(binding.editBagianKarat,requireContext())
        Help.setAdapterData(binding.editSuaraMesin,requireContext())
    }

    private fun allInputEditOpsiCreeper2(){
        Help.setAdapterData(binding.editEMotor1,requireContext())
        Help.setAdapterData(binding.editGearBox1,requireContext())
        Help.setAdapterData(binding.editBearing1,requireContext())
        Help.setAdapterData(binding.editKondisiRoll1,requireContext())
        Help.setAdapterData(binding.editParentBaut1,requireContext())
        Help.setAdapterData(binding.editVBelt1,requireContext())
        Help.setAdapterData(binding.editBagianKarat1,requireContext())
        Help.setAdapterData(binding.editSuaraMesin1,requireContext())
    }

    private fun allInputEditOpsiCreeper3(){
        Help.setAdapterData(binding.editEMotor3,requireContext())
        Help.setAdapterData(binding.editGearBox3,requireContext())
        Help.setAdapterData(binding.editBearing3,requireContext())
        Help.setAdapterData(binding.editKondisiRoll3,requireContext())
        Help.setAdapterData(binding.editParentBaut3,requireContext())
        Help.setAdapterData(binding.editVBelt3,requireContext())
        Help.setAdapterData(binding.editBagianKarat3,requireContext())
        Help.setAdapterData(binding.editSuaraMesin3,requireContext())
    }

    private fun allInputEditOpsiCreaper4A(){
        Help.setAdapterData(binding.editEMotor4A,requireContext())
        Help.setAdapterData(binding.editGearBox4A,requireContext())
        Help.setAdapterData(binding.editBearing4,requireContext())
        Help.setAdapterData(binding.editKondisiRoll4A,requireContext())
        Help.setAdapterData(binding.editParentBaut4A,requireContext())
        Help.setAdapterData(binding.editVBelt4A,requireContext())
        Help.setAdapterData(binding.editBagianKarat4A,requireContext())
        Help.setAdapterData(binding.editSuaraMesin4A,requireContext())
    }

    private fun allInputEditOpsiCreaper4B() {
        Help.setAdapterData(binding.editEMotor4B,requireContext())
        Help.setAdapterData(binding.editGearBox4B,requireContext())
        Help.setAdapterData(binding.editBearing4B,requireContext())
        Help.setAdapterData(binding.editKondisiRoll4B,requireContext())
        Help.setAdapterData(binding.editParentBaut4B,requireContext())
        Help.setAdapterData(binding.editVBelt4B,requireContext())
        Help.setAdapterData(binding.editBagianKarat4B,requireContext())
        Help.setAdapterData(binding.editSuaraMesin4B,requireContext())
    }

    private fun allInputEditOpsiCreaper5A(){
        Help.setAdapterData(binding.editEMotor5A,requireContext())
        Help.setAdapterData(binding.editGearBox5A,requireContext())
        Help.setAdapterData(binding.editBearing5A,requireContext())
        Help.setAdapterData(binding.editKondisiRoll5A,requireContext())
        Help.setAdapterData(binding.editParentBaut5A,requireContext())
        Help.setAdapterData(binding.editVBelt5A,requireContext())
        Help.setAdapterData(binding.editBagianKarat5A,requireContext())
        Help.setAdapterData(binding.editSuaraMesin5A,requireContext())
    }

    private fun allInputEditOpsiCreaper5B(){
        Help.setAdapterData(binding.editEMotor5B,requireContext())
        Help.setAdapterData(binding.editGearBox5B,requireContext())
        Help.setAdapterData(binding.editBearing5B,requireContext())
        Help.setAdapterData(binding.editKondisiRoll5B,requireContext())
        Help.setAdapterData(binding.editParentBaut5B,requireContext())
        Help.setAdapterData(binding.editVBelt5B,requireContext())
        Help.setAdapterData(binding.editBagianKarat5B,requireContext())
        Help.setAdapterData(binding.editSuaraMesin5B,requireContext())
    }

    private fun allInputEditOpsiCreaper5C(){
        Help.setAdapterData(binding.editEMotor5C,requireContext())
        Help.setAdapterData(binding.editGearBox5C,requireContext())
        Help.setAdapterData(binding.editBearing5C,requireContext())
        Help.setAdapterData(binding.editKondisiRoll5C,requireContext())
        Help.setAdapterData(binding.editParentBaut5C,requireContext())
        Help.setAdapterData(binding.editVBelt5C,requireContext())
        Help.setAdapterData(binding.editBagianKarat5C,requireContext())
        Help.setAdapterData(binding.editSuaraMesin5C,requireContext())
    }

    private fun allInputEditOpsiCreaper5D(){
        Help.setAdapterData(binding.editSuaraMesin5D,requireContext())
        Help.setAdapterData(binding.editGearBox5D,requireContext())
        Help.setAdapterData(binding.editBearing5D,requireContext())
        Help.setAdapterData(binding.editKondisiRoll5D,requireContext())
        Help.setAdapterData(binding.editParentBaut5D,requireContext())
        Help.setAdapterData(binding.editVBelt5D,requireContext())
        Help.setAdapterData(binding.editBagianKarat5D,requireContext())
        Help.setAdapterData(binding.editSuaraMesin5D,requireContext())
        Help.setAdapterData(binding.editEMotor5D,requireContext())
    }

    private fun validationMachineCraeper1(){
        val tanggalMesin = binding.parentTanggalMesin.editText?.text.toString()
        val parentEMotor = binding.parentEMotor.editText?.text.toString()
        val parentBearing = binding.parentBearing.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll.editText?.text.toString()
        val parentBaut = binding.parentBaut.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin.editText?.text.toString()
        val parentGearBox = binding.parentGearBox.editText?.text.toString()
        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
        ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin1))
    }

    private fun validationMachineCreeper2(){
        val tanggalMesin = binding.parentTanggalMesin1.editText?.text.toString()
        val parentEMotor = binding.parentEMotor1.editText?.text.toString()
        val parentBearing = binding.parentBearing1.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll1.editText?.text.toString()
        val parentBaut = binding.parentBaut1.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt1.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat1.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin1.editText?.text.toString()
        val parentGearBox = binding.parentGearBox1.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin2))

    }

    private fun validationMachineCreeper3(){
        val tanggalMesin = binding.parentTanggalMesin3.editText?.text.toString()
        val parentEMotor = binding.parentEMotor3.editText?.text.toString()
        val parentBearing = binding.parentBearing3.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll3.editText?.text.toString()
        val parentBaut = binding.parentBaut3.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt3.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat3.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin3.editText?.text.toString()
        val parentGearBox = binding.parentGearBox3.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin3))
    }

    private fun validationMachineCreeper4A(){
        val tanggalMesin = binding.parentTanggalMesin4A.editText?.text.toString()
        val parentEMotor = binding.parentEMotor4A.editText?.text.toString()
        val parentBearing = binding.parentBearing4A.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll4A.editText?.text.toString()
        val parentBaut = binding.parentBaut4A.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt4A.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat4A.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin4A.editText?.text.toString()
        val parentGearBox = binding.parentGearBox4A.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin4))
    }

    private fun validationMachineCreeper4B(){
        val tanggalMesin = binding.parentTanggalMesin4B.editText?.text.toString()
        val parentEMotor = binding.parentEMotor4B.editText?.text.toString()
        val parentBearing = binding.parentBearing4B.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll4B.editText?.text.toString()
        val parentBaut = binding.parentBaut4B.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt4B.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat4B.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin4B.editText?.text.toString()
        val parentGearBox = binding.parentGearBox4B.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin5))
    }

    private fun validationMachineCreeper5A(){
        val tanggalMesin = binding.parentTanggalMesin5A.editText?.text.toString()
        val parentEMotor = binding.parentEMotor5A.editText?.text.toString()
        val parentBearing = binding.parentBearing5A.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll5A.editText?.text.toString()
        val parentBaut = binding.parentBaut5A.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt5A.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat5A.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5A.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5A.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin6))
    }

    private fun validationMachineCreeper5B(){
        val tanggalMesin = binding.parentTanggalMesin5B.editText?.text.toString()
        val parentEMotor = binding.parentEMotor5B.editText?.text.toString()
        val parentBearing = binding.parentBearing5B.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll5B.editText?.text.toString()
        val parentBaut = binding.parentBaut5B.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt5B.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat5B.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5B.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5B.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin7))
    }

    private fun validationMachineCreeper5C(){
        val tanggalMesin = binding.parentTanggalMesin5C.editText?.text.toString()
        val parentEMotor = binding.parentEMotor5C.editText?.text.toString()
        val parentBearing = binding.parentBearing5C.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll5C.editText?.text.toString()
        val parentBaut = binding.parentBaut5C.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt5C.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat5C.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5C.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5C.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin8))
    }

    private fun validationMachineCreeper5D(){
        val tanggalMesin = binding.parentTanggalMesin5D.editText?.text.toString()
        val parentEMotor = binding.parentEMotor5D.editText?.text.toString()
        val parentBearing = binding.parentBearing5D.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll5D.editText?.text.toString()
        val parentBaut = binding.parentBaut5D.editText?.text.toString()
        val parentVBelt  = binding.parentVBelt5D.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat5D.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5D.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5D.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll
            ,parentBaut,parentVBelt,bagianKarat,parentKelainanSuara,requireContext(),resources.getString(
                R.string.name_mesin9))
    }

    private fun setExpandleCreeper(){
        Help.setExpandleCardView(binding.dropDown1,binding.linear1,binding.cardView1)
        Help.setExpandleCardView(binding.dropwDown2,binding.linear2,binding.cardView2)
        Help.setExpandleCardView(binding.dropDown3,binding.linear3,binding.cardView3)
        Help.setExpandleCardView(binding.dropDown4,binding.linear4,binding.cardView4)
        Help.setExpandleCardView(binding.dropwDown5,binding.linear5,binding.cardView5)
        Help.setExpandleCardView(binding.dropDown6,binding.linear6,binding.cardView6)
        Help.setExpandleCardView(binding.dropDown7,binding.linear7,binding.cardView7)
        Help.setExpandleCardView(binding.dropDown8,binding.linear8,binding.cardView8)
        Help.setExpandleCardView(binding.dropDown9,binding.linear9,binding.cardView9)
    }


}