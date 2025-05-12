package com.muqing;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;

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
}
