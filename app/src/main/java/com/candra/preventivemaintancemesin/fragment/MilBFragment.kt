package com.candra.preventivemaintancemesin.fragment

import android.app.DatePickerDialog
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
import com.candra.preventivemaintancemesin.databinding.MailingBBinding
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
class MilBFragment: Fragment()
{

    private lateinit var binding: MailingBBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MailingBBinding.inflate(inflater,container,false)


        setCalendarUser()

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

            cetakPdf8.setOnClickListener {
                validasiData8()
            }

            cetakPdf9.setOnClickListener {
                validasiData9()
            }

        }

        setTemptAllDataInputanUser()

        return binding.root
    }


    private fun setTemptAllDataInputanUser(){
        allDataInputanUserScrewCutter()

        allDataInputanUserRotaryBucket()

        allDataInputanUserscrewConveyor2()

        allDataInputanUserBeltConveyor2()

        allDataInputanUserScrewBreaker()

        allDataInputanUserRotaryBucketScrewBreaker()

        allDataInputanUserPisauDuduk1()

        allDataInputanUserscrewConveyor3()

        allDataInputanUserTurningMixingTank123()


    }

    private fun allDataInputanUserscrewConveyor3() {
        setAdapterData(binding.editEMotor8,R.array.opsi)
        setAdapterData(binding.editGearBox8,R.array.opsi)
        setAdapterData(binding.editBearing8,R.array.opsi)
        setAdapterData(binding.editGearSproket8,R.array.opsi)
        setAdapterData(binding.editPisauDuduk8,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan8,R.array.opsi)
        setAdapterData(binding.editBagianKarat8,R.array.opsi)
        setAdapterData(binding.editSuaraMesin8,R.array.opsi)
    }

    private fun allDataInputanUserScrewCutter(){
        setAdapterData(binding.editEMotor,R.array.opsi)
        setAdapterData(binding.editGearBox,R.array.opsi)
        setAdapterData(binding.editBearing,R.array.opsi)
        setAdapterData(binding.editGearSproket,R.array.opsi)
        setAdapterData(binding.editPisauDuduk,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan,R.array.opsi)
        setAdapterData(binding.editBagianKarat,R.array.opsi)
        setAdapterData(binding.editSuaraMesin,R.array.opsi)
    }

    private fun allDataInputanUserRotaryBucket(){
        setAdapterData(binding.editEMotor1,R.array.opsi)
        setAdapterData(binding.editGearBox1,R.array.opsi)
        setAdapterData(binding.editBearing1,R.array.opsi)
        setAdapterData(binding.editGearSproket1,R.array.opsi)
        setAdapterData(binding.editPisauDuduk1,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan1,R.array.opsi)
        setAdapterData(binding.editBagianKarat1,R.array.opsi)
        setAdapterData(binding.editSuaraMesin1,R.array.opsi)
    }

    private fun allDataInputanUserscrewConveyor2(){
        setAdapterData(binding.editEMotor2,R.array.opsi)
        setAdapterData(binding.editGearBox2,R.array.opsi)
        setAdapterData(binding.editBearing2,R.array.opsi)
        setAdapterData(binding.editGearSproket2,R.array.opsi)
        setAdapterData(binding.editPisauDuduk2,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan2,R.array.opsi)
        setAdapterData(binding.editBagianKarat2,R.array.opsi)
        setAdapterData(binding.editSuaraMesin2,R.array.opsi)
    }

    private fun allDataInputanUserBeltConveyor2(){
        setAdapterData(binding.editEMotor4,R.array.opsi)
        setAdapterData(binding.editGearBox4,R.array.opsi)
        setAdapterData(binding.editBearing4,R.array.opsi)
        setAdapterData(binding.editGearSproket4,R.array.opsi)
        setAdapterData(binding.editPisauDuduk4,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan4,R.array.opsi)
        setAdapterData(binding.editBagianKarat4,R.array.opsi)
        setAdapterData(binding.editSuaraMesin4,R.array.opsi)
    }

    private fun allDataInputanUserScrewBreaker(){
        setAdapterData(binding.editEMotor5,R.array.opsi)
        setAdapterData(binding.editGearBox5,R.array.opsi)
        setAdapterData(binding.editBearing5,R.array.opsi)
        setAdapterData(binding.editGearSproket5,R.array.opsi)
        setAdapterData(binding.editPisauDuduk5,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan5,R.array.opsi)
        setAdapterData(binding.editBagianKarat5,R.array.opsi)
        setAdapterData(binding.editSuaraMesin5,R.array.opsi)
    }

    private fun allDataInputanUserRotaryBucketScrewBreaker(){
        setAdapterData(binding.editEMotor6,R.array.opsi)
        setAdapterData(binding.editGearBox6,R.array.opsi)
        setAdapterData(binding.editBearing6,R.array.opsi)
        setAdapterData(binding.editGearSproket6,R.array.opsi)
        setAdapterData(binding.editPisauDuduk6,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan6,R.array.opsi)
        setAdapterData(binding.editBagianKarat6,R.array.opsi)
        setAdapterData(binding.editSuaraMesin6,R.array.opsi)
    }

    private fun allDataInputanUserPisauDuduk1(){
        setAdapterData(binding.editEMotor7,R.array.opsi)
        setAdapterData(binding.editGearBox7,R.array.opsi)
        setAdapterData(binding.editBearing7,R.array.opsi)
        setAdapterData(binding.editGearSproket7,R.array.opsi)
        setAdapterData(binding.editPisauDuduk7,R.array.opsi)
        setAdapterData(binding.editHasilRanjangan7,R.array.opsi)
        setAdapterData(binding.editBagianKarat7,R.array.opsi)
        setAdapterData(binding.editSuaraMesin7,R.array.opsi)
    }

    private fun allDataInputanUserTurningMixingTank123(){
        setAdapterData(binding.editGearBoxMotor,R.array.opsi)
        setAdapterData(binding.editVBelt,R.array.opsi)
        setAdapterData(binding.editPipaTurning,R.array.opsi)
        setAdapterData(binding.editBagianKarat9,R.array.opsi)
        setAdapterData(binding.editSuaraMesin9,R.array.opsi)
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

    private fun setAdapterData(text: AutoCompleteTextView, id: Int){
        val data = resources.getStringArray(id)
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,data)
        text.setAdapter(arrayAdapter)
    }

    private fun setCalendarUser(){
        setCalendar(binding.editTanggalScrewCutter)
        setCalendar(binding.editTanggalRotaryBucket)
        setCalendar(binding.editTanggalScrewConveyor2)
        setCalendar(binding.editTanggalConveyor2)
        setCalendar(binding.editTanggalScrewBreaker)
        setCalendar(binding.editTanggalRotaryScrewBreaker)
        setCalendar(binding.editTanggalPisauDuduk1)
        setCalendar(binding.editTanggalScrewConveyor3)
        setCalendar(binding.editTanggalTurning)
    }

    private fun validasiData1(){
        binding.apply {
            val tanggal = binding.parentTanggalScrewCutter.editText?.text.toString()
            val parentEMotor = binding.parentEMotor.editText?.text.toString()
            val parentGearBox = binding.parentGearBox.editText?.text.toString()
            val parentBearing = binding.parentBearing.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"SCREW CUTTER B")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData2(){
        binding.apply {
            val tanggal = binding.parentTanggalRotaryBucket.editText?.text.toString()
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
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"ROTARY BUCKET")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData3(){
        binding.apply {
            val tanggal = binding.parentTanggalScrewConveyor2.editText?.text.toString()
            val parentEMotor = binding.parentEMotor2.editText?.text.toString()
            val parentGearBox = binding.parentGearBox2.editText?.text.toString()
            val parentBearing = binding.parentBearing2.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket2.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk2.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan2.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat2.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin2.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"SCREW CONVEYOR 2")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData4(){
        binding.apply {
            val tanggal = binding.parentTanggalConveyor2.editText?.text.toString()
            val parentEMotor = binding.parentEMotor4.editText?.text.toString()
            val parentGearBox = binding.parentGearBox4.editText?.text.toString()
            val parentBearing = binding.parentBearing4.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket4.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk4.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan4.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat4.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin4.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"BELT CONVEYOR 2")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData5(){
        binding.apply {
            val tanggal = binding.parentTanggalScrewBreaker.editText?.text.toString()
            val parentEMotor = binding.parentEMotor5.editText?.text.toString()
            val parentGearBox = binding.parentGearBox5.editText?.text.toString()
            val parentBearing = binding.parentBearing5.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket5.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk5.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan5.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat5.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin5.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"SCREW BREAKER B")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData6(){
        binding.apply {
            val tanggal = binding.parentTanggalRotaryBucketScrewBreaker.editText?.text.toString()
            val parentEMotor = binding.parentEMotor6.editText?.text.toString()
            val parentGearBox = binding.parentGearBox6.editText?.text.toString()
            val parentBearing = binding.parentBearing6.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket6.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk6.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan6.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat6.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin6.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"ROTARY BUCKET SCREW BREAKER")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData7(){
        binding.apply {
            val tanggal = binding.parentTanggalPisauDudu1.editText?.text.toString()
            val parentEMotor = binding.parentEMotor7.editText?.text.toString()
            val parentGearBox = binding.parentGearBox7.editText?.text.toString()
            val parentBearing = binding.parentBearing7.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket7.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk7.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan7.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat7.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin7.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"PISAU DUDUK 1")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData8(){
        binding.apply {
            val tanggal = binding.parentTanggalScrewConveyor3.editText?.text.toString()
            val parentEMotor = binding.parentEMotor8.editText?.text.toString()
            val parentGearBox = binding.parentGearBox8.editText?.text.toString()
            val parentBearing = binding.parentBearing8.editText?.text.toString()
            val parentGearSproket = binding.parentGearSproket8.editText?.text.toString()
            val parentPisauDuduk = binding.parentPisauDuduk8.editText?.text.toString()
            val hasilRanjangan = binding.parentHasilRanjangan8.editText?.text.toString()
            val parentBagianKarat = binding.parentBagianKarat8.editText?.text.toString()
            val parentKelainanSuara = binding.parentKelainanSuaraMesin8.editText?.text.toString()

            if (tanggal.isEmpty() || parentEMotor.isEmpty() || parentBearing.isEmpty() || parentGearBox.isEmpty()
                || parentGearSproket.isEmpty() || parentPisauDuduk.isEmpty() || hasilRanjangan.isEmpty() || parentBagianKarat.isEmpty()
                || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,parentEMotor,parentGearBox,parentBearing,parentGearSproket,parentPisauDuduk,hasilRanjangan,parentBagianKarat,parentKelainanSuara
                    ,"SCREW CONVEYOR-3")
                Toast.makeText(requireContext(),"PDF has been created", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasiData9(){
        val tanggal = binding.parentTanggalTurning.editText?.text.toString()
        val parentGearBoxMotor = binding.parentGearBoxMotor.editText?.text.toString()
        val parentVBelt = binding.parentVBelt.editText?.text.toString()
        val parentPipaTurning = binding.parentPipaTurning.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat9.editText?.text.toString()
        val kelainanSuara = binding.parentKelainanSuaraMesin9.editText?.text.toString()

        if (tanggal.isEmpty() || parentGearBoxMotor.isEmpty() || parentVBelt.isEmpty() || parentPipaTurning.isEmpty() ||
                bagianKarat.isEmpty() || kelainanSuara.isEmpty())
        {
            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                Toast.LENGTH_SHORT).show()
        }else
        {
            createPdf9(tanggal,parentGearBoxMotor,parentVBelt,parentPipaTurning,bagianKarat,kelainanSuara)
        }

    }

    private fun createPdf9(tanggalMesin: String,parentGearBoxMotor: String,parenVBelt: String,parentPipaTurning: String
    ,bagianKarat: String,kelainanSuara: String)
    {
        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val dataTanggal: String = simpelDateFormat

        val file = File(path,"$dataTanggal TURNING MIXING TANK 1,2,3.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A4
        document.setMargins(0F,0F,0F,0F)

        val paragraphTitle = Paragraph("TURNING MIXING TANK 1,2,3").setBold().setFontSize(24F).setTextAlignment(
            TextAlignment.LEFT)

        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal :$simpelDateFormat dan waktu: $waktu").setFontSize(18F).setTextAlignment(
            TextAlignment.LEFT)

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F)
        val tableData = Table(width)
        tableData.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tableData.addCell(Cell().add(Paragraph("Tanggal")))
        tableData.addCell(Cell().add(Paragraph("GearBox Motor")))
        tableData.addCell(Cell().add(Paragraph("V Belt")))
        tableData.addCell(Cell().add(Paragraph("Pipa Turning")))
        tableData.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tableData.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))

        tableData.addCell(Cell().add(Paragraph(tanggalMesin)))
        tableData.addCell(Cell().add(Paragraph(parentGearBoxMotor)))
        tableData.addCell(Cell().add(Paragraph(parenVBelt)))
        tableData.addCell(Cell().add(Paragraph(parentPipaTurning)))
        tableData.addCell(Cell().add(Paragraph(bagianKarat)))
        tableData.addCell(Cell().add(Paragraph(kelainanSuara)))

        val barcode = BarcodeQRCode("TURNING MIXING TANK 1,2,3 \n GearBox Motor: $parentGearBoxMotor \n V Belt: $parenVBelt" +
                "\n Pipa Turning: $parentPipaTurning \n Bagian Yang Karat: $bagianKarat \n Kelainan Suara Mesin: $kelainanSuara \n tanggal: $tanggalMesin")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image: Image = Image(qrCodeObject)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tableData)
        document.add(image)
        document.close()

        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")
    }


    private fun createPdf(tanggalMesin: String,parentEMotor:String,parentGearBox: String
                          ,parentBearing: String,parentGearSproket: String,parentPisauDuduk: String,hasilRanjangan: String,
                          parentBagianKarat: String,parentKelainanSuara: String,namaMesin: String)
    {

        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val tanggalDate: String = simpelDateFormat

        val file = File(path,"$tanggalDate $namaMesin.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A4
        document.setMargins(0F,0F,0F,0F)

        val paragraphTitle = Paragraph(namaMesin).setBold().setFontSize(24F).setTextAlignment(
            TextAlignment.LEFT)

        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal :$simpelDateFormat dan waktu: $waktu").setFontSize(18F).setTextAlignment(
            TextAlignment.LEFT)


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
        val image: Image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(
            HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tableMesin)
        document.add(image)
        document.close()

        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")

    }

}