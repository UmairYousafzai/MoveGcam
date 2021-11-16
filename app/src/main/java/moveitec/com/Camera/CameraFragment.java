package moveitec.com.Camera;

import android.hardware.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moveitec.com.R;
import moveitec.com.databinding.FragmentCameraBinding;

public class CameraFragment extends Fragment {
    private Camera mCamera;
    private CameraPreview mPreview;
    private FragmentCameraBinding mBinding;
    

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding= FragmentCameraBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }

    @Override
    public void onResume() {
        super.onResume();

         mCamera= getCameraInstance();
        if (mCamera!=null)
        {
            mPreview = new CameraPreview(requireContext(),mCamera);
            mBinding.cameraPreview.addView(mPreview);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        releaseCamera();

    }

    public static android.hardware.Camera getCameraInstance(){
        Camera c = null;
        try {
            c = android.hardware.Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.d("Camera Fragment", "getCameraInstance: "+e.getMessage());
        }
        return c; // returns null if camera is unavailable
    }
    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }
}