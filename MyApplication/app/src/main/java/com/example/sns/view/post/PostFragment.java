package com.example.sns.view.post;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


public class PostFragment extends Fragment {
    EditText edContents;
    EditText edTitle;


    ImageView imgPost;


    ActivityResultLauncher<Intent> resultLauncher;

    File mFile;

    String fcode;

    ArrayList<File> files;


    ResponseDTO<SnsData> dto;
    Retrofit retrofit;
    SnsV1API snsAPI;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View fView = inflater.inflate(R.layout.fragment_post, container, false);

        edContents = fView.findViewById(R.id.edPostContents);
        edTitle =fView.findViewById(R.id.edPostTitle);
        imgPost = fView.findViewById(R.id.post_image);
        imgPost.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            resultLauncher.launch(intent);
        });

        files = new ArrayList<>();

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == getActivity().RESULT_OK) {
                            Uri uri = result.getData().getData();
                            imgPost.setImageURI(uri);
                            imgPost.setAlpha(1.0f);
                            mFile = convertUriToFile(uri);
                            files.add(mFile);
                        }
                    }
                });



        retrofit = NetworkConfig.getClient();
        snsAPI = retrofit.create(SnsV1API.class);


        fView.findViewById(R.id.btnPost).setOnClickListener(view -> {
            fcode = UUID.randomUUID().toString();
            addSns();

        });

        return fView;
    }
    void addSns(){
        Log.d("apiTest ","addSns");


        SnsData sns = new SnsData();
        sns.setTitle(edTitle.getText().toString());
        sns.setImg(fcode);
        sns.setContent(edContents.getText().toString());


        snsAPI.addSns(sns).enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {

                if(response.code() == 200){

                    Log.d("apiTest 200",response.toString());
                    upload2();

                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
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
            Log.d("apiTest ","upload222");
        }

        snsAPI.uploadImages(mfiles).enqueue(new Callback<Void>() {
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

            bitmap =  MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
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






















