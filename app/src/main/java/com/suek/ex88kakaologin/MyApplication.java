package com.suek.ex88kakaologin;

import android.app.Application;
import android.content.Context;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //카카오 SDK 와 앱의 Applicatin 을 연결
        //그 장치를 KakaoAdapter : 카카오와 앱을 연결하는 객체

        //카카오 초기화
        KakaoSDK.init(new KakaoAdapter() {
            @Override
            public IApplicationConfig getApplicationConfig() {   //추상메소드
                //이 Application 이 가지고있는 정보를 얻기위한 인터페이스  (....있으면 인터페이스)
                return new IApplicationConfig() {
                    @Override
                    public Context getApplicationContext() {
                        return MyApplication.this;   //나 를 리턴
                    }
                };
            }
        });
    }
}
