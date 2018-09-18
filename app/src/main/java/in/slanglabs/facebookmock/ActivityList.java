package in.slanglabs.facebookmock;

public class ActivityList
{
    public static final String ACTIVITY_MODE = "activity_name";
    public static final String MODE_HOME = "home";
    public static final String MODE_PROFILE = "profile";
    public static final String MODE_LANGUAGE = "language";
    public static final String MODE_PAGE = "page";
    public static final String MODE_PAYMENT = "payment";

    public static int getImage(String mode)
    {
        int screen;

        //present particular screen according to the mode that is set
        switch (mode)
        {
            case MODE_PROFILE:
                screen = R.drawable.profile;
                break;

            case MODE_LANGUAGE:
                screen = R.drawable.language;
                break;

            case MODE_PAYMENT:
                screen = R.drawable.payment;
                break;

            case MODE_PAGE:
                screen = R.drawable.page;
                break;

            default:
                screen = R.drawable.home;
                break;

        }

        return screen;

    }
}
