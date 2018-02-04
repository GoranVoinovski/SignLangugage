package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.DeviceShareButton;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class shareOnFBActivity extends AppCompatActivity {

    private static final String TAG = "";
    @BindView(R.id.textSoIme)
    TextView imeSoTekst;
    @BindView(R.id.slideshow)
    VideoView slajdSliki;
    ImageButton tviter;
    ShareDialog shareDialog;
    CallbackManager callbackManager;
    ShareLinkContent linkContent;
    ImageButton shareButton;
    User user;
    Timer myTimer;
    Zborovi zbor;
    Sliki slika;
    Bitmap slikaFB;
    char a;
    int count = 0;
    int count2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_share_on_fb);
//        slikaFB = BitmapFactory.decodeResource(this.getResources(), R.raw.l);
        ButterKnife.bind(this);
        myTimer = new Timer();
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        tviter = (ImageButton) findViewById(R.id.twiter);
        shareButton = (ImageButton) findViewById(R.id.facebook);
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {


            @Override
            public void onSuccess(Sharer.Result result) {
                Toast.makeText(shareOnFBActivity.this, "Успешно споделивте", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(shareOnFBActivity.this, "Споделувањето е прекинато", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(shareOnFBActivity.this, "Грешка во споделувањето", Toast.LENGTH_SHORT).show();
            }
        });

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                ShareFacebook();

                }
            });

        tviter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareTwitter("Sign language app");
            }
        });



        user = SharedPreferences.getUser(this);
        zbor = user.zborovi.get(0);


            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new TimerTask() {
                        @Override
                        public void run() {

                            slika = zbor.contents.get(count++);
                            slajdSliki.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    mp.setLooping(false);
                                }
                            });

                            String path = "android.resource://" + shareOnFBActivity.this.getPackageName() + "/" + slika.slika;
                            slajdSliki.setVideoPath(path);
                            slajdSliki.start();
                            if (count >= zbor.contents.size()) {
                                count = 0;

                            }
                        }
                    });
                }
            }, 0, 5000);

            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new TimerTask() {
                        @Override
                        public void run() {

                            a = zbor.bukvi.get(count2++);
                            imeSoTekst.setText("" + a);
                            if (count2 >= zbor.bukvi.size()) {
                                count2 = 0;
                            }
                        }
                    });
                }
            }, 0, 5000);


    }

    public void ShareFacebook(){

        if (ShareDialog.canShow(ShareLinkContent.class)) {
            linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse(String.valueOf("www.google.com")))
                    .build();
           shareDialog.show(linkContent);
        }

//        SharePhoto photo = new SharePhoto.Builder()
//                .setBitmap(slikaFB)
//       .build();
//        SharePhotoContent content = new SharePhotoContent.Builder()
//                .addPhoto(photo)
//                .build();
//        shareDialog.show(content);
    }
        @Override
        protected void onActivityResult ( final int requestCode, final int resultCode,
        final Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }


    public void shareTwitter(String message) {
        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "This is a Test.");
        tweetIntent.setType("text/plain");

        PackageManager packManager = getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for (ResolveInfo resolveInfo : resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if (resolved) {
            startActivity(tweetIntent);
        } else {
            Intent i = new Intent();
            i.putExtra(Intent.EXTRA_TEXT, message);
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(message)));
            startActivity(i);
            Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }
    }

    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.wtf(TAG, "UTF-8 should always be supported", e);
            return "";
        }
    }
    }
