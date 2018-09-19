package in.slanglabs.facebookmock;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import in.slanglabs.platform.application.ISlangApplicationStateListener;
import in.slanglabs.platform.application.SlangApplication;
import in.slanglabs.platform.application.SlangApplicationUninitializedException;
import in.slanglabs.platform.application.actions.DefaultResolvedIntentAction;
import in.slanglabs.platform.session.SlangResolvedIntent;
import in.slanglabs.platform.session.SlangSession;

public class SlangVoiceInterface
{
    private static Application application_context;

    public static void init(final Application application_context)
    {
        SlangVoiceInterface.application_context = application_context; //set the app context to class variable

        //initialize the slang voice

        SlangApplication
                .initialize(
                        application_context,
                        R.string.appId,
                        R.string.authKey,
                        new ISlangApplicationStateListener() {
                            @Override
                            public void onInitialized() {
                                try {
                                    registerActions();
                                } catch (SlangApplicationUninitializedException e) {
                                    Toast.makeText(
                                            application_context,
                                            "Slang uninitialized - " + e.getLocalizedMessage(),
                                            Toast.LENGTH_LONG
                                    ).show();
                                }
                            }

                            @Override
                            public void onInitializationFailed(FailureReason failureReason) {
                                Toast.makeText(
                                        application_context,
                                        "Could not initialize slang!",
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        }
                );
        SlangApplication.setDefaultContinuationMode(SlangSession.ContinuationMode.CONTINUE);

    }


    private static void registerActions() throws SlangApplicationUninitializedException
    {
        // Action to handle user profile
        SlangApplication.getIntentDescriptor("show_profile").setResolutionAction(new DefaultResolvedIntentAction() {

            @Override
            public SlangSession.Status action(SlangResolvedIntent slangResolvedIntent, SlangSession slangSession) {
                Intent i = new Intent(application_context, MainActivity.class);

                i.putExtra(
                        ActivityList.ACTIVITY_MODE,
                        ActivityList.MODE_PROFILE
                );

                application_context.startActivity(i);

                return slangSession.success();

            }

        });


        // Action to handle home page
        SlangApplication.getIntentDescriptor("home").setResolutionAction(new DefaultResolvedIntentAction() {

            @Override
            public SlangSession.Status action(SlangResolvedIntent slangResolvedIntent, SlangSession slangSession) {
                Intent i = new Intent(application_context, MainActivity.class);

                i.putExtra(
                        ActivityList.ACTIVITY_MODE,
                        ActivityList.MODE_HOME
                );

                application_context.startActivity(i);

                return slangSession.success();

            }

        });

        // Action to handle user liked page
        SlangApplication.getIntentDescriptor("page").setResolutionAction(new DefaultResolvedIntentAction() {

            @Override
            public SlangSession.Status action(SlangResolvedIntent slangResolvedIntent, SlangSession slangSession) {
                Intent i = new Intent(application_context, MainActivity.class);

                i.putExtra(
                        ActivityList.ACTIVITY_MODE,
                        ActivityList.MODE_PAGE
                );

                application_context.startActivity(i);

                return slangSession.success();

            }
        });

        // Action to handle language preference
        SlangApplication.getIntentDescriptor("language").setResolutionAction(new DefaultResolvedIntentAction() {

            @Override
            public SlangSession.Status action(SlangResolvedIntent slangResolvedIntent, SlangSession slangSession) {
                Intent i = new Intent(application_context, MainActivity.class);

                i.putExtra(
                        ActivityList.ACTIVITY_MODE,
                        ActivityList.MODE_LANGUAGE
                );

                application_context.startActivity(i);

                return slangSession.success();

            }

        });


        // Action to handle payment setting
        SlangApplication.getIntentDescriptor("payment").setResolutionAction(new DefaultResolvedIntentAction() {

            @Override
            public SlangSession.Status action(SlangResolvedIntent slangResolvedIntent, SlangSession slangSession) {
                Intent i = new Intent(application_context, MainActivity.class);

                i.putExtra(
                        ActivityList.ACTIVITY_MODE,
                        ActivityList.MODE_PAYMENT
                );

                application_context.startActivity(i);

                return slangSession.success();

            }

        });
    }

}
