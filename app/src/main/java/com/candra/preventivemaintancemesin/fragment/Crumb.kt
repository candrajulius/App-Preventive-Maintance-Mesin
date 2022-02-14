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
import com.candra.preventivemaintancemesin.databinding.CrumbBinding
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
class Crumb: Fragment()
{
    private lateinit var binding: CrumbBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = CrumbBinding.inflate(inflater,container,false)

        allDataInputanUser()
        setAllDataCalendar()

        binding.apply {
            cetakPdf.setOnClickListener {
                validasi1()
            }

            cetakPdf2.setOnClickListener {
                validasi2()
            }

            cetakPdf3.setOnClickListener {
                validasi3()
            }

        }

        return binding.root
    }

    private fun allDataInputanUser(){
        allDataInputanUserHydraulic()
        allDataInputanUserHydraulicPress()
        allDataInputanUserChainConveyor()
    }

    private fun allDataInputanUserHydraulic(){
        setAdapterData(binding.editPowerPack,R.array.opsi)
        setAdapterData(binding.editSealPiston,R.array.opsi)
        setAdapterData(binding.editBearingRoda,R.array.opsi)
        setAdapterData(binding.editPipaHydraulic,R.array.opsi)
        setAdapterData(binding.editSelangHydraulic,R.array.opsi)
        setAdapterData(binding.editBagianKarat,R.array.opsi)
        setAdapterData(binding.editSuaraMesin,R.array.opsi)
    }

    private fun allDataInputanUserHydraulicPress(){
        setAdapterData(binding.editPowerPack1,R.array.opsi)
        setAdapterData(binding.editSealPiston2,R.array.opsi)
        setAdapterData(binding.editTutupPress,R.array.opsi)
        setAdapterData(binding.editBandulanPemberat,R.array.opsi)
        setAdapterData(binding.editPenahanTutupPress,R.array.opsi)
        setAdapterData(binding.editBagianKarat2,R.array.opsi)
        setAdapterData(binding.editSuaraMesin2,R.array.opsi)
    }

    private fun allDataInputanUserChainConveyor(){
        setAdapterData(binding.editGearMotor,R.array.opsi)
        setAdapterData(binding.editBearing1,R.array.opsi)
        setAdapterData(binding.editRelConveyor,R.array.opsi)
        setAdapterData(binding.editGearSpoket,R.array.opsi)
        setAdapterData(binding.editRantaiConveyor,R.array.opsi)
        setAdapterData(binding.editBagianKarat3,R.array.opsi)
        setAdapterData(binding.editSuaraMesin3,R.array.opsi)
    }

    private fun setAdapterData(text: AutoCompleteTextView, id: Int){
        val data = resources.getStringArray(id)
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,data)
        text.setAdapter(arrayAdapter)
    }

    private fun setAllDataCalendar(){
        setCalendar(binding.editTanggalMesin)
        setCalendar(binding.editTanggalMesin2)
        setCalendar(binding.editTanggalMesin3)
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

    private fun validasi1(){
        binding.apply {
            val tanggal = parentTanggalMesin.editText?.text.toString()
            val powerPack = parentPowerPack.editText?.text.toString()
            val bearingRoda = parentBearingdanRoda.editText?.text.toString()
            val pipaHydrolic = parentPipaHydarulic.editText?.text.toString()
            val sealPiston = parentSealPiston.editText?.text.toString()
            val selangHydraulic = parentSelangHydraulic.editText?.text.toString()
            val bagianKarat = parentBagianKarat.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin.editText?.text.toString()

            if (tanggal.isEmpty() || powerPack.isEmpty() || bearingRoda.isEmpty() || pipaHydrolic.isEmpty()
                || sealPiston.isEmpty() || selangHydraulic.isEmpty() || bagianKarat.isEmpty()
                || kelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPDF("Power Pack","Seal Piston","Bearing & Roda","Pipa Hydraulic","Selang Hydraulic",
                "Bagian Yang Karat","Kelainan Suara Mesin",tanggal,powerPack,sealPiston,bearingRoda,pipaHydrolic,selangHydraulic,
                bagianKarat,kelainanSuara,"HYDRAULIC PENDORONG TROLLEY")
                Toast.makeText(requireContext(),"Pdf Has Been Created",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validasi2(){
        binding.apply {
            val tanggal = parentTanggalMesin2.editText?.text.toString()
            val powerPack = parentPowerPack1.editText?.text.toString()
            val sealPiston = parentSealPiston2.editText?.text.toString()
            val tutupPress = parentTutupPress.editText?.text.toString()
            val bandulanPemberat = parentBandulanPemberat.editText?.text.toString()
            val penahanTutupPress = parentPenahanTutupPress.editText?.text.toString()
            val bagianKarat = parentBagianKarat2.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin2.editText?.text.toString()


            if (tanggal.isEmpty() || powerPack.isEmpty() || sealPiston.isEmpty() || tutupPress.isEmpty()
                || bandulanPemberat.isEmpty() || penahanTutupPress.isEmpty() || bagianKarat.isEmpty()
                || kelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPDF("Power Pack","Seal Piston","Tutup Press","Bandulan Pemberat","Penahan Tutup Press",
                "Bagian Yang Karat","Kelainan Suara Mesin",tanggal,powerPack,sealPiston,tutupPress,bandulanPemberat,penahanTutupPress,bagianKarat,kelainanSuara
                ,"HYDRAULIC PRESS 1,2,3")
                Toast.makeText(requireContext(),"Pdf Has Been Created",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validasi3(){
        binding.apply {
            val tanggal = parentTanggalMesin3.editText?.text.toString()
            val gearMotor = parentGearMotor.editText?.text.toString()
            val bearing = parentBearing1.editText?.text.toString()
            val realConveyor = parentRelConveyor.editText?.text.toString()
            val gearSproket = parentGearSpoket.editText?.text.toString()
            val rantaiConveyor = parentRantaiConveyor.editText?.text.toString()
            val bagianKarat = parentBagianKarat3.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin3.editText?.text.toString()

            if (tanggal.isEmpty() || gearMotor.isEmpty() || bearing.isEmpty() ||
                    realConveyor.isEmpty() || gearSproket.isEmpty() || rantaiConveyor.isEmpty() || bagianKarat.isEmpty()
                || kelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else
            {
                createPDF("Gear Motor","Bearing","Rel Conveyor","Gear Sproket(Rantai)",
                "Rantai Conveyor","Bagian Yang Karat","Kelainan Suara Mesin",tanggal,gearMotor,bearing,realConveyor,gearSproket
                ,rantaiConveyor,bagianKarat,kelainanSuara,"CHAIN CONVEYOUR")
                Toast.makeText(requireContext(),"Pdf Has Been Created",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun createPDF(one: String,two: String,three: String,four: String,five: String,six: String,seven: String
    ,tanggal: String,mesinOne: String,mesinTwo: String,mesinThree: String,mesinFour: String,mesinFive: String,mesinSix: String,
    mesinSeven: String,namaMesin: String)
    {
        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val dataTanggal: String = simpelDateFormat

        val file = File(path,"$dataTanggal $namaMesin.pdf")

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

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F)
        val tableAnda = Table(width)
        tableAnda.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tableAnda.addCell(Cell().add(Paragraph("Tanggal")))
        tableAnda.addCell(Cell().add(Paragraph(one)))
        tableAnda.addCell(Cell().add(Paragraph(two)))
        tableAnda.addCell(Cell().add(Paragraph(three)))
        tableAnda.addCell(Cell().add(Paragraph(four)))
        tableAnda.addCell(Cell().add(Paragraph(five)))
        tableAnda.addCell(Cell().add(Paragraph(six)))
        tableAnda.addCell(Cell().add(Paragraph(seven)))

        tableAnda.addCell(Cell().add(Paragraph(tanggal)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinOne)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinTwo)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinThree)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinFour)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinFive)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinSix)).setFontSize(18F))
        tableAnda.addCell(Cell().add(Paragraph(mesinSeven)).setFontSize(18F))

        val barcode = BarcodeQRCode("$namaMesin \n $one: $mesinOne \n $two: $mesinTwo \n $three: $mesinThree" +
                "\n $four: $mesinFour \n $five: $mesinFive \n $six: $mesinSix \n $seven: $mesinSeven")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tableAnda)
        document.add(image)
        document.close()

        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")

    }


}