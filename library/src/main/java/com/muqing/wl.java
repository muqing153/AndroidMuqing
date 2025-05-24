package com.muqing;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @noinspection unused
 */
public class wl {
    public static String api = "";
    public static String hq(String url, String get) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(api + url + "?" + get)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (Exception e) {
            gj.sc("hq: " + e.getMessage());
        }
        return null;
    }
    public static String post(String str, Object[][] a) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (Object[] b : a) {
            builder.add(b[0].toString(), b[1].toString());
        }
        Request request = new Request.Builder()
                .url(str)
                .post(builder.build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                return response.body().string();
            }

        } catch (Exception e) {
            StringBuilder aa = new StringBuilder();
            for (Object[] b : a) {
                aa.append(b[0]).append(":").append(b[1]).append("\n");
            }
            gj.sc("post: " + e.getMessage() + "\n" + aa);
        }
        return null;
    }


    public static Bitmap GetBitMap(Context context, String url) throws Exception {
        FutureTarget<Bitmap> futureTarget = Glide.with(context)
                .asBitmap()
                .load(url)
                .submit();
        return futureTarget.get(); // 阻塞等待加载完成
    }


    //    public static void
    public static void xz(String url, File file) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url) // 替换为你实际的文件 URL
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                gj.sc(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    // 获取输入流
                    InputStream is = response.body().byteStream();
                    // 设置文件保存路径
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buffer = new byte[2048];
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    is.close();
                    gj.sc("File saved: " + file.getAbsolutePath());
                    // 你也可以在这里提示用户或直接安装 APK（需要在主线程）
                } else {
                    gj.sc("Failed: " + response.message());
                }
            }
        });
    }
}
