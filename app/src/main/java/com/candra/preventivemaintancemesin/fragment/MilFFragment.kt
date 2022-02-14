package com.candra.preventivemaintancemesin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.candra.preventivemaintancemesin.Help
import com.candra.preventivemaintancemesin.Help.setCalendar
import com.candra.preventivemaintancemesin.Help.setExpandleCardView
import com.candra.preventivemaintancemesin.Help.setValidasiData
import com.candra.preventivemaintancemesin.databinding.MailingFBinding

class MilFFragment: Fragment() {

    private lateinit var binding: MailingFBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MailingFBinding.inflate(inflater,container,false)

        allInputCalendar()
        allSetExpandleCardView()
        allDataValidation()
        allDataMachine()

        return binding.root
    }

    private fun allInputCalendar(){
        setCalendar(binding.editTanggalMesin,requireContext())
        setCalendar(binding.editTanggalMesin2,requireContext())
        setCalendar(binding.editTanggalMesin3,requireContext())
        setCalendar(binding.editTanggalMesin4,requireContext())
        setCalendar(binding.editTanggalMesin5,requireContext())
    }

    private fun allDataMachine(){
        allFeedingRoll1and2()
        allBeltConveyor1and2()
        allFeederCakar3()
        allPenggulungBlanket()
        allSlingPenggulungBlanket()
    }

    private fun allFeedingRoll1and2(){
        Help.setAdapterData(binding.editEMotor,requireContext())
        Help.setAdapterData(binding.editGearBox,requireContext())
        Help.setAdapterData(binding.editBearing,requireContext())
        Help.setAdapterData(binding.editKondisiRoll,requireContext())
        Help.setAdapterData(binding.editParentBaut,requireContext())
        Help.setAdapterData(binding.editVBelt,requireContext())
        Help.setAdapterData(binding.editBagianKarat,requireContext())
        Help.setAdapterData(binding.editSuaraMesin,requireContext())
    }

    private fun allBeltConveyor1and2(){
        Help.setAdapterData(binding.editEMotor2,requireContext())
        Help.setAdapterData(binding.editGearBox2,requireContext())
        Help.setAdapterData(binding.editBearing2,requireContext())
        Help.setAdapterData(binding.editKondisiRoll2,requireContext())
        Help.setAdapterData(binding.editParentBaut2,requireContext())
        Help.setAdapterData(binding.editVBelt2,requireContext())
        Help.setAdapterData(binding.editBagianKarat2,requireContext())
        Help.setAdapterData(binding.editSuaraMesin2,requireContext())
    }

    private fun allFeederCakar3(){
        Help.setAdapterData(binding.editEMotor3,requireContext())
        Help.setAdapterData(binding.editGearBox3,requireContext())
        Help.setAdapterData(binding.editBearing3,requireContext())
        Help.setAdapterData(binding.editKondisiRoll3,requireContext())
        Help.setAdapterData(binding.editParentBaut3,requireContext())
        Help.setAdapterData(binding.editVBelt3,requireContext())
        Help.setAdapterData(binding.editBagianKarat3,requireContext())
        Help.setAdapterData(binding.editSuaraMesin3,requireContext())
    }

    private fun allPenggulungBlanket(){
        Help.setAdapterData(binding.editEMotor4,requireContext())
        Help.setAdapterData(binding.editGearBox4,requireContext())
        Help.setAdapterData(binding.editBearing4,requireContext())
        Help.setAdapterData(binding.editKondisiRoll4,requireContext())
        Help.setAdapterData(binding.editParentBaut4,requireContext())
        Help.setAdapterData(binding.editVBelt4,requireContext())
        Help.setAdapterData(binding.editBagianKarat4,requireContext())
        Help.setAdapterData(binding.editSuaraMesin4,requireContext())
    }

    private fun allSlingPenggulungBlanket(){
        Help.setAdapterData(binding.editEMotor5,requireContext())
        Help.setAdapterData(binding.editGearBox5,requireContext())
        Help.setAdapterData(binding.editBearing5,requireContext())
        Help.setAdapterData(binding.editKondisiRoll5,requireContext())
        Help.setAdapterData(binding.editParentBaut5,requireContext())
        Help.setAdapterData(binding.editVBelt5,requireContext())
        Help.setAdapterData(binding.editBagianKarat5,requireContext())
        Help.setAdapterData(binding.editSuaraMesin5,requireContext())
    }

    private fun allSetExpandleCardView(){
        setExpandleCardView(binding.dropDown1,binding.linear1,binding.cardView1)
        setExpandleCardView(binding.dropDown2,binding.linear2,binding.cardView2)
        setExpandleCardView(binding.dropDown3,binding.linear3,binding.cardView3)
        setExpandleCardView(binding.dropDown4,binding.linear4,binding.cardView4)
        setExpandleCardView(binding.dropDown5,binding.linear5,binding.cardView5)
    }

    private fun allDataValidation(){
        binding.cetakPdf.setOnClickListener {
            validationFeeding()
        }

        binding.cetakPdf2.setOnClickListener {
            validationBeltConveyor()
        }

        binding.cetakPdf3.setOnClickListener {
            validationFeederCakar3()
        }

        binding.cetakPdf4.setOnClickListener {
            validationPenggulunganBlanket()
        }

        binding.cetakPdf5.setOnClickListener {
            validationSlingPenggulunganBlanket()
        }



    }

    private fun validationFeeding(){
        val tanggalMesin = binding.parentTanggalMesin.editText?.text.toString()
        val parentEMotor = binding.parentEMotor.editText?.text.toString()
        val parentGearBox = binding.parentGearBox.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll.editText?.text.toString()
        val parentBaut = binding.parentBaut.editText?.text.toString()
        val parentVBelt = binding.parentVBelt.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat.editText?.text.toString()
        val parentKelaiananSuara = binding.parentKelainanSuaraMesin.editText?.text.toString()
        val parentBearing = binding.parentBearing.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEMotor,parentGearBox,parentBearing,parentKondisiRoll,
        parentBaut,parentVBelt,parentBagianKarat,parentKelaiananSuara,requireContext(),"FEEDING ROLL 1 & 2")
    }

    private fun validationBeltConveyor(){
        val tanggalMesin = binding.parentTanggalMesin2.editText?.text.toString()
        val parentEmotor = binding.parentEMotor2.editText?.text.toString()
        val parentGearBox = binding.parentGearBox2.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll2.editText?.text.toString()
        val parentBaut = binding.parentBaut2.editText?.text.toString()
        val parentVBelt = binding.parentVBelt2.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat2.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin2.editText?.text.toString()
        val parentBearing = binding.parentBearing2.editText?.text.toString()

        Help.setValidasiData(tanggalMesin,parentEmotor,parentGearBox,parentBearing,parentKondisiRoll,
        parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"BELT CONVEYOR 1 & 2")
    }

    private fun validationFeederCakar3(){
        val tanggalMesin = binding.parentTanggalMesin3.editText?.text.toString()
        val parentEmotor = binding.parentEMotor3.editText?.text.toString()
        val parentGearBox = binding.parentGearBox3.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll3.editText?.text.toString()
        val parentBaut = binding.parentBaut3.editText?.text.toString()
        val parentVBelt = binding.parentVBelt3.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat3.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin3.editText?.text.toString()
        val parentBearing = binding.parentBearing3.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEmotor,parentGearBox,parentBearing,parentKondisiRoll,
            parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"FEEDER CAKAR-3")

    }

    private fun validationPenggulunganBlanket(){
        val tanggalMesin = binding.parentTanggalMesin4.editText?.text.toString()
        val parentEmotor = binding.parentEMotor4.editText?.text.toString()
        val parentGearBox = binding.parentGearBox4.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll4.editText?.text.toString()
        val parentBaut = binding.parentBaut4.editText?.text.toString()
        val parentVBelt = binding.parentVBelt4.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat4.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin4.editText?.text.toString()
        val parentBearing = binding.parentBearing4.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEmotor,parentGearBox,parentBearing,parentKondisiRoll,
            parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"PENGGULUNG BLANKET")

    }

    private fun validationSlingPenggulunganBlanket(){
        val tanggalMesin = binding.parentTanggalMesin5.editText?.text.toString()
        val parentEmotor = binding.parentEMotor5.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5.editText?.text.toString()
        val parentKondisiRoll = binding.parentKondisiRoll5.editText?.text.toString()
        val parentBaut = binding.parentBaut5.editText?.text.toString()
        val parentVBelt = binding.parentVBelt5.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat5.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5.editText?.text.toString()
        val parentBearing = binding.parentBearing5.editText?.text.toString()

        setValidasiData(tanggalMesin,parentEmotor,parentGearBox,parentBearing,parentKondisiRoll,
            parentBaut,parentVBelt,parentBagianKarat,parentKelainanSuara,requireContext(),"SLING PENGGULUNG BLANKET")

    }

}