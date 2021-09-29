package com.group_7.mhd.cooker.Common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.group_7.mhd.cooker.Model.Chaf;
import com.group_7.mhd.cooker.Model.Request;
import com.group_7.mhd.cooker.Model.User;
import com.group_7.mhd.cooker.Remote.APIService;
import com.group_7.mhd.cooker.Remote.FCMRetrofitClient;

import java.util.Calendar;
import java.util.Locale;

public class Common {
    public static final String SHIPPERS_TABLE = "Drivers";
    public static final String ORDER_NEED_SHIPPERS_TABLE = "Delivering";
    public static final String SHIPPERS_INFO_TABLE = "Delivered";
    public static final String ORDER_TABLE = "Order";
    public static final String CATEGORY_TABLE = "Category";
    public static final String CHAFS_TABLE = "Chafs";
    public static final String COMMENT_TABLE = "Comment";
    public static final String FOOD_TABLE = "Foods";
    public static final String TOKEN_TABLE = "Tokens";
    public static final String USER_TABLE = "User";

    public static String PHONE_TEXT = "userPhone";


    public static User currentUser;
    public static Request currentRequest;
    public static Chaf currentChaf;



    private static final String BASE_URL = "https://fcm.googleapis.com/";

    //public static Request currentRequest;
    public final static String UPDATE = "Update";
    public final static String DELETE = "Delete";
    public final static String USER_PHONE = "UserPhone";
    public final static String USER_PASSWORD = "UserPassword";
    public final static String USER_NAME = "UserName";
    public final static String CLIENT = "client";
    public final static String SERVER = "server";

    public final static String USER_KEY = "USER_KEY";
    public final static String PWD_KEY = "PWD_KEY";
    public static final int PIC_IMAGE_REQUEST = 71;


    public static String convertCodeToStatus(String status) {
        if (status.equals("0")) {
            return "Placed";
        } else if (status.equals("1")) {
            return "Payed";
        } else if (status.equals("2")) {
            return "Cooked";
        } else if (status.equals("3")) {
            return "Delivering";
        } else if (status.equals("4")){
            return "Delivered";
        } else{
            return "Cash On Delivery";
        }
    }

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
            /*assert connectivityManager != null;
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();*/
        }
        return false;
    }
    public static APIService getFCMClient() {
        return FCMRetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static String getDate(Long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(
                android.text.format.DateFormat.format("dd-MM-yyyy-HH:mm"
                        ,calendar)
                        .toString());
        return date.toString();
    }
}

