package com.example.stickmanjump;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class UploadHighScore extends AppCompatActivity {
    private static final int  PICK_IMAGE_REQUEST = 71;


    //Variablat

    private Button btnChoose,btnUpload;
    private ImageView imageView;

    //Deklarimi i variablave te FireBase
    FirebaseStorage storage;
    StorageReference storageReference;

    private Uri filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_high_score);

        //inicializimi variablav
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        imageView = (ImageView) findViewById(R.id.imgView);

        //inicializimi firebase variablav
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View v) {
                chooseImage();


            }
        });

    }
    //Krijimi i metodes uploadImage e cila ekzekutohet kur klikohet butoni upload
    private void uploadImage() {

        if (filePath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref =  storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath) //kur uploadohet me sukses
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(UploadHighScore.this,"Uploaded! Thank You",Toast.LENGTH_SHORT).show();
                        }
                        //kur kemi ndonje error gjat uploadimit
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(UploadHighScore.this,"Failed! Please Try Again "+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                //dhe gjat progresit uploadimit
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                    //kjo asht ajo me % qe mushet kur kallzon per upload.
                    double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploading"+(int)progress+"%");
                }
            });

        }
    }

    //krijimi i metodes chooseImage
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void chooseImage() {
        //pe krijojm nje intent, qe kur ta klikojm choose image, me na dal file exploreri per me zgjedh fotografin.
        Intent chooseImg =  new Intent();
        chooseImg.setType("image/*");
        chooseImg.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(chooseImg,"Select Picture"),PICK_IMAGE_REQUEST);
    }
    //qekjo bahet qe me dit a i kemi dhan akses me u qas ne filepath?
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            filePath = data.getData();
        }
        try{
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
            imageView.setImageBitmap(bitmap);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
