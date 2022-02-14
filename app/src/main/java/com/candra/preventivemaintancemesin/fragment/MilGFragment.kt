package com.candra.preventivemaintancemesin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.candra.preventivemaintancemesin.Help.setAdapterData
import com.candra.preventivemaintancemesin.Help.setCalendar
import com.candra.preventivemaintancemesin.Help.setExpandleCardView
import com.candra.preventivemaintancemesin.Help.setValidasiData
import com.candra.preventivemaintancemesin.databinding.MailingGBinding

class MilGFragment:Fragment() {

    private lateinit var binding: MailingGBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MailingGBinding.inflate(inflater,container,false)

        allCalendarInput()

        allDataOpsiInput()

        setDataAllClick()

        setExpandleCardViewAll()

        return binding.root
    }

    private fun setExpandleCardViewAll(){
       setExpandleCardView(binding.dropDown1,binding.linear1,binding.cardView1)
       setExpandleCardView(binding.dropDown2,binding.linear2,binding.cardView2)
    }

    private fun allCalendarInput(){
        setCalendar(binding.editTanggalMesin,requireContext())
        setCalendar(binding.editTanggalMesin2,requireContext())
    }

    private fun setCreeperSkimAAndB(){
        setAdapterData(binding.editEMotor2,requireContext())
        setAdapterData(binding.editGearBox2,requireContext())
        setAdapterData(binding.editBearing2,requireContext())
        setAdapterData(binding.editKondisiRoll2,requireContext())
        setAdapterData(binding.editParentBaut2,requireContext())
        setAdapterData(binding.editVBelt2,requireContext())
        setAdapterData(binding.editBagianKarat2,requireContext())
        setAdapterData(binding.editSuaraMesin2,requireContext())
    }

    private fun setDataCreeperTestingOpsi(){
        setAdapterData(binding.editEMotor,requireContext())
        setAdapterData(binding.editGearBox,requireContext())
        setAdapterData(binding.editBearing,requireContext())
        setAdapterData(binding.editKondisiRoll,requireContext())
        setAdapterData(binding.editParentBaut,requireContext())
        setAdapterData(binding.editVBelt,requireContext())
        setAdapterData(binding.editBagianKarat,requireContext())
        setAdapterData(binding.editSuaraMesin,requireContext())
    }

    private fun allDataOpsiInput(){
        setDataCreeperTestingOpsi()
        setCreeperSkimAAndB()
    }

    private fun setDataAllClick(){
        binding.cetakPdf.setOnClickListener {
            validationCreeperTesting()
        }

        binding.cetakPdf2.setOnClickListener {
            validationCreeperSKimAB()
        }
    }

    private fun validationCreeperTesting(){
        val tanggalMesin = binding.parentTanggalMesin.editText?.text.toString()
        val parentEMotor = binding.parentEMotor.editText?.text.toString()
        val parentGearBox = binding.parentGearBox.editText?.text.toString()
        val parentBearing = binding.parentBearing.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll.editText?.text.toString()
        val parentBaut = binding.parentBaut.editText?.text.toString()
        val parentVBelt = binding.parentVBelt.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll,
        parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"CREEPER TESTING")
    }

    private fun validationCreeperSKimAB(){
        val tanggalMesin = binding.parentTanggalMesin2.editText?.text.toString()
        val parentEMotor = binding.parentEMotor2.editText?.text.toString()
        val parentGearBox = binding.parentGearBox2.editText?.text.toString()
        val parentBearing = binding.parentBearing2.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll2.editText?.text.toString()
        val parentBaut = binding.parentBaut2.editText?.text.toString()
        val parentVBelt = binding.parentVBelt2.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat2.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin2.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll,
            parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"CREEPER SKIM A & B")
    }

}