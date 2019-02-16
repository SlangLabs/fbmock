package in.slanglabs.facebookmock;

import android.content.Intent;
import android.content.Context;
import android.app.Application;

import in.slanglabs.platform.SlangBuddy;
import in.slanglabs.platform.SlangIntent;
import in.slanglabs.platform.SlangLocale;
import in.slanglabs.platform.SlangSession;
import in.slanglabs.platform.SlangBuddyOptions;
import in.slanglabs.platform.action.SlangIntentAction;

import static in.slanglabs.platform.action.SlangAction.Status.SUCCESS;

public class SlangVoiceInterface
{
    private static Context app_context;

    public static void init(final Application application_context)
    {
        app_context = application_context; //set the app context to class variable

        //initialize the slang voice

        try {

            SlangBuddyOptions options = new SlangBuddyOptions.Builder()
                    .setContext(application_context)
                    .setBuddyId(application_context.getString(R.string.buddyId))
                    .setAPIKey(application_context.getString(R.string.authKey))
                    .setIntentAction(new SlangAction()) // Pass the instance of the intent handler
                    .setRequestedLocales(SlangLocale.getSupportedLocales())
                    .setDefaultLocale(SlangLocale.LOCALE_ENGLISH_IN)
                    .build();

            SlangBuddy.initialize(options);
        } catch (SlangBuddyOptions.InvalidOptionException e) {
            e.printStackTrace();
        }catch (SlangBuddy.InsufficientPrivilegeException e) {
            e.printStackTrace();
        }


    }


    private static class SlangAction implements SlangIntentAction {
        @Override
        public Status action(SlangIntent intent, SlangSession session) {
            switch (intent.getName()) {
                case "home":
                    handleHome();
                    break;

                case "show_profile":
                    handleProfile();
                    break;

                case "payment":
                    handlePayment();
                    break;

                case "language":
                    handleLanguage();
                    break;

                case "page":
                    handlePage();
                    break;
            }

            return SUCCESS;
        }

        private void handleHome(){
            Intent i = new Intent(app_context, MainActivity.class);
            i.putExtra(
                    ActivityList.ACTIVITY_MODE,
                    ActivityList.MODE_HOME
            );

            app_context.startActivity(i);
        }

        private void handleProfile(){
            Intent i = new Intent(app_context, MainActivity.class);
            i.putExtra(
                    ActivityList.ACTIVITY_MODE,
                    ActivityList.MODE_PROFILE
            );

            app_context.startActivity(i);
        }
        private void handlePayment(){
            Intent i = new Intent(app_context, MainActivity.class);
            i.putExtra(
                    ActivityList.ACTIVITY_MODE,
                    ActivityList.MODE_PAYMENT
            );

            app_context.startActivity(i);
        }

        private void handleLanguage(){
            Intent i = new Intent(app_context, MainActivity.class);
            i.putExtra(
                    ActivityList.ACTIVITY_MODE,
                    ActivityList.MODE_LANGUAGE
            );

            app_context.startActivity(i);
        }

        private void handlePage(){
            Intent i = new Intent(app_context, MainActivity.class);
            i.putExtra(
                    ActivityList.ACTIVITY_MODE,
                    ActivityList.MODE_PAGE
            );

            app_context.startActivity(i);
        }

    }
}
