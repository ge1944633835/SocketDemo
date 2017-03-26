package com.mingdao.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.ConnectCallback;
import com.koushikdutta.async.http.socketio.SocketIOClient;
import com.koushikdutta.async.http.socketio.SocketIORequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    /**
     *  UI
     */
    private RecyclerView mRecyclerView;
    private EditText mInput;
    private Button mSendMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView= (RecyclerView) findViewById(R.id.ry);

        createConn();
    }



    /**
     * 与服务器建立连接
     */
    private void createConn() {
        String query = "t=16807&token=6c45b86796cc4ead8f12105a4ecef5b3&app=935527504";
        SocketIORequest request = new SocketIORequest(Constants.baseUrl, "", query);

        SocketIOClient.connect(AsyncHttpClient.getDefaultInstance(), request, new ConnectCallback() {
            @Override
            public void onConnectCompleted(Exception ex, SocketIOClient client) {
                if (ex != null) {
                    Log.d(TAG, "onConnectCompleted() returned: " + ex.toString());
                    return;
                }
                Log.d(TAG, "onConnectCompleted() returned: " + "连接成功");

                sendMessage(client);

                receiveMesg(client);
            }

        });
    }

    /**
     * 发送消息
     */
    public void sendMessage(SocketIOClient client) {

        try {
            JSONObject obj = new JSONObject();

            obj.put("type", 1);
            obj.put("msg", "发送一个消息");
            obj.put("touser", Constants.user);

            Log.d(TAG, "sendMessage() returned: " + obj);

            client.emit("send message", obj, new Acknowledge() {
                @Override
                public void acknowledge(JSONArray arguments) {
                    Log.d(TAG, "acknowledge() returned: " + arguments.toString());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  接收消息
     */
    public  void receiveMesg(SocketIOClient client){

        client.emitEvent("new message", new Acknowledge() {
            @Override
            public void acknowledge(JSONArray arguments) {
                Log.d(TAG, "接收消息: " + arguments.toString() );
            }
        });

    }

}
