package ornek.uygulama.com.instagramklon.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ornek.uygulama.com.instagramklon.R;

public class ProfilDuzenleFragment extends Fragment {
    private static final String TAG = "ProfilDuzenleFragment"; //bunu unutma logt
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profil_duzenle,container,false);
        return view;
    }
}
