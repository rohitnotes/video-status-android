package com.vikas.statusview;
/*
*      Author: Vikas Kukreti
*
*
* */
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import com.bolaware.viewstimerstory.Momentz;
import com.bolaware.viewstimerstory.MomentzCallback;
import com.bolaware.viewstimerstory.MomentzView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MomentzCallback {

    static String[] videos = {
            "https://r2---sn-ci5gup-qxay.googlevideo.com/videoplayback?expire=1581947550&ei=PkZKXp_KDK233LUPqe2XoAk&ip=182.64.159.236&id=o-ADvDkwcfjJJmy4gNPdgkLBmy6a51nE7wCOqyNxqiKv81&itag=18&source=youtube&requiressl=yes&mm=31%2C26&mn=sn-ci5gup-qxay%2Csn-cvh7knez&ms=au%2Conr&mv=m&mvi=1&pcm2cms=yes&pl=20&initcwndbps=645000&vprv=1&mime=video%2Fmp4&gir=yes&clen=1989641&ratebypass=yes&dur=31.137&lmt=1578991340310040&mt=1581925895&fvip=2&fexp=23842630&c=WEB&txp=6201222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AHylml4wRgIhAL8XoOmQ13lJkxHZ4l-kIIik3v91k25Ns8qR9gJhfgj0AiEA3pvak6gHHrtzYLgz1_ayqVsm9cW-CkxhUGTQQtDaLZE%3D&sig=ALgxI2wwRgIhAMnAYUX18AV3Y7EA8nlkNkb2I6tV0SPjvVUO59QuJYAzAiEA_M7rq1yXvSZDsK04jlUL7dKO3EodhWvpsYW65fDLdvI=",
            "https://r5---sn-ci5gup-qxak.googlevideo.com/videoplayback?expire=1581947615&ei=f0ZKXr7zGsOCoQOqg5iYCA&ip=182.64.159.236&id=o-AE9zs2Yyt3qtLFtaI0KbizYb7KUVPXKb1pwpsuqFOglm&itag=18&source=youtube&requiressl=yes&mm=31%2C26&mn=sn-ci5gup-qxak%2Csn-cvh7knek&ms=au%2Conr&mv=m&mvi=4&pcm2cms=yes&pl=20&initcwndbps=896250&vprv=1&mime=video%2Fmp4&gir=yes&clen=1412589&ratebypass=yes&dur=23.962&lmt=1559187123114534&mt=1581925895&fvip=5&fexp=23842630&c=WEB&txp=2211222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AHylml4wRQIhAPIgvOxfbG9m1EDsODGOT192B7e9od5wEA9wO8r5tXFNAiBv-uPsOxiKN0mx76lLL-8RMJU87XhUX-3_Je5gFxo7FA%3D%3D&sig=ALgxI2wwRAIgXR8RIyt3aZ0Cci92L_xHTMalECFJ6r1Llu_qfeJRKbQCIGMs09vF9D0b0Fu_TdgxP15y3Y8fD3K-awnpqsHfDWGw",
            "https://r5---sn-ci5gup-qxak.googlevideo.com/videoplayback?expire=1581947615&ei=f0ZKXr7zGsOCoQOqg5iYCA&ip=182.64.159.236&id=o-AE9zs2Yyt3qtLFtaI0KbizYb7KUVPXKb1pwpsuqFOglm&itag=18&source=youtube&requiressl=yes&mm=31%2C26&mn=sn-ci5gup-qxak%2Csn-cvh7knek&ms=au%2Conr&mv=m&mvi=4&pcm2cms=yes&pl=20&initcwndbps=896250&vprv=1&mime=video%2Fmp4&gir=yes&clen=1412589&ratebypass=yes&dur=23.962&lmt=1559187123114534&mt=1581925895&fvip=5&fexp=23842630&c=WEB&txp=2211222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AHylml4wRQIhAPIgvOxfbG9m1EDsODGOT192B7e9od5wEA9wO8r5tXFNAiBv-uPsOxiKN0mx76lLL-8RMJU87XhUX-3_Je5gFxo7FA%3D%3D&sig=ALgxI2wwRAIgXR8RIyt3aZ0Cci92L_xHTMalECFJ6r1Llu_qfeJRKbQCIGMs09vF9D0b0Fu_TdgxP15y3Y8fD3K-awnpqsHfDWGw",
            "https://r5---sn-ci5gup-qxak.googlevideo.com/videoplayback?expire=1581947615&ei=f0ZKXr7zGsOCoQOqg5iYCA&ip=182.64.159.236&id=o-AE9zs2Yyt3qtLFtaI0KbizYb7KUVPXKb1pwpsuqFOglm&itag=18&source=youtube&requiressl=yes&mm=31%2C26&mn=sn-ci5gup-qxak%2Csn-cvh7knek&ms=au%2Conr&mv=m&mvi=4&pcm2cms=yes&pl=20&initcwndbps=896250&vprv=1&mime=video%2Fmp4&gir=yes&clen=1412589&ratebypass=yes&dur=23.962&lmt=1559187123114534&mt=1581925895&fvip=5&fexp=23842630&c=WEB&txp=2211222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AHylml4wRQIhAPIgvOxfbG9m1EDsODGOT192B7e9od5wEA9wO8r5tXFNAiBv-uPsOxiKN0mx76lLL-8RMJU87XhUX-3_Je5gFxo7FA%3D%3D&sig=ALgxI2wwRAIgXR8RIyt3aZ0Cci92L_xHTMalECFJ6r1Llu_qfeJRKbQCIGMs09vF9D0b0Fu_TdgxP15y3Y8fD3K-awnpqsHfDWGw"
    };


    Momentz momentz;
    private int i;
    RelativeLayout container;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        List<MomentzView> stories = new ArrayList<>();
        for (String video: videos) {
            stories.add(new MomentzView(getVideoView(video), 30));
        }
        momentz = new Momentz(this, stories, container, this, R.drawable.green_lightgrey_drawable);
        momentz.start();
    }

    private View getVideoView(String url) {
        VideoView videoView = new VideoView(this);
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        return videoView;

    }

    private void playVideo(View view, final int index) {
        final VideoView videoView = (VideoView) view;
        videoView.requestFocus();
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                    momentz.editDurationAndResume(index, (videoView.getDuration()) / 1000);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onNextCalled(View view, Momentz momentz, int i) {
        momentz.pause(true);
        try {
            playVideo(view, i);
        } catch (Exception e) {
            Toast.makeText(this, "Unable to play video!", Toast.LENGTH_SHORT).show();
            momentz.next();
        }
    }

    @Override
    public void done() {
        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
    }
}
