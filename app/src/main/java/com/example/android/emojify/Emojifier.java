package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by albar on 17/11/2017.
 */

public class Emojifier {

    // Method untuk mendeteksi wajah dengan gambar bitmap
    public static void detectFaces(Context context, Bitmap picture){

        /**
         * Pendeteksi wajah, fitur livetracking dimatikan karena pengambilan hanya dalam bentuk
         * gambar individual bukan video secara berkelanjutan
         * Klasifikasi di aktifkan
          */
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Membuat Frame
        Frame frame = new Frame.Builder().setBitmap(picture).build();

        // Deteksi Wajah
        SparseArray<Face> faces = detector.detect(frame);

        Log.d("Emojifier", "Wajah yang terdeteksi "+ faces.size());

        // Jika tidak ada wajah yang terdeteksi, tampilakan pesan
        if(faces.size() == 0){
            Toast.makeText(context, "No face detected", Toast.LENGTH_SHORT).show();
        }

        // Matikan pendeteksi wajah
        detector.release();

    }
}
