package in.slanglabs.facebookmock;

import android.app.Application;

public class FbMockApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // sets the context to slang voice interface during onCreate
        SlangVoiceInterface.init(this);
    }
}
