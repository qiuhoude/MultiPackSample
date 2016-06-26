package houde.multipack;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv_api_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv_api_address = (TextView) findViewById(R.id.tv_api_address);

        //获取manifest中的meta属性的值
        try {
            ApplicationInfo appInfo = getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String channel = appInfo.metaData.getString("UMENG_CHANNEL");
            tv.setText("是 【"+channel+"】 渠道的包");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        //获取静态api常量,在 build/source/buildConfig/...下
        tv_api_address.setText("服务器地址:" + BuildConfig.API_SERVER_URL);
    }
}
