package ornek.uygulama.com.instagramklon.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Utils.UniversalImageLoader;

public class ProfilDuzenleFragment extends Fragment {
    private static final String TAG = "ProfilDuzenleFragment"; //bunu unutma logt


    private ImageView imageView;
    private ImageView geriImageview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profil_duzenle,container,false);

        imageView=view.findViewById(R.id.profile_image);

        geriImageview=view.findViewById(R.id.geriImageview);
        geriImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("tıklandı");
                getActivity().finish();
            }
        });
        initImageLoader();

        setProfileImage();
        return view;
    }


    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    private void setProfileImage(){

        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
        UniversalImageLoader.setImage(imgURL, imageView, null, "https://");
    }
}