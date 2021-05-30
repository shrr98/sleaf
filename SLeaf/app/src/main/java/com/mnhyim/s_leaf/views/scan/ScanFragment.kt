package com.mnhyim.s_leaf.views.scan

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mnhyim.s_leaf.R
import com.mnhyim.s_leaf.databinding.FragmentHomeBinding
import com.mnhyim.s_leaf.databinding.FragmentScanBinding
import com.mnhyim.s_leaf.views.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.ByteArrayOutputStream
@FlowPreview
@ExperimentalCoroutinesApi
class ScanFragment : Fragment(), View.OnClickListener {

    private var TAG: String = this::class.java.simpleName

    private val scanViewModel: ScanViewModel by viewModel()

    private var _scanBinding: FragmentScanBinding? = null
    private val scanBinding get() = _scanBinding!!

    private val CAMERA_REQUEST: Int = 200
    private val GALLERY_REQUEST: Int = 300

    private lateinit var takenImage: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _scanBinding = FragmentScanBinding.inflate(layoutInflater, container, false)
        return scanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scanBinding.imgScanResult.setImageResource(R.drawable.bg_rounded_all)
        scanBinding.btnCaptureImage.setOnClickListener(this)
        scanBinding.btnScanImage.setOnClickListener(this)
        scanBinding.btnGalleryPicker.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_captureImage -> {
                Log.d(TAG, "btn_captureImage: pressed")
                captureImage()
            }
            R.id.btn_scanImage -> {
                Log.d(TAG, "btn_sendImage: pressed")
                scanImage(takenImage)
            }
            R.id.btn_galleryPicker -> {
                Log.d(TAG, "btn_galleryPicker: pressed")
                pickGallery()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_REQUEST && data != null) {
            takenImage = data.extras?.get("data") as Bitmap
            scanBinding.imgScanResult.setImageBitmap(takenImage)
        } else if (resultCode == Activity.RESULT_OK && requestCode == GALLERY_REQUEST && data != null) {
            val imageUri: Uri? = data.data
            val bitmap =
                MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageUri)
            takenImage = bitmap
            scanBinding.imgScanResult.setImageBitmap(bitmap)
        }
    }

    private fun captureImage() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST)
    }

    private fun pickGallery() {
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
    }

    private fun scanImage(image: Bitmap) {
        val base64img = encodeToBase64(image)
        scanViewModel.setScanImage(base64img)
        scanViewModel.scanResult.observe(this, { plant ->
        })
    }

    private fun encodeToBase64(image: Bitmap): String {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }
}