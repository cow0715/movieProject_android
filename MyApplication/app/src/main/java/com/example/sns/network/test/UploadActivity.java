package com.example.sns.network.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;
import com.example.sns.data.ResponseDTO;
import com.example.sns.data.SnsData;

import com.example.sns.network.NetworkConfig;
import com.example.sns.network.SnsV1API;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
*  EasyPermissions 퍼미션 체크
*  파일 및 이미지 가져오기
* */
public class UploadActivity extends AppCompatActivity {
    private final int REQUEST_PERMISSION = 1;

    private Button btnFile;
    private TextView txtFileName;
    private ImageView imageView;
    private  Button btnUpload;

    String FilePath = "";

    File mFile;

    ResponseDTO<SnsData> dto;
    Retrofit retrofit;
    SnsV1API snsV1API;


    String fcode;

    ArrayList<File> files;

    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        btnFile = findViewById(R.id.btnFile);
        txtFileName = findViewById(R.id.txtFileName);
        imageView = findViewById(R.id.imgUpload);
        btnUpload = findViewById(R.id.btnUpload);

        files = new ArrayList<>();


        btnFile.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            resultLauncher.launch(intent);
        });

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Uri uri = result.getData().getData();
                            imageView.setImageURI(uri);
                            mFile = convertUriToFile(uri);
                            files.add(mFile);
                        }
                    }
                });




        retrofit = NetworkConfig.getClient();
        snsV1API = retrofit.create(SnsV1API.class);


        btnUpload.setOnClickListener(view ->{
            fcode = UUID.randomUUID().toString();
//            addSns();


            upload2();
        });
    }


    void addSns(){
        Log.d("apiTest ","addSns");
        SnsData sns = new SnsData();
        sns.setTitle("타이틀");
        sns.setImg(fcode); // 111
        sns.setContent("안드로이드 업로더 내용");


        snsV1API.addSns(sns).enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {
                if (response.code() == 200){
                    Log.d("apitest", response.toString());
                    upload2();
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {

            }
        });
    }




    void upload2(){
        Log.d("apiTest ","upload");

        ArrayList<MultipartBody.Part> mfiles = new ArrayList<>();


        for (int i = 0; i < files.size(); ++i) {

            RequestBody fileBody =RequestBody.create(MediaType.parse("multipart/form-data"), files.get(i));

            // 사진 파일 이름{}
            String fileName = fcode+"_" + i + ".png";
            // RequestBody로 Multipart.Part 객체 생성
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("files", fileName, fileBody);

            // 추가
            mfiles.add(filePart);
        }

        snsV1API.uploadImages(mfiles).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("apiTest ","upload onResponse");
                Log.d("apiTest",response.toString());
                if(response.code() == 200){

                    Log.d("apiTest 200 ",response.toString());
//                    adapter.replaceItem(list);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Log.d("apiTest fail",t.getMessage());

            }
        });
    }


    File convertUriToFile(Uri uri) {

        if(uri == null ) {
            return null;
        }

        Bitmap bitmap;
        File file = null;

        try {

//            final String folderPath = Environment.getExternalStorageDirectory() + File.separator + "123" + System.currentTimeMillis();

            bitmap =  MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "test.png");
            file.createNewFile();


            if(bitmap != null){

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 20 , bos); // YOU can also save it in JPEG
                byte[] bitmapdata = bos.toByteArray();

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(bitmapdata);
                fos.flush();
                fos.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return file;
    }
}