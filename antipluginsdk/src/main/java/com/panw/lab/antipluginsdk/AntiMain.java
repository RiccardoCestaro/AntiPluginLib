package com.panw.lab.antipluginsdk;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.panw.lab.antipluginsdk.AntiCheckCases.AntiCheckMainService;
import com.panw.lab.antipluginsdk.AntiCheckCases.BroadcastCheck;
import com.panw.lab.antipluginsdk.AntiCheckCases.Dummy.DummyRemoteService;
import com.panw.lab.antipluginsdk.AntiCheckCases.PackageChecker;
import com.panw.lab.antipluginsdk.AntiCheckCases.ServiceChecker;


/**
 * Created by tluo on 1/24/17.
 */

public class AntiMain {
    Context context;
    public AntiMain(Context context) {
        this.context = context;
    }
    static public void anti_log(){
        Log.e("Anti", "This is Anti Main");
    }
    public void isPlugin(){
        Log.e("Anti", "startToCheckPlugin");
        Log.i("Anti", "DiCiaoSonDiQua");
        this.context.startService(new Intent(this.context, DummyRemoteService.class));
        this.context.startService(new Intent(this.context, AntiCheckMainService.class));

        PackageChecker pc = new PackageChecker();
        pc.isPlugin(context,context.getPackageManager());

        BroadcastCheck bc = new BroadcastCheck();
        bc.isPlugin(context);

        ServiceChecker sc = new ServiceChecker();



        // ~/Downloads/Android/android-sdk-macosx/platform-tools/adb push app/build/outputs/apk/app-debug.apk /sdcard/Download/
    }
    @Override
    public String toString() {
        return "Anti Main";
    }
}
