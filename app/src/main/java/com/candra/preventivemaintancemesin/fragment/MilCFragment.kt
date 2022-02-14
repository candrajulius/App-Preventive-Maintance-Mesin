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
import com.candra.preventivemaintancemesin.databinding.MailingCBinding
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
class MilCFragment: Fragment()
{

    private lateinit var binding: MailingCBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MailingCBinding.inflate(inflater,container,false)


        setCalendarUserInput()

        setAllDataInputanUser()

        binding.apply {
            cetakPdf.setOnClickListener {
                validasi1()
            }

            cetakPdf1.setOnClickListener {
                validasi2()
            }

            cetakPdf2.setOnClickListener {
                validasi3()
            }

            cetakPdf3.setOnClickListener {
                validasi4()
            }

            cetakPdf4.setOnClickListener {
                validasi5()
            }
        }

        return binding.root
    }


    private fun setCalendarUserInput(){
        setCalendar(binding.editTanggalShreeder)
        setCalendar(binding.editTanggalFeedingRoll)
        setCalendar(binding.editTanggalPompaSungai)
        setCalendar(binding.editTanggalShredderMill)
        setCalendar(binding.editTanggalShredderCrumb)
    }

    private fun setAllDataInputanUser(){
        allDataInputanUserShreeder()
        allDataInputanUserFeedingRoll()
        allDataInputanUserPompaSungai()
        allDataInputanUserShredderMill()
        allDataInputanUserShredderCrumb()
    }

    private fun allDataInputanUserShredderCrumb(){
        setAdapterData(binding.editEMotor4,R.array.opsi)
        setAdapterData(binding.editKaretKopling2,R.array.opsi)
        setAdapterData(binding.editBearing4,R.array.opsi)
        setAdapterData(binding.editPackingAsbes2,R.array.opsi)
        setAdapterData(binding.editImpellerVPompa1,R.array.opsi)
        setAdapterData(binding.editVBelt1,R.array.opsi)
        setAdapterData(binding.editBagianKarat4,R.array.opsi)
        setAdapterData(binding.editSuaraMesin4,R.array.opsi)
    }

    private fun allDataInputanUserShreeder(){
        setAdapterData(binding.editEMotor,R.array.opsi)
        setAdapterData(binding.editGearBox,R.array.opsi)
        setAdapterData(binding.editBearing,R.array.opsi)
        setAdapterData(binding.editGearSproket,R.array.opsi)
        setAdapterData(binding.editPisauDuduk,R.array.opsi)
        setAdapterData(binding.editHasilRemahan,R.array.opsi)
        setAdapterData(binding.editBagianKarat,R.array.opsi)
        setAdapterData(binding.editSuaraMesin,R.array.opsi)
    }

    private fun allDataInputanUserFeedingRoll(){
        setAdapterData(binding.editEMotor1,R.array.opsi)
        setAdapterData(binding.editGearBox1,R.array.opsi)
        setAdapterData(binding.editBearing1,R.array.opsi)
        setAdapterData(binding.editGearSproket1,R.array.opsi)
        setAdapterData(binding.editPisauDuduk1,R.array.opsi)
        setAdapterData(binding.editHasilRemahan1,R.array.opsi)
        setAdapterData(binding.editBagianKarat1,R.array.opsi)
        setAdapterData(binding.editSuaraMesin1,R.array.opsi)
    }

    private fun allDataInputanUserPompaSungai(){
        setAdapterData(binding.editEMotor2,R.array.opsi)
        setAdapterData(binding.editKaretKopling,R.array.opsi)
        setAdapterData(binding.editBearing2,R.array.opsi)
        setAdapterData(binding.editPackingAsbes,R.array.opsi)
        setAdapterData(binding.editImpellerPompa,R.array.opsi)
        setAdapterData(binding.editBagianKarat2,R.array.opsi)
        setAdapterData(binding.editSuaraMesin2,R.array.opsi)
    }

    private fun allDataInputanUserShredderMill(){
        setAdapterData(binding.editEMotor3,R.array.opsi)
        setAdapterData(binding.editKaretKopling1,R.array.opsi)
        setAdapterData(binding.editBearing3,R.array.opsi)
        setAdapterData(binding.editPackingAsbes1,R.array.opsi)
        setAdapterData(binding.editImpellerVPompa,R.array.opsi)
        setAdapterData(binding.editVBelt,R.array.opsi)
        setAdapterData(binding.editBagianKarat3,R.array.opsi)
        setAdapterData(binding.editSuaraMesin3,R.array.opsi)
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

    private fun validasi1(){
        binding.apply {
            val tanggal = parentTanggalShreeder.editText?.text.toString()
            val motor1 = parentEMotor.editText?.text.toString()
            val gearBox = parentGearBox.editText?.text.toString()
            val bearing = parentBearing.editText?.text.toString()
            val gearSproket = parentGearSproket.editText?.text.toString()
            val pisauDuduk = parentPisauDuduk.editText?.text.toString()
            val hasilRemahan = parentHasilRemahan.editText?.text.toString()
            val bagianKarat = parentBagianKarat.editText?.text.toString()
            val suaraMesin = parentKelainanSuaraMesin.editText?.text.toString()


            if (tanggal.isEmpty() || motor1.isEmpty() || gearBox.isEmpty() || bearing.isEmpty() ||
                    gearSproket.isEmpty() || pisauDuduk.isEmpty() || hasilRemahan.isEmpty() ||
                    bagianKarat.isEmpty() || suaraMesin.isEmpty()){
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdfValidasi1And2(tanggal,motor1,gearBox,bearing,gearSproket,pisauDuduk,hasilRemahan,bagianKarat,suaraMesin,"SHREEDER 1-3")
            }

        }
    }

    private fun validasi2(){
        binding.apply {
            val tanggal = parentTanggalFeedingRoll.editText?.text.toString()
            val motor1 = parentEMotor1.editText?.text.toString()
            val gearBox = parentGearBox1.editText?.text.toString()
            val bearing = parentBearing1.editText?.text.toString()
            val gearSproket = parentGearSproket1.editText?.text.toString()
            val pisauDuduk = parentPisauDuduk1.editText?.text.toString()
            val hasilRemahan = parentHasilRemahan1.editText?.text.toString()
            val bagianKarat = parentBagianKarat1.editText?.text.toString()
            val suaraMesin = parentKelainanSuaraMesin1.editText?.text.toString()


            if (tanggal.isEmpty() || motor1.isEmpty() || gearBox.isEmpty() || bearing.isEmpty() ||
                gearSproket.isEmpty() || pisauDuduk.isEmpty() || hasilRemahan.isEmpty() ||
                bagianKarat.isEmpty() || suaraMesin.isEmpty()){
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdfValidasi1And2(tanggal,motor1,gearBox,bearing,gearSproket,pisauDuduk,hasilRemahan,bagianKarat,suaraMesin,"FEEDING ROLL")
            }

        }
    }

    private fun validasi3(){
        val tanggal = binding.parentTanggalPompaSungai.editText?.text.toString()
        val eMotor = binding.parentEMotor2.editText?.text.toString()
        val kopling = binding.parentKaretKopling.editText?.text.toString()
        val bearing = binding.parentBearing2.editText?.text.toString()
        val packingAsbes = binding.parentPackingAsbes.editText?.text.toString()
        val daunImpllerPompa = binding.parentImpellerPompa.editText?.text.toString()
        val bagianKarat = binding.parentBagianKarat2.editText?.text.toString()
        val kelainanSuaraMesin = binding.parentKelainanSuaraMesin2.editText?.text.toString()


        if (tanggal.isEmpty() || eMotor.isEmpty() || kopling.isEmpty() || bearing.isEmpty() || packingAsbes.isEmpty()
            || daunImpllerPompa.isEmpty() || bagianKarat.isEmpty() || kelainanSuaraMesin.isEmpty()){

            Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                Toast.LENGTH_SHORT).show()
        }else{
            createPdfValidasi3(tanggal,eMotor,kopling,bearing,packingAsbes,daunImpllerPompa,bagianKarat,kelainanSuaraMesin)
        }


    }

    private fun createPdfValidasi1And2(tanggalMesin: String,parentEMotor:String,parentGearBox: String
                          ,parentBearing: String,parentGearSproket: String,parentPisauDuduk: String,hasilRanjangan: String,
                          parentBagianKarat: String,parentKelainanSuara: String,namaMesin: String)
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
        val tableMesin = Table(width)
        tableMesin.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tableMesin.addCell(Cell().add(Paragraph("Tanggal")))
        tableMesin.addCell(Cell().add(Paragraph("E Motor")))
        tableMesin.addCell(Cell().add(Paragraph("Gear Box")))
        tableMesin.addCell(Cell().add(Paragraph("Bearing")))
        tableMesin.addCell(Cell().add(Paragraph("Gear Sproket(Rantai)")))
        tableMesin.addCell(Cell().add(Paragraph("Pisau Duduk dan Rotor")))
        tableMesin.addCell(Cell().add(Paragraph("Hasil Remahan")))
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


    private fun createPdfValidasi3(tanggalMesin: String,parentEMotor:String,parentKopling: String,parentBearing: String,
    packingAsbes: String,parentDaunImpellerPompa: String,bagianKarat: String,KelainanSuara: String){
        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val dataTanggal: String = simpelDateFormat

        val file = File(path,"$dataTanggal POMPA SUNGAI 1-3.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)

        pdfDocument.defaultPageSize = PageSize.A4
        document.setMargins(0F,0F,0F,0F)

        val paragraphTitle = Paragraph("POMPA SUNGAI 1-3").setBold().setFontSize(24F).setTextAlignment(
            TextAlignment.LEFT)

        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal :$simpelDateFormat dan waktu: $waktu").setFontSize(18F).setTextAlignment(
            TextAlignment.LEFT)

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F)

        val tablePompaSungai = Table(width)
        tablePompaSungai.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tablePompaSungai.addCell(Cell().add(Paragraph("Tanggal")))
        tablePompaSungai.addCell(Cell().add(Paragraph("E Motor")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Karet Kopling")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Bearing")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Packing Asbes")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Daun Impeller Pompa")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tablePompaSungai.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))

        tablePompaSungai.addCell(Cell().add(Paragraph(tanggalMesin)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(parentEMotor)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(parentKopling)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(parentBearing)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(packingAsbes)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(parentDaunImpellerPompa)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(bagianKarat)).setFontSize(18F))
        tablePompaSungai.addCell(Cell().add(Paragraph(KelainanSuara)).setFontSize(18F))


        val barcode = BarcodeQRCode("POMPA SUNGAI 1-3" + "\n" + "E. Motor: $parentEMotor " + "\n" + "Karet Kopling: $parentKopling " +
        "\n" + "Bearing: $parentBearing " + "\n" + "Packing Asbes: $packingAsbes " + "\n" + "Daun Impeller Pompa: $parentDaunImpellerPompa " +
        "\n" + "Bagian Yang Karat: $bagianKarat " + "\n" + "Kelainan Suara Mesin: $KelainanSuara " + "\n" + "Tanggal: $tanggalMesin")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image: Image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(
            HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tablePompaSungai)
        document.add(image)
        document.close()
        Help.helpDialog(requireContext(),"Cari file anda di memory telepon anda dan cari filenya $file","File anda berada di $file")

    }

    private fun validasi4(){
        binding.apply {
            val tanggal = parentTanggalShredderMill.editText?.text.toString()
            val eMotor = parentEMotor3.editText?.text.toString()
            val kopling = parentKaretKopling1.editText?.text.toString()
            val bearing = parentBearing3.editText?.text.toString()
            val packingAsbes = parentPackingAsbes1.editText?.text.toString()
            val parentImpellerVPompa = parentImpellerVPompa.editText?.text.toString()
            val parentVBelt = parentVBelt.editText?.text.toString()
            val bagianKarat = parentBagianKarat3.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin3.editText?.text.toString()

            if (tanggal.isEmpty() || eMotor.isEmpty() || kopling.isEmpty() || bearing.isEmpty() ||
                    packingAsbes.isEmpty() || parentImpellerVPompa.isEmpty() || parentVBelt.isEmpty() ||
                    bagianKarat.isEmpty() || kelainanSuara.isEmpty())
                    {
                        Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                            Toast.LENGTH_SHORT).show()
            }else{
                createPdfValidasi4And5(tanggal,eMotor,kopling,bearing,packingAsbes,parentImpellerVPompa,parentVBelt,bagianKarat,kelainanSuara,"SHREDDER MILL")
            }
        }
    }

    private fun validasi5(){
        binding.apply {
            val tanggal = parentTanggalCrumb.editText?.text.toString()
            val eMotor = parentEMotor4.editText?.text.toString()
            val kopling = parentKaretKopling2.editText?.text.toString()
            val bearing = parentBearing4.editText?.text.toString()
            val packingAsbes = parentPackingAsbes2.editText?.text.toString()
            val parentImpellerVPompa = parentImpellerVPompa1.editText?.text.toString()
            val parentVBelt = parentVBelt1.editText?.text.toString()
            val bagianKarat = parentBagianKarat4.editText?.text.toString()
            val kelainanSuara = parentKelainanSuaraMesin4.editText?.text.toString()

            if (tanggal.isEmpty() || eMotor.isEmpty() || kopling.isEmpty() || bearing.isEmpty() ||
                packingAsbes.isEmpty() || parentImpellerVPompa.isEmpty() || parentVBelt.isEmpty() ||
                bagianKarat.isEmpty() || kelainanSuara.isEmpty())
            {
                Toast.makeText(requireContext(),"Periksa kembali inputan anda, Isi semua inputan",
                    Toast.LENGTH_SHORT).show()
            }else{
                createPdfValidasi4And5(tanggal,eMotor,kopling,bearing,packingAsbes,parentImpellerVPompa,parentVBelt,bagianKarat,kelainanSuara,"SHREDDER CRUMB")
            }


        }
    }


    private fun createPdfValidasi4And5(tanggalMesin: String,eMotor: String,kopling: String,bearing: String,packingAsbes: String,impellerVPompa: String,
    vBelt: String,bagianKarat: String,kelainanSuara: String,namaMesin:String)
    {
        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

        val simpelDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(
            Date()
        )

        val dataTanggal = simpelDateFormat

        val file = File(path,"$dataTanggal $namaMesin.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)

        val paragraphTitle = Paragraph(namaMesin).setBold().setFontSize(24F).setTextAlignment(
            TextAlignment.LEFT)

        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal :$simpelDateFormat dan waktu: $waktu").setFontSize(18F).setTextAlignment(
            TextAlignment.LEFT)

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F,100F)
        val tableMesin = Table(width)
        tableMesin.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tableMesin.addCell(Cell().add(Paragraph("Tanggal")))
        tableMesin.addCell(Cell().add(Paragraph("E. Motor")))
        tableMesin.addCell(Cell().add(Paragraph("Karet Kopling")))
        tableMesin.addCell(Cell().add(Paragraph("Bearing")))
        tableMesin.addCell(Cell().add(Paragraph("Packing Asbes")))
        tableMesin.addCell(Cell().add(Paragraph("Impeller V. Pump")))
        tableMesin.addCell(Cell().add(Paragraph("V. Belt")))
        tableMesin.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tableMesin.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))


        tableMesin.addCell(Cell().add(Paragraph(tanggalMesin)))
        tableMesin.addCell(Cell().add(Paragraph(eMotor)))
        tableMesin.addCell(Cell().add(Paragraph(kopling)))
        tableMesin.addCell(Cell().add(Paragraph(bearing)))
        tableMesin.addCell(Cell().add(Paragraph(packingAsbes)))
        tableMesin.addCell(Cell().add(Paragraph(impellerVPompa)))
        tableMesin.addCell(Cell().add(Paragraph(vBelt)))
        tableMesin.addCell(Cell().add(Paragraph(bagianKarat)))
        tableMesin.addCell(Cell().add(Paragraph(kelainanSuara)))

        val barcode = BarcodeQRCode(namaMesin + "\n" + "E Motor: $eMotor " + "\n" + "Karet Kopling: $kopling" + "\n" + "Bearing: $bearing"
                + "\n" + "Pacing Asbes: $packingAsbes " + "\n" + "Impeller V. Pump: $impellerVPompa " + "\n" + "V. Belt: $vBelt"
                + "\n" + "Bagian Yang Karat: $bagianKarat " + "\n" + "Kelainan Suara Mesin: $kelainanSuara " + "\n" + "Tanggal: $tanggalMesin")

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