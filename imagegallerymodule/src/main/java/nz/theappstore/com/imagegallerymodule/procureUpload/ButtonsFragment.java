package nz.theappstore.com.imagegallerymodule.procureUpload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import nz.theappstore.com.imagegallerymodule.R;
import nz.theappstore.com.imagegallerymodule.procureUpload.util.ButtonFragmentEventsLive;

public class ButtonsFragment extends Fragment {

    public static final int TAKE_PHOTO_PANEL = 0;
    public static final int MANAGE_PHOTO_PANEL = 1;

    private ViewSwitcher switcher;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View buttonsView =  inflater.inflate(R.layout.buttons_fragment, container, false);
        setupReactiveListeners(buttonsView);
        return buttonsView;
    }

    void setupReactiveListeners(View view) {
        switcher = view.findViewById(R.id.buttons_switcher);
        FloatingActionButton takePhotoButton = switcher.findViewById(R.id.takePhotoButton);
        FloatingActionButton discardPhotoButton = switcher.findViewById(R.id.discardImageButton);
        FloatingActionButton uploadImageButton = switcher.findViewById(R.id.uploadImageButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonFragmentEventsLive.setPhotoClickButtonEvent(view);
                switchView(1);
            }
        });

        discardPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonFragmentEventsLive.setDiscardPhotoButtonEvent(view);
                switchView(0);
            }
        });

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonFragmentEventsLive.setUploadButtonEvent(view);
                switchView(0);
                Toast.makeText(getContext(), "Uploading Image...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //buttonsImageScreen

    void switchView(int child) {
        switcher.setDisplayedChild(child);
    }
}
