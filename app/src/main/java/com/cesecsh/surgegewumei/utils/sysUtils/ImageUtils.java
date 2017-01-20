package com.cesecsh.surgegewumei.utils.sysUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.cesecsh.surgegewumei.utils.viewUtils.ViewUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
/**
 * 作者：谢青仂 on 2016/8/15
 * 邮箱：qingle6616@sina.com
 * 1、下载image图片
 * 2、绘制圆形图
 * 3、根据图片比例绘制圆形图片
 * 4、drawable转bitmap
 * 5、获取图片优化参数
 * 6、给ImageView设置图片
 * 7、根据视频地址获取视频的第一帧图片
 */
public class ImageUtils {
    /**
     * 下载image图片
     *
     * @param url 下载地址
     * @return 返回bitmap
     */
    public static Bitmap loadImage(String url) {
        Bitmap bitmap = null;
        HttpURLConnection connection = null;
        InputStream is = null;
        try {
            URL str = new URL(url);
            connection = (HttpURLConnection) str.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            is = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (connection != null)
                connection.disconnect();
        }
        return bitmap;
    }


    private static void asyncDownloadingImage(final Context context, final String urlStr, final ImageView imageView,
                                              final String savePath, final String imageName) {

        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {

                try {
                    Bitmap bitmap = loadImage(urlStr);

                    // 下载完成 缓存到imageCache
                    // imageCache.put(urlStr, new
                    // SoftReference<Bitmap>(bitmap));

                    // 下载完成 缓存到本地
                    File file = new File(context.getCacheDir(), savePath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    FileOutputStream fos = new FileOutputStream(new File(file, imageName));
                    if (bitmap != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    }

                    return bitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            }

        }.execute();
    }

    private static void asyncDownloadingImage(final Context context, final String urlStr, final ImageView imageView,
                                              final String savePath, final String imageName, final int diameter) {

        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {

                try {
                    Bitmap bitmap = loadImage(urlStr);

                    // 下载完成 缓存到imageCache
                    // imageCache.put(urlStr, new
                    // SoftReference<Bitmap>(bitmap));

                    // 下载完成 缓存到本地
                    File file = new File(context.getCacheDir(), savePath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    FileOutputStream fos = new FileOutputStream(new File(file, imageName));
                    if (bitmap != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    }

                    return bitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap == null) {
                    File file = new File(context.getCacheDir(), savePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    return;
                }
                imageView.setImageBitmap(createCircleImage(bitmap, bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() : bitmap.getWidth()));
            }

        }.execute();
    }

    private static void asyncDownloadingImage(final Context context, final String urlStr, final ImageView imageView,
                                              final String savePath, final String imageName, final ProgressBar progress) {

        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {

                try {
                    Bitmap bitmap = loadImage(urlStr);

                    // 下载完成 缓存到imageCache
                    // imageCache.put(urlStr, new
                    // SoftReference<Bitmap>(bitmap));

                    // 下载完成 缓存到本地
                    File file = new File(context.getCacheDir(), savePath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    FileOutputStream fos = new FileOutputStream(new File(file, imageName));
                    if (bitmap != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    }

                    return bitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (progress != null) {
                    progress.setVisibility(View.GONE);
                }
                if (bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            }

        }.execute();
    }

    public static void asyncDownloadingImage(final Context context, final String urlStr, final Handler handler) {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                Bitmap bitmap = loadImage(urlStr);
                handler.sendMessage(Message.obtain(handler, 0, bitmap));
                return null;
            }

        }.execute();
    }

    /**
     * 绘制圆形图
     *
     * @param diameter 直径
     */
    public static Bitmap createCircleImage(Bitmap bitmap, int diameter) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleImage = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleImage);
        canvas.drawCircle(diameter / 2, diameter / 2, diameter / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return circleImage;
    }

    /**
     * 根据图片比例绘制圆形图片
     */
    public static Bitmap createCircleImage(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int x = (bitmap.getWidth() - size) / 2;
        int y = (bitmap.getHeight() - size) / 2;
        Bitmap squaredBitmap = Bitmap.createBitmap(bitmap, x, y, size, size);
        if (squaredBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap circleBitmap = Bitmap.createBitmap(size, size, bitmap.getConfig());
        Canvas canvas = new Canvas(circleBitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        squaredBitmap.recycle();
        return circleBitmap;
    }

    /**
     * 绘制圆角图片
     *
     * @param bitmap  源图片
     * @param roundPx 圆角大小 dp
     * @return
     */

    public static Bitmap getRoundCornerBitmap(Bitmap bitmap, float roundPx) {
        Bitmap roundConnerBitmap = null;
        try {
            roundConnerBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(roundConnerBitmap);
            final int color = 0XFF424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawRGB(0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return roundConnerBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roundConnerBitmap;
    }

    /**
     * drawable转bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 获取图片优化参数
     */
    public static BitmapFactory.Options getOptions(Context context, int imageId, int imageViewWidth, int imageViewHeight) {
        if (imageViewWidth <= 0 || imageViewHeight <= 0) {
            return null;
        }

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), imageId);
        int width = opts.outWidth;
        int height = opts.outHeight;

        int scalex = width / imageViewWidth;
        int scaley = height / imageViewHeight;

        if (scalex > scaley && scaley > 1) { // 水平方向的缩放比例比较大
            opts.inSampleSize = scalex;
        } else if (scaley > scalex && scalex > 1) { // 竖直方向的缩放比例比较大
            opts.inSampleSize = scaley;
        }
        opts.inJustDecodeBounds = false;
        return opts;
    }


    /**
     * 给ImageView设置图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片网络地址
     * @param imageView 需要设置图片的ImageView
     * @param savePath  下载图片成功后 保存在savePath文件夹
     */
    public static void setWebImage(Context context, String imageUrl, ImageView imageView, String savePath) {
        // 先从软引用缓存中获取图片
        // SoftReference<Bitmap> softReference = imageCache.get(imageUrl);
        // 再从本地文件获取图片
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        File iamgeFile = new File(context.getCacheDir(), savePath + "/" + imageName);

		/*
         * if(softReference != null && softReference.get() !=
		 * null){//先从软引用缓存中获取图片 imageView.setImageBitmap(softReference.get());
		 * }else
		 */
        if (iamgeFile.exists() && iamgeFile.length() > 0) {// 再从本地文件获取图片
            Bitmap bitmap = BitmapFactory.decodeFile(iamgeFile.getAbsolutePath(), getOptions(
                    iamgeFile.getAbsolutePath(), ViewUtils.getWidth(imageView), ViewUtils.getHeight(imageView)));
            imageView.setImageBitmap(bitmap);
        } else {// 异步下载
            asyncDownloadingImage(context, imageUrl, imageView, savePath, imageName);
        }
    }

    /**
     * 给ImageView设置图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片网络地址
     * @param imageView 需要设置图片的ImageView
     * @param savePath  下载图片成功后 保存在savePath文件夹
     */
    public static void setWebImage(Context context, String imageUrl, ImageView imageView, String savePath,
                                   ProgressBar progress) {
        // 先从软引用缓存中获取图片
        // SoftReference<Bitmap> softReference = imageCache.get(imageUrl);
        // 再从本地文件获取图片
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        File iamgeFile = new File(context.getCacheDir(), savePath + "/" + imageName);

		/*
         * if(softReference != null && softReference.get() !=
		 * null){//先从软引用缓存中获取图片 imageView.setImageBitmap(softReference.get());
		 * if(progress != null){ progress.setVisibility(View.GONE); } }else
		 */
        if (iamgeFile.exists() && iamgeFile.length() > 0) {// 再从本地文件获取图片
            Bitmap bitmap = BitmapFactory.decodeFile(iamgeFile.getAbsolutePath(), getOptions(
                    iamgeFile.getAbsolutePath(), ViewUtils.getWidth(imageView), ViewUtils.getHeight(imageView)));
            imageView.setImageBitmap(bitmap);
            if (progress != null) {
                progress.setVisibility(View.GONE);
            }
        } else {// 异步下载
            asyncDownloadingImage(context, imageUrl, imageView, savePath, imageName, progress);
            progress.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 给ImageView设置图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片网络地址
     * @param imageView 需要设置图片的ImageView
     * @param savePath  下载图片成功后 保存在savePath文件夹
     * @param diameter  直径
     */
    public static void setWebCircleImage(Context context, String imageUrl, ImageView imageView, String savePath,
                                         int diameter) {
        // 先从软引用缓存中获取图片
        // SoftReference<Bitmap> softReference = imageCache.get(imageUrl);
        // 再从本地文件获取图片
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        File iamgeFile = new File(context.getCacheDir(), savePath + "/" + imageName);

		/*
         * if(softReference != null && softReference.get() !=
		 * null){//先从软引用缓存中获取图片 imageView.setImageBitmap(softReference.get());
		 * }else
		 */
        if (iamgeFile.exists() && iamgeFile.length() > 0) {// 再从本地文件获取图片
            Bitmap bitmap = BitmapFactory.decodeFile(iamgeFile.getAbsolutePath(), getOptions(
                    iamgeFile.getAbsolutePath(), ViewUtils.getWidth(imageView), ViewUtils.getHeight(imageView)));
            if (bitmap != null)
                imageView.setImageBitmap(createCircleImage(bitmap,
                        bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() : bitmap.getWidth()));
        } else {// 异步下载
            asyncDownloadingImage(context, imageUrl, imageView, savePath, imageName, diameter);
        }
    }

    /**
     * 获取图片优化参数
     */
    public static BitmapFactory.Options getOptions(String imagePath, int imageViewWidth, int imageViewHeight) {
        if (TextUtils.isEmpty(imagePath) || imageViewWidth <= 0 || imageViewHeight <= 0) {
            return null;
        }

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, opts);
        int width = opts.outWidth;
        int height = opts.outHeight;

        int scalex = width / imageViewWidth;
        int scaley = height / imageViewHeight;

        if (scalex > scaley && scaley > 1) { // 水平方向的缩放比例比较大
            opts.inSampleSize = scalex;
        } else if (scaley > scalex && scalex > 1) { // 竖直方向的缩放比例比较大
            opts.inSampleSize = scaley;
        }
        opts.inJustDecodeBounds = false;
        return opts;
    }

    public static Bitmap createVideoThumbnail(String url, int width, int height) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        if (kind == MediaStore.Images.Thumbnails.MICRO_KIND && bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

    /**
     * 根据视频地址获取视频的第一帧图片
     *
     * @param filePath
     * @return
     */
    public static Bitmap createVideoThumbnail(String filePath) {
        // MediaMetadataRetriever is available on API Level 8
        // but is hidden until API Level 10
        Class<?> clazz = null;
        Object instance = null;
        try {
            clazz = Class.forName("android.media.MediaMetadataRetriever");
            instance = clazz.newInstance();

            Method method = clazz.getMethod("setDataSource", String.class);
            method.invoke(instance, filePath);

            // The method name changes between API Level 9 and 10.
            if (Build.VERSION.SDK_INT <= 9) {
                return (Bitmap) clazz.getMethod("captureFrame").invoke(instance);
            } else {
                byte[] data = (byte[]) clazz.getMethod("getEmbeddedPicture").invoke(instance);
                if (data != null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    if (bitmap != null) return bitmap;
                }
                return (Bitmap) clazz.getMethod("getFrameAtTime").invoke(instance);
            }
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } catch (InstantiationException e) {
            Log.e("TAG", "createVideoThumbnail", e);
        } catch (InvocationTargetException e) {
            Log.e("TAG", "createVideoThumbnail", e);
        } catch (ClassNotFoundException e) {
            Log.e("TAG", "createVideoThumbnail", e);
        } catch (NoSuchMethodException e) {
            Log.e("TAG", "createVideoThumbnail", e);
        } catch (IllegalAccessException e) {
            Log.e("TAG", "createVideoThumbnail", e);
        } finally {
            try {
                if (instance != null) {
                    clazz.getMethod("release").invoke(instance);
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }


}
