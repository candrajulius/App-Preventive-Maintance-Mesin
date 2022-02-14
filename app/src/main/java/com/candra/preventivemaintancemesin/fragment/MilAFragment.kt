package com.candra.preventivemaintancemesin.fragment

import android.app.DatePickerDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.candra.preventivemaintancemesin.Help
import com.candra.preventivemaintancemesin.R
import com.candra.preventivemaintancemesin.databinding.MailingABinding
import com.google.android.material.textfield.TextInputEditText
import com.itextpdf.barcodes.BarcodeQRCode
import com.itextpdf.kernel.colors.ColorConstants
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.property.HorizontalAlignment
import com.itextpdf.layout.property.TextAlignment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class MilAFragment : Fragment()

{
    private lateinit var binding: MailingABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MailingABinding.inflate(inflater,container,false)


        binding.apply {
            cetakPdf.setOnClickListener {
                validasiData1()
            }

            cetakPdf2.setOnClickListener {
                validasiData2()
            }

            cetakPdf3.setOnClickListener {
                validasiData3()
            }

            cetakPdf4.setOnClickListener {
                validasiData4()
            }

            cetakPdf5.setOnClickListener {
                validasiData5()
            }

            cetakPdf6.setOnClickListener {
                validasiData6()
            }

            cetakPdf7.setOnClickListener {
                validasiData7()
            }

        }

        setCalendarInputanUser()

        allDataInputanUser()


        return binding.root
    }

    private fun allDataInputanUser(){
        allDataInputanUserBreaker()

        allDataInputUserFussedBreaker()

        allDataInputUserScrewConveyor()

        allDataInputUserConveyor()

        allDataInputUserHammermil()

        allDataInputanUserFeederCakar()

        allDataInputanUserVortexPumpHamermil()
    }

    private fun allDataInputanUserVortexPumpHamermil(){
        setAdapterData(binding.editEMotor7)
        setAdapterData(binding.editGearBox7)
        setAdapterData(binding.editBearing7)
        setAdapterData(binding.editGearSproket7)
        setAdapterData(binding.editPisauDuduk7)
        setAdapterData(binding.editHasilRanjangan7)
        setAdapterData(binding.editBagianKarat7)
        setAdapterData(binding.editSuaraMesin7)
    }

    private fun allDataInputanUserFeederCakar(){
        setAdapterData(binding.editEMotor6)
        setAdapterData(binding.editGearBox6)
        setAdapterData(binding.editBearing6)
        setAdapterData(binding.editGearSproket6)
        setAdapterData(binding.editPisauDuduk6)
        setAdapterData(binding.editHasilRanjangan6)
        setAdapterData(binding.editBagianKarat6)
        setAdapterData(binding.editSuaraMesin6)
    }

    private fun allDataInputanUserBreaker(){
        setAdapterData(binding.editEMotor)
        setAdapterData(binding.editGearBox)
        setAdapterData(binding.editBearing)
        setAdapterData(binding.editGearSproket)
        setAdapterData(binding.editPisauDuduk)
        setAdapterData(binding.editHasilRanjangan)
        setAdapterData(binding.editBagianKarat)
        setAdapterData(binding.editSuaraMesin)
    }

    private fun allDataInputUserFussedBreaker(){
        setAdapterData(binding.editEMotor1)
        setAdapterData(binding.editGearBox1)
        setAdapterData(binding.editBearing1)
        setAdapterData(binding.editGearSproket1)
        setAdapterData(binding.editPisauDuduk1)
        setAdapterData(binding.editHasilRanjangan1)
        setAdapterData(binding.editBagianKarat1)
        setAdapterData(binding.editSuaraMesin1)
    }

    private fun allDataInputUserScrewConveyor(){
        setAdapterData(binding.editEMotor2)
        setAdapterData(binding.editGearBox2)
        setAdapterData(binding.editBearing2)
        setAdapterData(binding.editGearSproket2)
        setAdapterData(binding.editPisauDuduk2)
        setAdapterData(binding.editHasilRanjangan2)
        setAdapterData(binding.editBagianKarat2)
        setAdapterData(binding.editSuaraMesin2)
    }

    private fun allDataInputUserConveyor(){
        setAdapterData(binding.editEMotor4)
        setAdapterData(binding.editGearBox4)
        setAdapterData(binding.editBearing4)
        setAdapterData(binding.editGearSproket4)
        setAdapterData(binding.editPisauDuduk4)
        setAdapterData(binding.editHasilRanjangan4)
        setAdapterData(binding.editBagianKarat4)
        setAdapterData(binding.editSuaraMesin4)
    }

    private fun allDataInputUserHammermil(){
        setAdapterData(binding.editEMotor5)
        setAdapterData(binding.editGearBox5)
        setAdapterData(binding.editBearing5)
        setAdapterData(binding.editGearSproket5)
        setAdapterData(binding.editPisauDuduk5)
        setAdapterData(binding.editHasilRanjangan5)
        setAdapterData(binding.editBagianKarat5)
        setAdapterData(binding.editSuaraMesin5)
    }


    private fun setAdapterData(text: AutoCompleteTextView){
        val data: Array<String> = resources.getStringArray(R.array.opsi)
        val arrayAdapter =ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,data)
        text.setAdapter(arrayAdapter)
    }

    private fun validasiData1(){
       binding.apply {
            val tanggal = parentTanggalMesin.editText?.text.toString()
            val parentEMotor = parentEMotor.editText?.text.toString()
            val parentGearBox = parentGearBox.editText?.text.toString()
            val parentBearing = parentBearing.editText?.text.toString()
            val parentGearSproket = parentGearSproket.editText?.text.toString()
            val parentPisauDuduk = parentPisauDuduk.editText?.text.toString()
            val hasilRanjangan = parentHasilRanjangan.editText?.text.toString()
            val parentBagianKarat = parentBagianKarat.editText?.text.toString()
            val parentKelainanSuaraMesin = parentKelainanSuaraMesin.editText?.text.toString()


           if(tanggal.isEmpty()){
               binding.parentTanggalMesin.error = "Tangagl masih kosong"
               binding.parentTanggalMesin.isErrorEnabled = true
               binding.parentTanggalMesin.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if(parentEMotor.isEmpty()){
               binding.parentEMotor.error = "E motor masih kosong"
               binding.parentEMotor.isErrorEnabled = true
               binding.parentEMotor.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if(parentGearBox.isEmpty()){
               binding.parentGearBox.error = "Gear box masih kosong"
               binding.parentGearBox.isErrorEnabled = true
               binding.parentGearBox.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if (parentBearing.isEmpty()){
               binding.parentBearing.isErrorEnabled = true
               binding.parentBearing.setErrorTextColor(ColorStateList.valueOf(Color.RED))
               binding.parentBearing.error = "Bearing masih kosong"
           }else if (parentGearSproket.isEmpty()){
               binding.parentGearSproket.error = "Gear sproket masih kosong"
               binding.parentGearSproket.isErrorEnabled = true
               binding.parentGearSproket.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if (parentPisauDuduk.isEmpty()){
               binding.parentPisauDuduk.error = "Pisau duduk masih kosong"
               binding.parentPisauDuduk.isErrorEnabled = true
               binding.parentPisauDuduk.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if(hasilRanjangan.isEmpty()){
               binding.parentHasilRanjangan.error = "Hasil ranjangan masih kosong"
               binding.parentHasilRanjangan.isErrorEnabled = true
               binding.parentHasilRanjangan.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if(parentBagianKarat.isEmpty()){
               binding.parentBagianKarat.error = "Bagian karat masih kosong"
               binding.parentBagianKarat.isErrorEnabled = true
               binding.parentBagianKarat.setErrorTextColor(ColorStateList.valueOf(Color.RED))
           }else if (parentKelainanSuaraMesin.isEmpty()){
               binding.parentKelainanSuaraMesin.isErrorEnabled = true
               binding.parentKelainanSuaraMesin.setErrorTextColor(ColorStateList.valueOf(Color.RED))
               binding.parentKelainanSuaraMesin.error = "Kelainan suara masih kosong"
           }else {
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk
                ,hasilRanjangan,parentBagianKarat,parentKelainanSuaraMesin,"BREAKER")
               Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()

           }
       }
    }

    private fun createPdf(tanggalMesin: String,parentEMotor:String,parentGearBox: String
    ,parentBearing: String,parentGearSproket: String,parentPisauDuduk: String,hasilRanjangan: String,
    parentBagianKarat: String,parentKelainanSuara: String,namaMesin: String)
    {

        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val tanggalData: String = simpelDateFormat

        val file = File(path,"$tanggalData $namaMesin.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A4
        document.setMargins(0F,0F,0F,0F)

        val paragraphTitle = Paragraph(namaMesin).setBold().setFontSize(24F).setTextAlignment(TextAlignment.LEFT)

        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal :$simpelDateFormat dan waktu: $waktu").setFontSize(18F).setTextAlignment(TextAlignment.LEFT)


        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F,100F)
        val tableMesin = Table(width)
        tableMesin.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tableMesin.addCell(Cell().add(Paragraph("Tanggal")))
        tableMesin.addCell(Cell().add(Paragraph("E Motor")))
        tableMesin.addCell(Cell().add(Paragraph("Gear Box")))
        tableMesin.addCell(Cell().add(Paragraph("Bearing")))
        tableMesin.addCell(Cell().add(Paragraph("Gear Sproket(Rantai)")))
        tableMesin.addCell(Cell().add(Paragraph("Pisau Duduk dan Rotor")))
        tableMesin.addCell(Cell().add(Paragraph("Hasil Ranjangan")))
        tableMesin.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tableMesin.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))

        tableMesin.addCell(Cell().add(Paragraph(tanggalMesin)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentEMotor)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentGearBox)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentBearing)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentGearSproket)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentPisauDuduk)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(hasilRanjangan)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentBagianKarat)).setFontSize(18F))
        tableMesin.addCell(Cell().add(Paragraph(parentKelainanSuara)).setFontSize(18F))

        val barcode = BarcodeQRCode(namaMesin + "\n" + "E Motor: $parentEMotor " + "\n" + "Gear Box: $parentGearBox" + "\n" + "Bearing: $parentBearing"
        + "\n" + "Gear Sproket(Rantai) $parentGearSproket " + "\n" + "Pisau Duduk Dan Rotor: $parentPisauDuduk " + "\n" + "Hasil Ranjangan $hasilRanjangan"
        + "\n" + "Bagian Yang Karat: $parentBagianKarat " + "\n" + "Kelainan Suara Mesin: $parentKelainanSuara " + "\n" + "Tanggal: $tanggalMesin")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image: Image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tableMesin)
        document.add(image)
        document.close()
        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")
    }

    private fun setCalendarInputanUser(){
        setCalendar(binding.editTanggalMesin)
        setCalendar(binding.editTanggalFuserBreaker)
        setCalendar(binding.editTanggalScrewConveyor)
        setCalendar(binding.editTanggalConveyor)
        setCalendar(binding.editTanggalHammermil)
        setCalendar(binding.editTanggalFeederCakar)
        setCalendar(binding.editTanggalvortexPumpHammermill)
    }

    private fun validasiData2(){
        binding.apply {
            val tanggal = binding.parentTanggalFuserBreaker.editText?.text.toString()
            val parentEMotor = binding.parentEMotor1.editText?.text.toString()
            val parentGearBox = binding.parentGearBox1.editText?.text.toString()
            val parentBearing = binding.parentBearing1.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket1.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk1.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan1.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat1.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin1.editText?.text.toString()


            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
                {
                 Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                ,"FUSER BREAKER")
                Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
            }


        }
    }

    private fun validasiData4(){
        val tanggal = binding.parentTanggalConveyor.editText?.text.toString()
        val parentEMotor = binding.parentEMotor4.editText?.text.toString()
        val parentGearBox = binding.parentGearBox4.editText?.text.toString()
        val parentBearing = binding.parentBearing4.editText?.text.toString()
        val parentGearSproket = binding.parentGearSproket4.editText?.text.toString()
        val parentPisauDuduk = binding.parentPisauDuduk4.editText?.text.toString()
        val hasilRanjangan = binding.parentHasilRanjangan4.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat4.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin4.editText?.text.toString()

        if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty()
            || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
            || parentKelainanSuara.isEmpty())
        {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
        }else{
            createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                ,"BELT CONVEYOR 1")
            Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
        }

    }

    private fun validasiData3(){
        val tanggal = binding.parentTanggalScrewConveyor.editText?.text.toString()
        val parentEMotor = binding.parentEMotor2.editText?.text.toString()
        val parentGearBox = binding.parentGearBox2.editText?.text.toString()
        val parentBearing = binding.parentBearing2.editText?.text.toString()
        val parentGearSproket = binding.parentGearSproket2.editText?.text.toString()
        val parentPisauDuduk = binding.parentPisauDuduk2.editText?.text.toString()
        val hasilRanjangan = binding.parentHasilRanjangan2.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat2.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin2.editText?.text.toString()


        if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty()
            || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
            || parentKelainanSuara.isEmpty())
            {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
        }else{
            createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
            ,"SCREW CONVEYOR")
            Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
        }

    }

    private fun validasiData5(){
        val tanggal = binding.parentTanggalHammermil.editText?.text.toString()
        val parentEMotor = binding.parentEMotor5.editText?.text.toString()
        val parentGearBox = binding.parentGearBox5.editText?.text.toString()
        val parentBearing = binding.parentBearing5.editText?.text.toString()
        val parentGearSproket = binding.parentGearSproket5.editText?.text.toString()
        val parentPisauDuduk = binding.parentPisauDuduk5.editText?.text.toString()
        val hasilRanjangan = binding.parentHasilRanjangan5.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat5.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin5.editText?.text.toString()

        if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty()
            || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
            || parentKelainanSuara.isEmpty())
        {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
        }else{
            createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                ,"HAMMERMIL")
            Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
        }
    }

    private fun validasiData6(){
        val tanggal = binding.parentTanggalFeederCakar.editText?.text.toString()
        val parentEMotor = binding.parentEMotor6.editText?.text.toString()
        val parentGearBox = binding.parentGearBox6.editText?.text.toString()
        val parentBearing = binding.parentBearing6.editText?.text.toString()
        val parentGearSproket = binding.parentGearSproket6.editText?.text.toString()
        val parentPisauDuduk = binding.parentPisauDuduk6.editText?.text.toString()
        val hasilRanjangan = binding.parentHasilRanjangan6.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat6.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin6.editText?.text.toString()

        if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty()
            || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
            || parentKelainanSuara.isEmpty())
        {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
        }else{
            createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                ,"FEEDER CAKAR")
            Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
        }


    }

    private fun validasiData7(){
        val tanggal = binding.parentTanggalvortexPumpHammermill.editText?.text.toString()
        val parentEMotor = binding.parentEMotor7.editText?.text.toString()
        val parentGearBox = binding.parentGearBox7.editText?.text.toString()
        val parentBearing = binding.parentBearing7.editText?.text.toString()
        val parentGearSproket = binding.parentGearSproket7.editText?.text.toString()
        val parentPisauDuduk = binding.parentPisauDuduk7.editText?.text.toString()
        val hasilRanjangan = binding.parentHasilRanjangan7.editText?.text.toString()
        val parentBagianKarat = binding.parentBagianKarat7.editText?.text.toString()
        val parentKelainanSuara = binding.parentKelainanSuaraMesin7.editText?.text.toString()

        if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty()
            || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
            || parentKelainanSuara.isEmpty())
        {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",Toast.LENGTH_SHORT).show()
        }else{
            createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                ,"VORTEX_PUMP HAMMERMILL")
            Toast.makeText(requireContext(),"PDF has been created",Toast.LENGTH_SHORT).show()
        }


    }

    private fun setCalendar(tanggalMesin: TextInputEditText){
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.UK)
            tanggalMesin.setText(sdf.format(calendar.time))
        }
        tanggalMesin.setOnClickListener {
            DatePickerDialog(requireContext(),datePicker,calendar.get(Calendar.YEAR),calendar.get(
                Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

}