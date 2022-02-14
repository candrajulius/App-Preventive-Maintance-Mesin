@file:Suppress("DEPRECATION")

package com.candra.preventivemaintancemesin

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Environment
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
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

object Help {

    fun helpDialog(context: Context, inputanPertama: String, inputanKedua: String){
        val builder = AlertDialog.Builder(context,R.style.AlertDialogTheme)
        val view = LayoutInflater.from(context).inflate(
            R.layout.help_dialog_message,
            null
        )
        builder.setView(view)
        view.findViewById<MaterialTextView>(R.id.isiTeks).text = inputanPertama
        view.findViewById<MaterialTextView>(R.id.isiTeksPeringatan).text = inputanKedua

        val alertDialog = builder.create()

        view.findViewById<ImageButton>(R.id.closeBtn).setOnClickListener {
            alertDialog.dismiss()
        }

        if (alertDialog.window != null){
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        alertDialog.show()
    }

    fun setAdapterData(text: AutoCompleteTextView,context: Context){
        val data = context.resources.getStringArray(R.array.opsi)
        val arrayAdapter = ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,data)
        text.setAdapter(arrayAdapter)
    }

    fun setCalendar(tanggalMesin: TextInputEditText,context: Context){
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            val myDateFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myDateFormat,Locale.UK)
            tanggalMesin.setText(sdf.format(calendar.time))
        }
        tanggalMesin.setOnClickListener {
            DatePickerDialog(context,datePicker,calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    fun setExpandleCardView(imageButton: ImageButton,viewGroup: LinearLayout,cardView: MaterialCardView)
    {
        imageButton.setOnClickListener {
            if (viewGroup.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(cardView,AutoTransition())
                viewGroup.visibility = View.GONE
                imageButton.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }else{
                TransitionManager.beginDelayedTransition(cardView,AutoTransition())
                viewGroup.visibility = View.VISIBLE
                imageButton.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            }
        }
    }

    fun createPdF(tanggalMesin: String,parentEmotor: String,parentGearBox: String,
    parentBearing: String,parentKondisiRoll: String,parentBaut:String,parentVBelt:String,
    parentBagianKarat: String,parentSuaraMesin: String,namaMesin: String,context: Context)
    {
        val path: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
        val simpleDateFormat = SimpleDateFormat("EEEE,dd MMM yyyy",Locale.getDefault()).format(
            Date()
        )
        val tanggalData: String = simpleDateFormat

        val file = File(path,"$tanggalData $namaMesin.pdf")

        val writer = PdfWriter(file)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument)
        pdfDocument.defaultPageSize = PageSize.A4
        document.setMargins(0F,0F,0F,0F)

        val paragraphTitle = Paragraph(namaMesin).setBold().setFontSize(24F).setTextAlignment(TextAlignment.LEFT)
        val waktu = SimpleDateFormat("HH:mm:ss a",Locale.getDefault()).format(Date())
        val tanggalDanWaktu = Paragraph("Dibuat pada tanggal: $simpleDateFormat dan waktu: $waktu").setFontSize(10F).setTextAlignment(TextAlignment.LEFT)

        val width = floatArrayOf(100F,100F,100F,100F,100F,100F,100F,100F,100F)
        val tabelMesin = Table(width)
        tabelMesin.setHorizontalAlignment(HorizontalAlignment.LEFT)
        tabelMesin.addCell(Cell().add(Paragraph("Tanggal")))
        tabelMesin.addCell(Cell().add(Paragraph("E Motor")))
        tabelMesin.addCell(Cell().add(Paragraph("Gearbox")))
        tabelMesin.addCell(Cell().add(Paragraph("Bearing")))
        tabelMesin.addCell(Cell().add(Paragraph("Kondisi Roll")))
        tabelMesin.addCell(Cell().add(Paragraph("Baut")))
        tabelMesin.addCell(Cell().add(Paragraph("V.Belt")))
        tabelMesin.addCell(Cell().add(Paragraph("Bagian Yang Karat")))
        tabelMesin.addCell(Cell().add(Paragraph("Kelainan Suara Mesin")))

        tabelMesin.addCell(Cell().add(Paragraph(tanggalMesin)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentEmotor)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentGearBox)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentBearing)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentKondisiRoll)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentBaut)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentVBelt)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentBagianKarat)).setFontSize(10F))
        tabelMesin.addCell(Cell().add(Paragraph(parentSuaraMesin)).setFontSize(10F))

        val barcode = BarcodeQRCode("$namaMesin \n E Motor: $parentEmotor \n Gearbox: $parentGearBox " +
                "\n Bearing: $parentBearing \n Kondisi Roll: $parentKondisiRoll \n Baut: $parentBaut \n V Belt: $parentVBelt" +
                "\n Bagian Yang Karat: $parentBagianKarat \n Kelainan Suara Mesin: $parentSuaraMesin")

        val qrCodeObject = barcode.createFormXObject(ColorConstants.BLACK,pdfDocument)
        val image: Image = Image(qrCodeObject).setWidth(100F).setHorizontalAlignment(HorizontalAlignment.LEFT)

        document.add(paragraphTitle)
        document.add(tanggalDanWaktu)
        document.add(tabelMesin)
        document.add(image)
        document.close()
        helpDialog(context,"Cari file anda di memory telepon anda dan cari filenya $file",
        "File anda berada di $file")
    }

    fun setValidasiData(tanggalMesin: String,parentEmotor: String,
                        parentGearBox: String,parentBearing: String,parentKondisiRoll: String,parentBaut: String, parentVbelt: String,
                         parentBagianKarat: String,parentKelainanSuara: String,context: Context,namaMesin: String)
    {
        if (tanggalMesin.isEmpty() || parentEmotor.isEmpty() || parentGearBox.isEmpty() || parentBearing.isEmpty() ||
                parentKondisiRoll.isEmpty() || parentBaut.isEmpty() || parentVbelt.isEmpty()
            || parentBagianKarat.isEmpty() || parentKelainanSuara.isEmpty())
            {
                Toast.makeText(context,"Periksa kembali inputan anda,Isi semua inputan",Toast.LENGTH_SHORT).show()
            }else{
                createPdF(tanggalMesin,parentEmotor,parentGearBox,parentBearing,parentKondisiRoll,parentBaut,
                parentVbelt,parentBagianKarat,parentKelainanSuara,namaMesin,context)
            }
    }

}