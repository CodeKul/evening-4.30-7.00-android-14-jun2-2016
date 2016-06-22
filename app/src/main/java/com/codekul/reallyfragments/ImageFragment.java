package com.codekul.reallyfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {


    private static final String KEY_CARTOON_NAME = "cartoonName";

    public static ImageFragment getInstance(String cartoonName){

        ImageFragment fragment =
                new ImageFragment();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_CARTOON_NAME,cartoonName);

        fragment.setArguments(bundle);

        return fragment;
    }

    public ImageFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =
                inflater.inflate(R.layout.fragment_image,
                        container, false);

        Bundle args = getArguments();
        if(args != null) {
            if (args.getString(KEY_CARTOON_NAME)
                    .equals("Popeye")) {

                // show popeye imgae

                setImageData(R.mipmap.ic_launcher,view);
            }
        }

        return view;
    }

    private void setImageData(int imageId, View view)
    {
        ((ImageView)view.findViewById(R.id.imageCartoon))
                .setImageResource(imageId);
    }
}
