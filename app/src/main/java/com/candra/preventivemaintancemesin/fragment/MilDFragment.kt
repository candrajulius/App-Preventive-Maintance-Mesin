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
import com.candra.preventivemaintancemesin.databinding.MailingDBinding
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
class MilDFragment : Fragment()
{

    private lateinit var binding: MailingDBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MailingDBinding.inflate(inflater,container,false)


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

        setAllDataCalendar()

        setAllDataInputanUser()

        return binding.root
    }

    private fun setAllDataCalendar(){
        setCalendar(binding.editLift1)
        setCalendar(binding.editLift2)
        setCalendar(binding.editLift3)
    }


    private fun validasi3(){
        binding.apply {
            val tanggal = parentTanggaLift3.editText?.text.toString()
            val gearEMotor = parentGearMotor3.editText?.text.toString()
            val bearing = parentBearing3.editText?.text.toString()
            val penampungan = parentPenampungan3.editText?.text.toString()
            val kabelSling = parentKabelSling3.editText?.text.toString()
            val rodaLift = parentRodaLift3.editText?.text.toString()
            val relLangsiran = parentRelLangsiran3.editText?.text.toString()
            val bagianYangKarat = parentBagianKarat3.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin3.editText?.text.toString()


            if (tanggal.isEmpty() || gearEMotor.isEmpty() || penampungan.isEmpty() || kabelSling.isEmpty()
                || rodaLift.isEmpty() || relLangsiran.isEmpty() || bagianYangKarat.isEmpty() || kelainanSuara.isEmpty()
                || bearing.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,gearEMotor,bearing,penampungan,kabelSling,rodaLift,relLangsiran,bagianYangKarat,kelainanSuara,"LIFT 3")
            }

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

    private fun setAdapterData(text: AutoCompleteTextView, id: Int){
        val data = resources.getStringArray(id)
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,data)
        text.setAdapter(arrayAdapter)
    }

    private fun setAllDataInputanUser(){
        setInputanUserLift1()
        setInputanUserLift2()
        setInputanUserLift3()
    }

    private fun setInputanUserLift1(){
        setAdapterData(binding.editGearMotor,R.array.opsi)
        setAdapterData(binding.editBearing,R.array.opsi)
        setAdapterData(binding.editPenampungan,R.array.opsi)
        setAdapterData(binding.editKabelSling,R.array.opsi)
        setAdapterData(binding.editRodaLift,R.array.opsi)
        setAdapterData(binding.editRelLangsiran,R.array.opsi)
        setAdapterData(binding.editBagianKarat,R.array.opsi)
        setAdapterData(binding.editSuaraMesin,R.array.opsi)
    }

    private fun setInputanUserLift2(){
        setAdapterData(binding.editGearMotor2,R.array.opsi)
        setAdapterData(binding.editBearing2,R.array.opsi)
        setAdapterData(binding.editPenampungan2,R.array.opsi)
        setAdapterData(binding.editKabelSling2,R.array.opsi)
        setAdapterData(binding.editRodaLift2,R.array.opsi)
        setAdapterData(binding.editRelLangsiran2,R.array.opsi)
        setAdapterData(binding.editBagianKarat2,R.array.opsi)
        setAdapterData(binding.editSuaraMesin2,R.array.opsi)
    }

    private fun setInputanUserLift3(){
        setAdapterData(binding.editGearMotor3,R.array.opsi)
        setAdapterData(binding.editBearing3,R.array.opsi)
        setAdapterData(binding.editPenampungan3,R.array.opsi)
        setAdapterData(binding.editKabelSling3,R.array.opsi)
        setAdapterData(binding.editRodaLift3,R.array.opsi)
        setAdapterData(binding.editRelLangsiran3,R.array.opsi)
        setAdapterData(binding.editBagianKarat3,R.array.opsi)
        setAdapterData(binding.editSuaraMesin3,R.array.opsi)
    }

    private fun validasi1(){
        binding.apply {
            val tanggal = parentTanggaLift1.editText?.text.toString()
            val gearEMotor = parentGearMotor.editText?.text.toString()
            val bearing = parentBearing.editText?.text.toString()
            val penampungan = parentPenampungan.editText?.text.toString()
            val kabelSling = parentKabelSling.editText?.text.toString()
            val rodaLift = parentRodaLift.editText?.text.toString()
            val relLangsiran = parentRelLangsiran.editText?.text.toString()
            val bagianYangKarat = parentBagianKarat.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin.editText?.text.toString()


            if (tanggal.isEmpty() || gearEMotor.isEmpty() || penampungan.isEmpty() || kabelSling.isEmpty()
                || rodaLift.isEmpty() || relLangsiran.isEmpty() || bagianYangKarat.isEmpty() || kelainanSuara.isEmpty()
                || bearing.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,gearEMotor,bearing,penampungan,kabelSling,rodaLift,relLangsiran,bagianYangKarat,kelainanSuara,"LIFT 1")
            }

        }
    }

    private fun validasi2(){
        binding.apply {
            val tanggal = parentTanggaLift2.editText?.text.toString()
            val gearEMotor = parentGearMotor2.editText?.text.toString()
            val bearing = parentBearing2.editText?.text.toString()
            val penampungan = parentPenampungan2.editText?.text.toString()
            val kabelSling = parentKabelSling2.editText?.text.toString()
            val rodaLift = parentRodaLift2.editText?.text.toString()
            val relLangsiran = parentRelLangsiran2.editText?.text.toString()
            val bagianYangKarat = parentBagianKarat2.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin2.editText?.text.toString()


            if (tanggal.isEmpty() || gearEMotor.isEmpty() || penampungan.isEmpty() || kabelSling.isEmpty()
                || rodaLift.isEmpty() || relLangsiran.isEmpty() || bagianYangKarat.isEmpty() || kelainanSuara.isEmpty()
                || bearing.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdf(tanggal,gearEMotor,bearing,penampungan,kabelSling,rodaLift,relLangsiran,bagianYangKarat,kelainanSuara,"LIFT 2")
            }

        }
    }

    private fun createPdf(tanggal: String,gearMotor: String, bearing: String, penampungan: String, kabelSling: String,
    rodaLift: String,relLangsiran: String,bagianKarat: String,kelainanSuara: String,namaMesin: String)
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

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F,100F)
        val tableData = Table(width)

        tableData.addCell(Cell().add(Paragraph("Tanggal")))
        tableData.addCell(Cell().add(Paragraph("Gear E. Motor")))
        tableData.addCell(Cell().add(Paragraph("Bearing")))
        tableData.addCell(Cell().add(Paragraph("Pengangkat & Plat Penampungan Blanket")))
        tableData.addCell(Cell().add(Paragraph("Kabel Sling")))
        tableData.addCell(Cell().add(Paragraph("Roda Lift")))
        tableData.addCell(Cell().add(Paragraph("Rel Langsiran")))
        tableData.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tableData.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))

        tableData.addCell(Cell().add(Paragraph(tanggal)))
        tableData.addCell(Cell().add(Paragraph(gearMotor)))
        tableData.addCell(Cell().add(Paragraph(bearing)))
        tableData.addCell(Cell().add(Paragraph(penampungan)))
        tableData.addCell(Cell().add(Paragraph(kabelSling)))
        tableData.addCell(Cell().add(Paragraph(rodaLift)))
        tableData.addCell(Cell().add(Paragraph(relLangsiran)))
        tableData.addCell(Cell().add(Paragraph(bagianKarat)))
        tableData.addCell(Cell().add(Paragraph(kelainanSuara)))


        val barcode = BarcodeQRCode(namaMesin + "\n" + "Gear E. Motor: $gearMotor " + "\n" + "Bearing: $bearing" + "\n" + "Pengangkat & Plat Penampungan Blanket: $penampungan"
                + "\n" + "Kabel Sling: $kabelSling " + "\n" + "Roda Lift: $rodaLift " + "\n" + "Rel Langsiran: $relLangsiran"
                + "\n" + "Bagian Yang Karat: $bagianKarat " + "\n" + "Kelainan Suara Mesin: $kelainanSuara " + "\n" + "Tanggal: $tanggal")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image: Image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(
            HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tableData)
        document.add(image)
        document.close()
        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")

    }

}